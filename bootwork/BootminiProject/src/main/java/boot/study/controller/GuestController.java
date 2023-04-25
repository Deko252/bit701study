package boot.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GuestController {
	@GetMapping("/guest/list")
	public String guest() {
		return "/sub/guest/guestlist";
	}
}
