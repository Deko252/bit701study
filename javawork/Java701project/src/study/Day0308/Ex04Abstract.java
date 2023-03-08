package study.Day0308;

//abstract (추상) 클래수: 일반 메서드와 추상메서드 두가지구현이 가능하다
//추상 클래스를 상속받는 클래스는 반드시 추상메서드를 오버라이드 해야한다
//만약 오버라이드를 안할경우는 상속받는 클래스도 추상 클래스로 만들면 된다
abstract class Apple{
	public abstract void process();//나중에 오버라이드를 목적으로 만든 메서드(추상 메서드(미완성메서드))
	
	public void show() {
		System.out.println("show");
	}

}

//추상 클래스를 상속받는 일반 클래스
class Orange extends Apple{
	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("process override");
	}
}
public class Ex04Abstract {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Apple a = new Orange();
		a.process();
		
		//Apple a2 = new Apple();//추상 클래스는 new로 생성할수 없다.
	}

}
