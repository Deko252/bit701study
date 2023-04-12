package board.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import board.dao.MemberDao;
import board.dto.MemberDto;

@Controller
public class MemberController {
	
	@Autowired
	private MemberDao memberDao;

	@GetMapping("/member/form")
	public String form(Model model)
	{
		//���Ե� �� �ο����� ������ ����ϱ� ���� ���� ��´�
		int totalCount=memberDao.getTotalCount();
		//request �� ����
		model.addAttribute("totalCount", totalCount);
		
		return "member/form";
	}
	
	@PostMapping("/member/addmember")
	public String insertMember(
			@ModelAttribute MemberDto dto,
			@RequestParam MultipartFile upload,
			HttpServletRequest request)
	{
		//���ε��� ���� ��� ���ϱ�
		String realFolder=request.getSession().getServletContext().getRealPath("/resources/photo");
		//���� ���ε�
		String photo = upload.getOriginalFilename();//���ε��� ���ϸ�
		System.out.println(realFolder);
		try {
			upload.transferTo(new File(realFolder+"/"+photo));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dto.setPhoto(photo);
		
		//insert
		memberDao.insertMemeber(dto);
		//ȸ������ ������ ��� ������� �̵�
		
		return "redirect:list";
	}
	
	@GetMapping("/member/list")
	public String listMember(Model model)
	{
		int totalCount=memberDao.getTotalCount();
		List<MemberDto> list = memberDao.getAllMember();
		
		model.addAttribute("totalCount",totalCount);
		model.addAttribute("list", list);
		
		return "member/list";
	}
	
	@GetMapping("/member/delete")
	public String delete(@RequestParam int num) {
		memberDao.deleteMember(num);
		return "redirect:./list";
	}
	
	//json���� ��ȯ�ϴ� �޼���
	//@Controller �ϰ��� json ��ȯ�� ��� @ResponseBody�� ���δ�
	//@RestController�� ���� ������ json���� ó���ǹǷ� @ResponseBody�� �Ⱥ��δ�
	@GetMapping("/member/isemail")
	public @ResponseBody Map<String, String>emailProcess(@RequestParam String email){
		//�ش� �̸��� �� �����ϸ� 1 �������������� 2
		
		int count = memberDao.isEqualEmail(email);
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", count==0?"success":"fail");
		return map;
	}
	
	@GetMapping("/member/updateform")
	public String updateform(@RequestParam int num, Model model){	
		MemberDto dto =	memberDao.selectOneOfNum(num);
		model.addAttribute("dto", dto);
		
		return "member/updateform";
	}
	
	@PostMapping("/member/updateMember")
	public String updateMember(
			@ModelAttribute  MemberDto dto,
			@RequestParam MultipartFile upload,
			HttpServletRequest request) {
		//���ε��� ���� ��� ���ϱ�
				String realFolder=request.getSession().getServletContext().getRealPath("/resources/photo");
				//���� ���ε�
				String photo = upload.getOriginalFilename();//���ε��� ���ϸ�
				System.out.println(realFolder);
				if (photo.equals("")) {
					dto.setPhoto(null);
				}else {
					
				try {
					upload.transferTo(new File(realFolder+"/"+photo));
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				dto.setPhoto(photo);
				}
				
				//insert
				memberDao.updateMember(dto);
				//ȸ������ ������ ��� ������� �̵�
				
				return "redirect:list";
	}
	
	
}