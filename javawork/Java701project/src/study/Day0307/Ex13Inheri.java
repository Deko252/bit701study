package study.Day0307;

//부모 클래스(super class)
class SuperObj
{
	String msg;
	
	SuperObj()
	{
		System.out.println("super 클래스의 생성자");
	}
	
	SuperObj(String msg)
	{
		this.msg=msg;
	}
}

//자식 클래스(sub class):자바는 단일상속만 지원
class SubObj extends SuperObj
{
	String msg2;
	
	SubObj()
	{
		super();//디폴트인경우에는 생략가능,무조건 첫줄에 있어야만 한다
		System.out.println("sub 클래스의 생성자");		
	}
	
	SubObj(String msg,String msg2)
	{
		super(msg);//인자가 같은 타입인 super 클래스의 생성자가 호출된다,생략안됨
		this.msg2=msg2;
	}
	
	public void writeData()
	{
		System.out.println(msg);
		System.out.println(msg2);
	}
}

public class Ex13Inheri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubObj sub=new SubObj();
		
		SubObj sub2=new SubObj("아버지", "저예요");
		sub2.writeData();
	}

}






















