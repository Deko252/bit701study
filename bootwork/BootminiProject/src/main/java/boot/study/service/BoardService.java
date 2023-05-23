package boot.study.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.study.dto.BoardDto;
import boot.study.mapper.BoardMapper;

@Service
public class BoardService implements BoardServiceInter{
	
	@Autowired
	private BoardMapper boardMapper;


	@Override
	public int getMaxNum() {
		// TODO Auto-generated method stub
		return boardMapper.getMaxNum();
	}

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return boardMapper.getTotalCount();
	}

	@Override
	public void updateStep(int ref, int step) {
		// TODO Auto-generated method stub
		Map<String, Integer> map=new HashMap<>();
		map.put("ref", ref);
		map.put("step", step);
		
		boardMapper.updateStep(map);
	}

	@Override
	public void insertBoard(BoardDto dto) {
		// TODO Auto-generated method stub
		//새글인지 답글인지 판단
		int ref = dto.getRef();
		int step = dto.getStep();
		int depth = dto.getDepth();
		if(dto.getNum() == 0) {
			//새글인 경우
			step = 0;
			depth = 0;
			ref = boardMapper.getMaxNum()+1;//새 그룹번호를 겹치지 않는 값으로 만들기 위해서
			
		}else {
			//답글인경우
			//전달받은 그룹중 step보다 큰값이 있는경우 모두 +1을 한다.
			this.updateStep(ref, step);
			//그리고 나서 전달받은 step과 depth에 1을 증가 시킨다.
			step++;
			depth++;
		}
		dto.setRef(ref);
		dto.setStep(step);
		dto.setDepth(depth);
		
		boardMapper.insertBoard(dto);
	}

	@Override
	public List<BoardDto> getPagingList(int start, int perpage) {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<>();
		map.put("start", start);
		map.put("perpage", perpage);
		
		return boardMapper.getPagingList(map);
	}

	@Override
	public void updateReadcount(int num) {
		// TODO Auto-generated method stub
		boardMapper.updateReadcount(num);	
	}

	@Override
	public BoardDto getData(int num) {
		// TODO Auto-generated method stub
		return boardMapper.getData(num);	
	}
		
	@Override
	public boolean isEqualPass(int num, String pass) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("num", num);
		map.put("pass", pass);
		//System.out.println(pass);
		//비밀번호가 맞으면 1->true반환,틀리면 0->false반환
		boolean b = boardMapper.isEqualPass(map)==0?false:true;
		return b;
	}

	@Override
	public void deleteBoard(int num) {
		// TODO Auto-generated method stub
		boardMapper.deleteBoard(num);
	}
	
	@Override
	public void updateBoard(BoardDto dto) {
		// TODO Auto-generated method stub
		boardMapper.updateBoard(dto);
	}
	
}
