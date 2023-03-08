package study.Day0308;


abstract class AA{
	abstract public void play();
}
abstract class BB extends AA{
	abstract public void draw();
}
class CC extends BB{
	@Override
	public void play() {
		System.out.println("play");
	}
	
	@Override
	public void draw() {
		System.out.println("draw");
	}
}

public class Ex05Abstract {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BB b = new CC();
		b.play();
		b.draw();
	}

}
