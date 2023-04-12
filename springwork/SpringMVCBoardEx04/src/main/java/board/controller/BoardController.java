package board.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import board.dao.BoardDao;
import board.dao.MemberDao;
import board.dto.BoardDto;
import board.dto.MemberDto;

@Controller
public class BoardController {
	
	@Autowired
	MemberDao memberDao = new MemberDao();
	
	@Autowired
	BoardDao boardDao;
	
	@PostMapping("board/addboard")
	private String insertBoard(
			@ModelAttribute BoardDto dto,
			@RequestParam ArrayList<MultipartFile> upload,
			HttpServletRequest request,
			HttpSession session) {
		// TODO Auto-generated method stub
		//세션에 저장된 이메일 얻기
		String email = (String) session.getAttribute("loginemail");
		//그 이메일에 해다하는 member 테이블의 num값
		int num = memberDao.selectOneOfEmail(email).getNum();
		//dto에 num저장
		dto.setNum(num);
		
		//업로드할 경로
		String realPath = request.getSession().getServletContext().getRealPath("/resources/photo");
		String images="";
		System.out.println(realPath);
		//업로드 했을경우 파일명을 날짜로 변경해 보자
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String fname = sdf.format(new Date());
		
		//사진을 업로드 안했을 경우 db에 no라고 저장해보자
		if(upload.get(0).getOriginalFilename().equals("")) {//업로드를 안한경우			
			images="no";
		}else {
			int i = 0;
			for (MultipartFile mfile:upload) {
				String Originalname = mfile.getOriginalFilename();
				
				//. 를 기주능로나눠보자
				StringTokenizer st = new StringTokenizer(Originalname,".");
				String fileName = st.nextToken();
				String extName = st.nextToken();
				//System.out.println(fileName+extName);
				//파일명을 날짜로 변경하기 (뒤에 인덱스 붙이기)
				fileName = fname+"_"+ i++ +"."+extName;
				System.out.println(fileName);
				
				images += fileName+",";
				
				//사진 업로드
				try {
					mfile.transferTo(new File(realPath + "/" + fileName));
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//마지막 컴마 제거
			images = images.substring(0, images.length() -1);
		}
		
		//dto에 images 값 저장
		dto.setImages(images);
		
		//db에 저장
		boardDao.insertBoard(dto);
		
		return "redirect:list";
	}
	@GetMapping("/board/form")
	public String form(HttpSession session, Model model,@RequestParam int currentPage) {
		String email = (String) session.getAttribute("loginemail");
		MemberDto dto = memberDao.selectOneOfEmail(email);
		model.addAttribute("dto",dto);
		model.addAttribute("currentPage",currentPage);
		
		return "board/form";
	}
	
	@GetMapping("/board/list")
	public String list(HttpSession session, Model model,
				@RequestParam(defaultValue = "1") int currentPage //페이지 번호가 안넘어올 경우 무조건 1페이지를 보여준다
			) {
		String email = (String) session.getAttribute("loginemail");
		MemberDto dto = memberDao.selectOneOfEmail(email);
		
		model.addAttribute("dto",dto);
		
		//게시판의 총 글 갯수 얻기
		int totalCount = boardDao.getTotalCount();
		int totalPage;//총 페이지수
		int perPage = 3;//한페이지당 보여질 글 갯수
		int perBlock = 3;//한 블럭당 보여질 페이지의 갯수
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
		List<BoardDto> list = boardDao.getPagingList(startNum, perPage);
		
		//각 게시글에 글쓴사람의 name을 bdto에 저장하기
		for(BoardDto bdto:list) {
			//글쓴사람의 num
			int num = bdto.getNum();
			//num에 해당하는 사람의 이름
			String name="";
			try {
				name = memberDao.selectOneOfNum(num).getName();				
			} catch (Exception e) {
				// TODO: handle exception
				name="탈퇴한 회원";
			}
			//bdto에 저장
			bdto.setName(name);
			
		}
		
		//출력시 필요한 변수들을 model에 몽땅 저장
		
		model.addAttribute("totalCount",totalCount);
		model.addAttribute("list",list);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		model.addAttribute("totalPage",totalPage);
		model.addAttribute("currentPage",currentPage);
		model.addAttribute("no",no);
		
		return "board/list";
	}
	
	@GetMapping("/board/content")
	public String content(
				Model model, 
				@RequestParam int idx,
				@RequestParam int currentPage) {
				
				//조회수 증가
				boardDao.updateReadCount(idx);
		
				//System.out.println(idx);
				//board 테이블 dto 데이터를 얻는다
				BoardDto dto = boardDao.selectOneBoardOfIdx(idx);
				
				//num에 해당하는 name,photo를 얻어서 dto에 넣어준다				
				String name="", photo="";
				try {
					name = memberDao.selectOneOfNum(dto.getNum()).getName();
					photo = memberDao.selectOneOfNum(dto.getNum()).getPhoto();				
					
					dto.setName(name);
					dto.setPhoto(photo);
				} catch (NullPointerException e) {
					// TODO: handle exception
					dto.setName("탈퇴한 회원");
					dto.setPhoto("noimage.jpg");
				}
				
				//model에 dto,currentPage를 저장한다
				model.addAttribute("dto",dto);
				model.addAttribute("currentPage", currentPage);
				
		return "board/content";
	}
	@GetMapping("/board/delete")
	public String deleteBoard(@RequestParam int idx) {
		boardDao.deleteOfBoard(idx);
		return "redirect:list";
	}
	
	@GetMapping("/board/updateform")
	public String updateform(HttpSession session, @RequestParam int idx, Model model, @RequestParam int currentPage){	
		BoardDto dto =	boardDao.selectOneBoardOfIdx(idx);
		String name = memberDao.selectOneOfNum(dto.getNum()).getName();
		String photo = memberDao.selectOneOfNum(dto.getNum()).getPhoto();
		dto.setName(name);
		dto.setPhoto(photo);
		model.addAttribute("dto", dto);
		model.addAttribute("currentPage",currentPage);
		return "board/updateform";
	}
	
	@PostMapping("/board/updateOfBoard")
	public String updateOfBoard(@ModelAttribute BoardDto dto,
			@RequestParam ArrayList<MultipartFile> upload,
			HttpServletRequest request,
			HttpSession session,
			Model model, 
			@RequestParam int idx,
			@RequestParam int currentPage) {
		
		//세션에 저장된 이메일 얻기
				String email = (String) session.getAttribute("loginemail");
				//그 이메일에 해다하는 member 테이블의 num값
				int num = memberDao.selectOneOfEmail(email).getNum();
				//dto에 num저장
				dto.setNum(num);
				model.addAttribute("idx", idx);
				model.addAttribute("currentPage", currentPage);
				//업로드할 경로
				String realPath = request.getSession().getServletContext().getRealPath("/resources/photo");
				String images="";
				System.out.println(realPath);
				//업로드 했을경우 파일명을 날짜로 변경해 보자
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				String fname = sdf.format(new Date());
				
				//사진을 업로드 안했을 경우 db에 no라고 저장해보자
				if(upload.get(0).getOriginalFilename().equals("")) {//업로드를 안한경우			
					dto.setImages(null);
				}else {
					int i = 0;
					for (MultipartFile mfile:upload) {
						String Originalname = mfile.getOriginalFilename();
						
						//. 를 기주능로나눠보자
						StringTokenizer st = new StringTokenizer(Originalname,".");
						String fileName = st.nextToken();
						String extName = st.nextToken();
						//System.out.println(fileName+extName);
						//파일명을 날짜로 변경하기 (뒤에 인덱스 붙이기)
						fileName = fname+"_"+ i++ +"."+extName;
						System.out.println(fileName);
						
						images += fileName+",";
						
						//사진 업로드
						try {
							mfile.transferTo(new File(realPath + "/" + fileName));
						} catch (IllegalStateException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					//마지막 컴마 제거
					images = images.substring(0, images.length() -1);
					//dto에 images 값 저장
					dto.setImages(images);
				}			

				//db에 저장
				boardDao.updateOfBoard(dto);
			
		return "redirect:content?currentPage=" + currentPage;
		
	}
}
