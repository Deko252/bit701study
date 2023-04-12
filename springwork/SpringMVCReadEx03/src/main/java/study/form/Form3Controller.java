package study.form;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import study.dto.ShopDto;

@Controller
public class Form3Controller {
	
	@GetMapping	("/form3")
	public String form3() {
		return "myform/form3";
	}
	
	@PostMapping("/read3")
	//@ModelAttribute: 같은 이름은 자동으로 읽어오고 model에 저장
	//model에 저장되는 이름 shopDto 이름으로 모델에 저장됨
	//다른 이름으로 저장하고 싶을경우 @ModelAttribute("이름")
	//@ModelAttribute 생략가능
	public ModelAndView read3(@RequestParam Map<String, String> map) {
		
		ModelAndView mview = new ModelAndView();
		
		mview.addObject("name", map.get("name"));
		mview.addObject("addr", map.get("addr"));
		mview.addObject("hp", map.get("hp"));
		mview.addObject("sajin", map.get("sajin"));
		
		
		mview.setViewName("result/readdata3");
		return mview;
	}
}
