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
		//로그인 여부를 판단할 세션
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
			@RequestParam(required = false) String saveemail, //체크 안했을때 null을 보냄
			//@RequestParam(defaultValue = "no") String saveemail //체크 안했을때 no를 보냄
			HttpSession session) {
		
		//이메일과 비번이 맞는지부터 체크
		int count = memberDao.isEqualPassEmail(email, pass);
		if(count == 1) {//이메일과 비번이 맞는경우 1반환
			//세션시간 
			session.setMaxInactiveInterval(60*60*5); //5시간
			//로그인 성공시 세션에 저장하기
			session.setAttribute("loginok","yes");
			session.setAttribute("loginemail", email);
			session.setAttribute("saveemail", saveemail==null?"no":"yes");
			//로그인한 사람의 num값을 얻어서 세션에 저장하기
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
