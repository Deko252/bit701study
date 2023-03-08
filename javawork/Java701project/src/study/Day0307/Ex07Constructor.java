package study.Day0307;

import java.util.Date;

/*
 *  생성자
 *  1. 메서드명은 반드시 클래스명과 같아야 한다
 *  2. 리턴타입이 없다
 *  3. 처음 생성시 자동 호출된다
 *  4. 오버로딩이 가능하다
 *  5. 주로 멤버변수의 초기값을 주는 역할을 한다
 */

class Kiwi
{
	Kiwi()
	{
		System.out.println("디폴트 생성자 호출");
	}
	
	Kiwi(String m)
	{
		System.out.println("생성자 호출:"+m);
	}
	Kiwi(String name,int age)
	{
		System.out.println("생성자 호출:"+name+","+age);
	}
	Kiwi(Date date)
	{
		System.out.println("생성자 호출"+(date.getMonth()+1)+"월"+date.getDate()+"일");
	}
}

public class Ex07Constructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Kiwi k1=new Kiwi();
		Kiwi k2=new Kiwi("Hello");
		Kiwi k3=new Kiwi("이씨",30);
		Kiwi k4=new Kiwi(new Date());
	}

}
















