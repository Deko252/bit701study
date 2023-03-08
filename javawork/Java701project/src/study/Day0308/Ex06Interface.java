package study.Day0308;

/*
 * 인터페이스는 음식점의 메뉴, 또는 작업일지 같은역할을 한다
 * 실체는 없고 할일을 나열만 해놓은것이다
 * 
 * 상수와 추상 메서드로만 구성되어있다
 */
interface InterA{
	public void draw();
	public void play();
	public void study();
}

//인터페이스를 구현하는 클래스는 받드시 모든메서드들을 오버라이드 해야한다
class My implements InterA{

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("그림을 그린다");
		
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("피아노를 친다");
	}

	@Override
	public void study() {
		// TODO Auto-generated method stub
		System.out.println("자바공부를 한다");
	}
	
}
public class Ex06Interface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InterA a = new My();
		a.draw();
		a.study();
		a.play();
	}

}
