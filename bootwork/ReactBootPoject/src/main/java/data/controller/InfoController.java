package data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import data.dto.InfoDto;
import data.service.InfoServiceInter;
import naver.cloud.NcpObjectStorageService;

@RestController
@CrossOrigin
@RequestMapping("/info")
public class InfoController {

	@Autowired
	private InfoServiceInter infoService;
	
	
	private String bucketName="bit701-bucket-114";//각자 자기 버켓이름
	
	//String bucketPath = "https://kr.object.ncloudstorage.com/bit701-bucket-114/react/";
	
	@Autowired
	private NcpObjectStorageService storageService;
	
	@PostMapping("/insert")
	public InfoDto insertInfo(@RequestBody InfoDto dto) {
		System.out.println("insert >> " + dto);
		infoService.insertInfo(dto);
		System.out.println("insert 된 num값 = " + dto.getNum());
		return dto;
	}
	
	@PostMapping("/photo")
	public String updatephoto(@RequestParam int num, @RequestParam MultipartFile upload) {
		//System.out.println("update>>"+num+">>"+upload.getOriginalFilename());
		System.out.println("update>>"+upload.getOriginalFilename());
		//스토리지에 사진을 업로드후 업로드된 이름을 반환
		String uploadName=storageService.uploadFile(bucketName, "react", upload);
		//사진 수정
		infoService.updatePhoto(num, uploadName);
		//사진경로 반환
		return uploadName;
	}
	
	@GetMapping("/list")
	public List<InfoDto> list(){
		System.out.println("list >> ");
		return infoService.list();
	}
	
	@DeleteMapping("/delete/{num}")
	public void deleteInfo(@PathVariable int num) {
		System.out.println("delete >> " + num);
		//num에 해당하는 이미지명 얻기
		String photo = infoService.getData(num).getPhoto();
		//bucket 에서 삭제
		storageService.deleteFile(bucketName, "react", photo);
		//db에서 데이터 삭제
		infoService.deleteInfo(num);
	}
	
	@PostMapping("/update")
	public void updateInfo(@RequestBody InfoDto dto) {
		System.out.println("update >> " + dto);
		infoService.updateData(dto);
	}
}
