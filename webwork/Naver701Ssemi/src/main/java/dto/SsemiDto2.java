package dto;

import java.sql.Timestamp;

public class SsemiDto2 {
	private int num;
	private String name;
	private int birthyear;
	private int phone;
	private String photo;
	private String content;
	private Timestamp writeday;
	private String law;

	public SsemiDto2() {
		super();
	}

	
	
	public SsemiDto2(int num, String name, int birthyear, int phone, Timestamp writeday, String law) {
		super();
		this.num = num;
		this.name = name;
		this.birthyear = birthyear;
		this.phone = phone;
		this.writeday = writeday;
		this.law = law;
	}

	public SsemiDto2(String name, int birthyear, int phone, String photo, String content, String law) {
		super();
		this.name = name;
		this.birthyear = birthyear;
		this.phone = phone;
		this.photo = photo;
		this.content = content;
		this.law = law;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBirthyear() {
		return birthyear;
	}

	public void setBirthyear(int birthyear) {
		this.birthyear = birthyear;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}


	public String getLaw() {
		return law;
	}

	public void setLaw(String law) {
		this.law = law;
	}

	public static void main(String[] args) {
		
		
	}
}
