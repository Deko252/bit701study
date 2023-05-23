package boot.study.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import boot.study.dto.BoardDto;
import boot.study.service.BoardService;
import naver.cloud.NcpObjectStorageService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private NcpObjectStorageService storageService;
	
	//버켓이름지정
	private String bucketName="bit701-bucket-114";//각자 자기 버켓이름
	//private String bucketName="bit701-bucket-56"; //선생님꺼
	
	
	@GetMapping("list")
	public String list(@RequestParam(defaultValue = "1") int currentPage ,Model model) {
		
		//게시판의 총 글 갯수 얻기
				int totalCount = boardService.getTotalCount();
				int totalPage;//총 페이지수
				int perPage = 10;//한페이지당 보여질 글 갯수
				int perBlock = 10;//한 블럭당 보여질 페이지의 갯수
				int startNum; //각페이지에서 보여질 글의 시작번호
				int startPage;//각 블럭에서 보여질 시작페이지 번호
				int endPage;//각 블럭에서 보여질 끝 페이지 번호
				int no; //글 출력시 출력할 시작 번호
				
				//총 페이지수
				totalPage = totalCount/perPage+(totalCount%perPage==0?0:1); // 11/3 = 3+1
				
				//시작페이지
				startPage=(currentPage-1)/perBlock*perBlock+1;
				
				//끝페이지
				endPage=startPage+perBlock-1;
				
				//이때 문제점 endPage가 totalpage보다 크면안된다
				if(endPage>totalPage) {
					endPage=totalPage;
				}
				
				//각 페이지의 시작번호(1페이지 : 0, 2페이지 :3 , 3페이지 6)
				startNum=(currentPage-1)*perPage;
				
				//각 글마다 출력할 글번호(예: 10개일경우 1페이지:10 2페이지 2
				no = totalCount-startNum;
				
				//각 페이지에 필효한 게시글 db에서 가지고오기
				List<BoardDto> list = boardService.getPagingList(startNum, perPage);
				
				//출력시 필요한 변수들을 model에 몽땅 저장				
				model.addAttribute("totalCount",totalCount);
				model.addAttribute("list",list);
				model.addAttribute("startPage",startPage);
				model.addAttribute("endPage",endPage);
				model.addAttribute("totalPage",totalPage);
				model.addAttribute("currentPage",currentPage);
				model.addAttribute("no",no);
		
		return "/main/board/boardlist";
	}
	
	//폼이 원글폼 일수도 답글폼 일수도 있음
	@GetMapping("/writeform")
	public String form(
			@RequestParam(defaultValue = "1") int currentPage,
			@RequestParam(defaultValue = "0") int num,
			@RequestParam(defaultValue = "0") int ref,
			@RequestParam(defaultValue = "0") int step,
			@RequestParam(defaultValue = "0") int depth,
			Model model
			) {
		
		String subject ="";
		//답글일 경우 제목은 나오게 하기위해서 제목 구하기
		if(num > 0) {
			subject = boardService.getData(num).getSubject();
		}
		
		model.addAttribute("currentPage",currentPage);
		model.addAttribute("num",num);
		model.addAttribute("ref",ref);
		model.addAttribute("step",step);
		model.addAttribute("depth",depth);
		model.addAttribute("subject", subject);
		
		return "/main/board/boardform";
	}
	
	@PostMapping("/insert")
	public String insert(BoardDto dto, MultipartFile upload) {
		
		String fliename="";
		//업로드를 한경우에만 버킷에 이미지를 올린다
		if(!upload.getOriginalFilename().equals("")) {
			fliename = storageService.uploadFile(bucketName, "board", upload);
		}
		
		//dto에 파일명 저장
		dto.setFilename(fliename);
		boardService.insertBoard(dto);
		
		return "redirect:list";
	}
	
	@GetMapping("/content")
	public String content(int num, int currentPage, Model model) {
		
		//조회수 증가
		boardService.updateReadcount(num);
		
		//dto 얻기
		BoardDto dto = boardService.getData(num);
		
		//model저장
		model.addAttribute("dto",dto);
		model.addAttribute("currentPage",currentPage);
		
		return "/main/board/content";
	}
	
	@GetMapping("/delete")
	@ResponseBody public Map<String, String> delete(int num, String pass){
		Map<String ,String> map = new HashMap<>();
		//비밀번호가 맞을경우 map에 result -> success를 넣고 버켓의 사진을 지우고 db에 글 지우기
		//틀릴경우 map에 result -> fail을 넣고 얼랏으로 비밀번호가 틀리다고 알려주기
		boolean b = boardService.isEqualPass(num, pass);
		//System.out.println(num + "num" + pass + "pass");
		if(b) {
			map.put("result", "success");
			//db 삭제전에 저장된 이미지를 버켓에서 지운다
			String filename = boardService.getData(num).getFilename();
			storageService.deleteFile(bucketName, "board", filename);
			//db삭제
			boardService.deleteBoard(num);
		}else {
			map.put("result", "fail");
		}
		return map;
		
	}
	
	@GetMapping("/updatepass")
	@ResponseBody public Map<String, String> updatepass(int num, String pass){
		Map<String ,String> map = new HashMap<>();
		//비밀번호가 맞을경우 map에 result -> success를 넣고 버켓의 사진을 지우고 db에 글 지우기
		//틀릴경우 map에 result -> fail을 넣고 얼랏으로 비밀번호가 틀리다고 알려주기
		boolean b = boardService.isEqualPass(num, pass);
		//System.out.println(num + "num" + pass + "pass");
		if(b) {
			map.put("result", "success");
		}else {
			map.put("result", "fail");
		}
		return map;
	}
	
	@GetMapping("/updateform")
	public String updateform(int num, int currentPage, Model model) {
		BoardDto dto = boardService.getData(num);
		
		model.addAttribute("dto",dto);
		model.addAttribute("currentPage",currentPage);
		
		return "/main/board/updateform";
	}
	
	@PostMapping("/update")
	public String update (BoardDto dto, MultipartFile upload, int currentPage) {
		String filename = ""; 
		//사진선택을 한경우 기존 사진을 버켓에서 지우고 다시 업로드한다
		if(!upload.getOriginalFilename().equals("")) {
			//기존 파일명 알아내기
			filename = boardService.getData(dto.getNum()).getFilename();
			//버켓에서 삭제
			storageService.deleteFile(bucketName, "board", filename);
			
			//다시 업로드후 업로드한 파일명 얻기
			filename=storageService.uploadFile(bucketName, "board", upload);
			
		}
		dto.setFilename(filename);
		
		//수정
		boardService.updateBoard(dto);
		
		return "redirect:./content?num=" + dto.getNum() + "&currentPage=" + currentPage;
	}
}
