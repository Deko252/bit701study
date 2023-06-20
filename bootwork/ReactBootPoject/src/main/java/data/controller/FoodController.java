package data.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import data.dto.FoodDto;
import data.service.FoodService;
import naver.cloud.NcpObjectStorageService;

@RestController
@CrossOrigin
@RequestMapping("/react")
public class FoodController {
	
	@Autowired
	private FoodService foodService;
	
	@Autowired
	private NcpObjectStorageService storageService;
	
	//버킷 이름지정
	private String bucketName="bit701-bucket-114";//각자 자기 버켓이름
	
	//여러장의 사진명이 저장될 list 변수
	List<String> foodNames = new ArrayList<>();
	
	@PostMapping("upload")
	public List<String> photoUpload(@RequestParam List<MultipartFile> upload){
		
		//기존 버킷의 사진 지우기
		if(foodNames.size()>0) {
			for(String photo:foodNames) {
				storageService.deleteFile(bucketName, "food", photo);
			}
			foodNames.clear();
		}
		
		//버킷에 여러장의 사진 저장
		for(MultipartFile file:upload) {
			String uploadNmae = storageService.uploadFile(bucketName,"food",file);
			foodNames.add(uploadNmae);
		}
		return foodNames;
	}
	
	@PostMapping("/insert")
	public void insert(@RequestBody FoodDto dto) {
		//사진은 따로 저장
		String photo = "";
		for(String fname:foodNames) {
			photo += fname + ",";
		}
		photo = photo.substring(0,photo.length() -1);
		//dto 에 저장
		dto.setFphoto(photo);
		//db insert
		foodService.insertFood(dto);
		
		//스토리지에 저장된 사진 변수 비워주기
		foodNames.clear();
	}
	@GetMapping("/list")
	public List<FoodDto> list(){
		return foodService.getAllFood();
	}
}
