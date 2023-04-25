package board.dto;

import java.sql.Timestamp;

public class BoardDto {
	private int idx;
	private int num;
	private String subject;
	private String content;
	private String images;
	private int readcount;
	private Timestamp writeday;
	private String name;
	private String photo;
	private int acount;
	
	public int getAcount() {
		return acount;
	}
	public void setAcount(int acount) {
		this.acount = acount;
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
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public Timestamp getWriteday() {
		return writeday;
	}
	public void setWriteday(Timestamp writeday) {
		this.writeday = writeday;
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
	@Override
	public String toString() {
		return "BoardDto [idx=" + idx + ", num=" + num + ", subject=" + subject + ", content=" + content + ", images="
				+ images + ", readcount=" + readcount + ", writeday=" + writeday + ", name=" + name + ", photo=" + photo
				+ "]";
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
	
	
	
}
