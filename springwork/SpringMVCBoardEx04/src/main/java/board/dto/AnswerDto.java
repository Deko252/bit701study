package board.dto;

import java.sql.Timestamp;

public class AnswerDto {
	private int seq;
	private int idx;
	private int num;
	private String content;
	private String name;
	private String photo;
	private Timestamp writeday;
	
	
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Timestamp getWriteday() {
		return writeday;
	}
	public void setWriteday(Timestamp writeday) {
		this.writeday = writeday;
	}
	
	
}
