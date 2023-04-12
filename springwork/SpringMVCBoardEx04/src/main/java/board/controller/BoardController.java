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
		//���ǿ� ����� �̸��� ���
		String email = (String) session.getAttribute("loginemail");
		//�� �̸��Ͽ� �ش��ϴ� member ���̺��� num��
		int num = memberDao.selectOneOfEmail(email).getNum();
		//dto�� num����
		dto.setNum(num);
		
		//���ε��� ���
		String realPath = request.getSession().getServletContext().getRealPath("/resources/photo");
		String images="";
		System.out.println(realPath);
		//���ε� ������� ���ϸ��� ��¥�� ������ ����
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String fname = sdf.format(new Date());
		
		//������ ���ε� ������ ��� db�� no��� �����غ���
		if(upload.get(0).getOriginalFilename().equals("")) {//���ε带 ���Ѱ��			
			images="no";
		}else {
			int i = 0;
			for (MultipartFile mfile:upload) {
				String Originalname = mfile.getOriginalFilename();
				
				//. �� ���ִɷγ�������
				StringTokenizer st = new StringTokenizer(Originalname,".");
				String fileName = st.nextToken();
				String extName = st.nextToken();
				//System.out.println(fileName+extName);
				//���ϸ��� ��¥�� �����ϱ� (�ڿ� �ε��� ���̱�)
				fileName = fname+"_"+ i++ +"."+extName;
				System.out.println(fileName);
				
				images += fileName+",";
				
				//���� ���ε�
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
			//������ �ĸ� ����
			images = images.substring(0, images.length() -1);
		}
		
		//dto�� images �� ����
		dto.setImages(images);
		
		//db�� ����
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
				@RequestParam(defaultValue = "1") int currentPage //������ ��ȣ�� �ȳѾ�� ��� ������ 1�������� �����ش�
			) {
		String email = (String) session.getAttribute("loginemail");
		MemberDto dto = memberDao.selectOneOfEmail(email);
		
		model.addAttribute("dto",dto);
		
		//�Խ����� �� �� ���� ���
		int totalCount = boardDao.getTotalCount();
		int totalPage;//�� ��������
		int perPage = 3;//���������� ������ �� ����
		int perBlock = 3;//�� ���� ������ �������� ����
		int startNum; //������������ ������ ���� ���۹�ȣ
		int startPage;//�� ������ ������ ���������� ��ȣ
		int endPage;//�� ������ ������ �� ������ ��ȣ
		int no; //�� ��½� ����� ���� ��ȣ
		
		//�� ��������
		totalPage = totalCount/perPage+(totalCount%perPage==0?0:1); // 11/3 = 3+1
		
		//����������
		startPage=(currentPage-1)/perBlock*perBlock+1;
		
		//��������
		endPage=startPage+perBlock-1;
		
		//�̶� ������ endPage�� totalpage���� ũ��ȵȴ�
		if(endPage>totalPage) {
			endPage=totalPage;
		}
		
		//�� �������� ���۹�ȣ(1������ : 0, 2������ :3 , 3������ 6)
		startNum=(currentPage-1)*perPage;
		
		//�� �۸��� ����� �۹�ȣ(��: 10���ϰ�� 1������:10 2������ 2
		no = totalCount-startNum;
		
		//�� �������� ��ȿ�� �Խñ� db���� ���������
		List<BoardDto> list = boardDao.getPagingList(startNum, perPage);
		
		//�� �Խñۿ� �۾������ name�� bdto�� �����ϱ�
		for(BoardDto bdto:list) {
			//�۾������ num
			int num = bdto.getNum();
			//num�� �ش��ϴ� ����� �̸�
			String name="";
			try {
				name = memberDao.selectOneOfNum(num).getName();				
			} catch (Exception e) {
				// TODO: handle exception
				name="Ż���� ȸ��";
			}
			//bdto�� ����
			bdto.setName(name);
			
		}
		
		//��½� �ʿ��� �������� model�� ���� ����
		
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
				
				//��ȸ�� ����
				boardDao.updateReadCount(idx);
		
				//System.out.println(idx);
				//board ���̺� dto �����͸� ��´�
				BoardDto dto = boardDao.selectOneBoardOfIdx(idx);
				
				//num�� �ش��ϴ� name,photo�� �� dto�� �־��ش�				
				String name="", photo="";
				try {
					name = memberDao.selectOneOfNum(dto.getNum()).getName();
					photo = memberDao.selectOneOfNum(dto.getNum()).getPhoto();				
					
					dto.setName(name);
					dto.setPhoto(photo);
				} catch (NullPointerException e) {
					// TODO: handle exception
					dto.setName("Ż���� ȸ��");
					dto.setPhoto("noimage.jpg");
				}
				
				//model�� dto,currentPage�� �����Ѵ�
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
		
		//���ǿ� ����� �̸��� ���
				String email = (String) session.getAttribute("loginemail");
				//�� �̸��Ͽ� �ش��ϴ� member ���̺��� num��
				int num = memberDao.selectOneOfEmail(email).getNum();
				//dto�� num����
				dto.setNum(num);
				model.addAttribute("idx", idx);
				model.addAttribute("currentPage", currentPage);
				//���ε��� ���
				String realPath = request.getSession().getServletContext().getRealPath("/resources/photo");
				String images="";
				System.out.println(realPath);
				//���ε� ������� ���ϸ��� ��¥�� ������ ����
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				String fname = sdf.format(new Date());
				
				//������ ���ε� ������ ��� db�� no��� �����غ���
				if(upload.get(0).getOriginalFilename().equals("")) {//���ε带 ���Ѱ��			
					dto.setImages(null);
				}else {
					int i = 0;
					for (MultipartFile mfile:upload) {
						String Originalname = mfile.getOriginalFilename();
						
						//. �� ���ִɷγ�������
						StringTokenizer st = new StringTokenizer(Originalname,".");
						String fileName = st.nextToken();
						String extName = st.nextToken();
						//System.out.println(fileName+extName);
						//���ϸ��� ��¥�� �����ϱ� (�ڿ� �ε��� ���̱�)
						fileName = fname+"_"+ i++ +"."+extName;
						System.out.println(fileName);
						
						images += fileName+",";
						
						//���� ���ε�
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
					//������ �ĸ� ����
					images = images.substring(0, images.length() -1);
					//dto�� images �� ����
					dto.setImages(images);
				}			

				//db�� ����
				boardDao.updateOfBoard(dto);
			
		return "redirect:content?currentPage=" + currentPage;
		
	}
}
