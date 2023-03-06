package study.Day0306;

class Apple{
	public String mes1 = "GGGG!!";
	private String mes2 = "SSSS!!";
	public static final String MES="1Q2W3E4R!";
	public String getMes2() {
		return mes2;
	}
	public void setMes2(String mes2) {
		this.mes2 = mes2;
	}
	
	
}

public class Ex04Object {//public은 파일명과 같을경우 붙일수 있다.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Apple이 가진 멤버변수중 new로 생성하지 않아도 접근이 가능한 변수는 누구일까 (static)
		System.out.println(Apple.MES);
		
		//인스턴스 멤버변수는 new로 생성후 접근이 가능하다
		Apple a = new Apple();
		System.out.println(a.mes1);
		//System.out.println(a.mes2);//패키지 상관없이 접근불가(private)
		
		
		//mes2 출력
		System.out.println(a.getMes2());
		//mes2 갑을 Bitcamp로 변셩
		a.setMes2("Bitcamp");
		//mes2 변경된 값을 다시 출력
		System.out.println(a.getMes2());
	}

}
