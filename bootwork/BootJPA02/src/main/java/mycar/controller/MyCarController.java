package mycar.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import mycar.data.MyCarDao;
import mycar.data.MyCarDto;

@Controller
public class MyCarController {
	
	@Autowired
	MyCarDao mycarDao;
	
	@GetMapping("/mycarform")
	public String form() {
		return "mycarform";
	}
	
	@GetMapping("/")
	public String home(Model model) {
		//총 갯수
		Long totalCount = mycarDao.getTotalCount();
		
		//전체데이터 가져오기
		List<MyCarDto>list = mycarDao.getAllcars();
		
		model.addAttribute("list",list);
		model.addAttribute("totalCount", totalCount);
		return "mycarlist";
	}
	
	@PostMapping("/addcar")
	public String insert(MyCarDto dto, MultipartFile upload, HttpServletRequest request) {
		//업로드할 경로 구하기
		String realpath = request.getSession().getServletContext().getRealPath("/save");
		
		//파일명 dto에 저장
		dto.setCarphoto(upload.getOriginalFilename());
		
		//파일 업로드
		try {
			upload.transferTo(new File(realpath + "/" + upload.getOriginalFilename()));
			//db insert
			mycarDao.insertCar(dto);
		} catch (IllegalStateException | IOException e) {
			// TODO: handle exception
		}

		return "redirect:./";
	}
	
	@GetMapping("/detail")
	public String detail(Model model, @RequestParam Long num) {
		MyCarDto dto = mycarDao.getMyCar(num);
		model.addAttribute("dto", dto);
		return "detailcar";
	}
	
	@GetMapping("/updatecar")
	public String updatecar(Model model, Long num) {
		MyCarDto dto = mycarDao.getMyCar(num);
		
		model.addAttribute("dto",dto);
		return "mycarupdateform";
		
	}
	@PostMapping("/update")
	public String update(MyCarDto dto, MultipartFile upload, HttpServletRequest request) {
		//업로드할 경로 구하기
		String realpath = request.getSession().getServletContext().getRealPath("/save");
		
		//파일명 dto에 저장
		if(upload.getOriginalFilename().equals("")) {
			//업로드을 안할경우 기존 이름으로 넣는다.
			String photo = mycarDao.getMyCar(dto.getNum()).getCarphoto();
			dto.setCarphoto(photo);
		}else {
			dto.setCarphoto(upload.getOriginalFilename());
			
			//파일 업로드
			try {
				upload.transferTo(new File(realpath + "/" + upload.getOriginalFilename()));
				//db update
				mycarDao.updateCar(dto);
			} catch (IllegalStateException | IOException e) {
				// TODO: handle exception
			}
			
		}

		return "redirect:./detail?num=" + dto.getNum();
	}
	
	@GetMapping("/deletecar")
	public String deletecar(@RequestParam Long num) {
		mycarDao.deletecar(num);
		return "redirect:./";
	}
	
	@GetMapping("/ajaxlist")
	public String list() {
		return "ajaxlist";
	}
}
