package study.Day0306;

class Orange{
	private String strName;
	private String strNum;
	private int javaScore;
	private int springScore;
	
	//setter method
	public void setStrName(String strName) {
		this.strName = strName;
	}
	public void setStrNum(String strNum) {
		this.strNum = strNum;
	}
	public void setJavaScore(int javaScore) {
		this.javaScore = javaScore;
	}
	public void setSpringScore(int springScore) {
		this.springScore = springScore;
	}
	
	//getter method
	public String getStrName() {
		return this.strName;//this.생략가능
	}
	public String getStrNum() {
		return this.strNum;
	}
	public int getJavaScore() {
		return this.javaScore;
	}
	public int getSprigScore() {
		return this.springScore;
	}
	
	//java와 spring 점수를 한번에 변경하고 싶을때
	public void setScore(int javaScore, int springScore) {
		this.javaScore = javaScore;
		this.springScore = springScore;
	}
	
	//두 과목의합계를 반환하는 메소드
	public int getTotal(){
		return javaScore+springScore;
	}
	
	//두과목의 평균을 반환하는 메소드
	public double getAverage() {
		return getTotal()/2.0;
	}
	
	public String getGrade() {
		if((int) getAverage() >= 90) {
			return "참 잘했어요";
		}else if((int) getAverage() >= 80) {
			return "잘했어요";
		}else {
			return "노력하세요";
		}
	}
	
}

public class Ex05Object {
	
	public static void orangeWrite(Orange o) {
		System.out.println(o.getStrName() + "님의 정보");
		System.out.println(o.getStrNum() + " 학번");
		System.out.println(o.getJavaScore() + " 자바점수");
		System.out.println(o.getSprigScore() + " 스프링점수");
		System.out.println("두 과목의 합계 " + o.getTotal());
		System.out.println("두 과목의 평균 " + o.getAverage());
		System.out.println("해당 학생 등급 " + o.getGrade());
		//평균이 90이상이면 "참 잘했어요" 80이상이면 "잘했어요" 나머지는 "노력하세요"
		System.out.println("=".repeat(20));
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Orange or1 = new Orange();
		or1.setStrName("홍길덩");
		or1.setStrNum("H1254");
		or1.setJavaScore(90);
		or1.setSpringScore(78);
		
		Orange or2 = new Orange();
		or2.setStrName("길");
		or2.setStrNum("G1254");
		or2.setScore(100, 85);
		
		orangeWrite(or1);
		orangeWrite(or2);
	}

}
