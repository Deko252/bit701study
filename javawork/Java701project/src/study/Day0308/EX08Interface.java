package study.Day0308;

//class가 class를 상속받을때 extends
//interface가 interface를 상속받을때 extends
//class가 interface를 구현할떄 implements

interface Kiwi{
	public void play();
	
}
interface Manggo extends Kiwi{
	public void study();
}

class Banana{
	public void eat() {
		System.out.println("바나나를 먹어요");
	}
}
class Berry extends Banana implements Manggo{

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("공부 자바");
	}

	@Override
	public void study() {
		// TODO Auto-generated method stub
		System.out.println("자바 공부");
	}
	
}

public class EX08Interface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Berry b = new Berry();
		b.study();
		b.play();
		b.eat();
	}

}
