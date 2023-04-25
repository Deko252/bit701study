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
	
	//��� insert
	@GetMapping("/board/ainsert")
	public void insertAnswer(@RequestParam String content, @RequestParam int idx, @RequestParam int num) {
		
		
		//dto�� ���
		AnswerDto dto = new AnswerDto();
		dto.setContent(content);
		dto.setIdx(idx);
		dto.setNum(num);
		
		answerDao.insertAnswer(dto);
	
		
	}
	@GetMapping("/board/alist")
	//��� list
	public List<AnswerDto> getAllAnswers(@RequestParam int idx){
		
		List<AnswerDto> list =answerDao.getAllAnswers(idx);//list�� json���·� ��ȯ
		for (AnswerDto dto : list) {
			try {
				//member ���̺�κ��� name photo�� �� dto�� �ִ´�
				String name = memberDao.selectOneOfNum(dto.getNum()).getName();
				String photo = memberDao.selectOneOfNum(dto.getNum()).getPhoto();
				
				dto.setName(name);
				dto.setPhoto(photo);				
			} catch (NullPointerException e) {
				//�ش� num�� ������� ������Ʈ�̼��� �߻�
				dto.setName("Ż���� ȸ���Դϴ�.");
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
