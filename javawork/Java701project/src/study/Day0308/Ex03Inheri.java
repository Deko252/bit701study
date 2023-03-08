package study.Day0308;

import java.util.List;
import java.util.Vector;

class Super1{
	public void process() {
		System.out.println("나는 아무 일을 안한다");
	}
	
	public void superProcess() {
		System.out.println("super 만 가지고 있는 메서드");
	}
}

class Sub1 extends Super1{
	@Override
	public void process() {
		System.out.println("데이터를 파일에 저장합나다.");
	}
	public void sub1Process() {
		System.out.println("sub1만이 할수있는 일");
	}
}

public class Ex03Inheri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//super로 선언시 sub로 생성시
		//오버라이드 메서드와 super가 가진 메서드는 호출 가능하다
		//단 sub만이 가진 메서드는 호출 불가능
		Super1 s1 = new Sub1();
		s1.process();//오버라이드 메서드
		s1.superProcess();//부모가 가진 메서드
		
		//s1.sub1Process();//오류
		((Sub1)s1).sub1Process();//s1을 Sub1으로 다운 형변환을 하고 호출하는 방법은 가능하다
		
		//collection의 List 경우를 보자
		List<String> list = new Vector<>();
		list.add("과사"); //add는 오버라이드 메서드 이므로 호출 가능
		
		int n = ((Vector<String>)list).capacity();
		System.out.println("할당 크기" + n);
	}

}
