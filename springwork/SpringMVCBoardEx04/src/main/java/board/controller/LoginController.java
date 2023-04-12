package board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysql.cj.Session;

import board.dao.MemberDao;

@Controller
public class LoginController {
	
	@Autowired
	MemberDao memberDao = new MemberDao();
	
	@GetMapping("/login/form")
	public String form(HttpSession session) {
		//�α��� ���θ� �Ǵ��� ����
		String loginok = (String) session.getAttribute("loginok");
		
		if(loginok == null) {
			return "login/login";			
		}else {
			return "login/logout";
		}
	}
	
	@PostMapping("/login/loginaction")
	public String loginAction(
			@RequestParam String email,
			@RequestParam String pass,
			@RequestParam(required = false) String saveemail, //üũ �������� null�� ����
			//@RequestParam(defaultValue = "no") String saveemail //üũ �������� no�� ����
			HttpSession session) {
		
		//�̸��ϰ� ����� �´������� üũ
		int count = memberDao.isEqualPassEmail(email, pass);
		if(count == 1) {//�̸��ϰ� ����� �´°�� 1��ȯ
			//���ǽð� 
			session.setMaxInactiveInterval(60*60*5); //5�ð�
			//�α��� ������ ���ǿ� �����ϱ�
			session.setAttribute("loginok","yes");
			session.setAttribute("loginemail", email);
			session.setAttribute("saveemail", saveemail==null?"no":"yes");
			//�α����� ����� num���� �� ���ǿ� �����ϱ�
			int num = memberDao.selectOneOfEmail(email).getNum();
			session.setAttribute("loginnum", num);
			
			return "redirect:../board/list";
		}
			return "login/logindetail";
	}
	
	@GetMapping("/login/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginok");
		return "redirect:form";
	}
	
}
