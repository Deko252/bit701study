package board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import board.dto.BoardDto;
import board.dto.MemberDto;

@Repository
public class BoardDao {
	@Autowired
	private SqlSession session;
	
	
	String nameSpace="board.dao.BoardDao.";
	
	public int getTotalCount() {
		return session.selectOne(nameSpace + "totalCountOfBoard");
	}
	
	public List<BoardDto> getPagingList(int start, int perpage){
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("perpage", perpage);
		
		return session.selectList(nameSpace + "pagingListOfBoard" ,map);
		
	}
	
	public void insertBoard(BoardDto dto) {
		session.insert(nameSpace + "insertOfBoard", dto); 
	}
	
	public void updateReadCount(int idx) {
		session.update(nameSpace + "updateReadCount", idx);
	}
	
	public BoardDto selectOneBoardOfIdx(int idx) {
		return session.selectOne(nameSpace + "selectOneBoardOfIdx", idx);
	}
	public void deleteOfBoard(int idx) {
		session.delete(nameSpace + "deleteOfBoard", idx);
	}
	public BoardDto updateform(int idx, int currentPage) {
		return session.selectOne(nameSpace + "updateform", idx);
	}
	
	public void updateOfBoard(BoardDto dto) {
		session.update(nameSpace + "updateOfBoard", dto);
	}
}
