package board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import board.dao.AnswerDao;
import board.dao.MemberDao;
import board.dto.AnswerDto;

@RestController
public class AnswerController {
	
	@Autowired
	MemberDao memberDao;
	
	@Autowired
	AnswerDao answerDao;
	
	//댓글 insert
	@GetMapping("/board/ainsert")
	public void insertAnswer(@RequestParam String content, @RequestParam int idx, @RequestParam int num) {
		
		
		//dto에 담기
		AnswerDto dto = new AnswerDto();
		dto.setContent(content);
		dto.setIdx(idx);
		dto.setNum(num);
		
		answerDao.insertAnswer(dto);
	
		
	}
	@GetMapping("/board/alist")
	//댓글 list
	public List<AnswerDto> getAllAnswers(@RequestParam int idx){
		
		List<AnswerDto> list =answerDao.getAllAnswers(idx);//list가 json형태로 반환
		for (AnswerDto dto : list) {
			try {
				//member 테이블로부터 name photo를 얻어서 dto에 넣는다
				String name = memberDao.selectOneOfNum(dto.getNum()).getName();
				String photo = memberDao.selectOneOfNum(dto.getNum()).getPhoto();
				
				dto.setName(name);
				dto.setPhoto(photo);				
			} catch (NullPointerException e) {
				//해당 num이 없을경우 널포인트이셉션 발생
				dto.setName("탈퇴한 회원입니다.");
				dto.setPhoto("noimage.jpg");
			}
		}
		return list;
	}
	
	@GetMapping("/board/adelete")
	public void deleteOfAnswer(@RequestParam int seq){
		answerDao.deleteAnswer(seq);

	}
}
