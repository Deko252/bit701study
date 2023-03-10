package study.Day0310;
//이름,부서,나이,핸드폰
public class EmpDto {
	private String  name;
	private String bu;
	private int age;
	private int num;
	
	public static void main(String[] args) {
		
	}

	@Override
	public String toString() {
		return "EmpDto [name=" + name + ", bu=" + bu + ", age=" + age + ", num=" + num + "]";
	}
	public EmpDto() {
		//빈값이 들어 왔으때 super로 보내줌
	}
	public EmpDto(String name, String bu, int age, int num) {
		super();
		this.name = name;
		this.bu = bu;
		this.age = age;
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBu() {
		return bu;
	}

	public void setBu(String bu) {
		this.bu = bu;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
}
