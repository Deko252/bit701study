package Study4;

public class Car {
	Tire tire;

	public Car(Tire tire) {
		super();
		this.tire = tire;
	}
	
	public void myCarTire() {
		System.out.println("내차의 타이어는 " + tire.getTireName());
	}
	
}
