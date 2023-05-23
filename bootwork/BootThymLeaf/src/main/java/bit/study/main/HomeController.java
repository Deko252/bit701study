package bit.study.main;

import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	List<ShopDto> list = new Vector<>();
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("message","Happy Day!!");
		
		ShopDto dto = ShopDto.builder()
				.sang("복숭아")
				.su(5)
				.dan(1200)
				.build();
		
		model.addAttribute("dto",dto);
		return "home";
	}
	@GetMapping("/list")
	public String list(Model model) {
		
		list.clear();
		list.add(new ShopDto("코로나", "corona.jpg",2,951000));
		list.add(new ShopDto("졸려", "Zzz.png",10,9000));
		
		model.addAttribute("list", list);
		return "list";
	}
	
	@GetMapping("/detail")
	public String detail(int index, Model model, HttpSession session) {
		
		session.setAttribute("loginid", "admin");
		model.addAttribute("dto", list.get(index));
		return "detail";
	}
}
