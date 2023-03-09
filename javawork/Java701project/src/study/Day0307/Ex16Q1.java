package study.Day0307;

class Car{
	String color;
	int speed;
	int gear;

	@Override
	public String toString() {
		return "Car [color=" + color + ", speed=" + speed + ", gear=" + gear + "]";
	}
	void changeGear(int g) {
		gear = g;
	}
	void SpeedUp() {
		speed = speed +10;
	}
	void SpeedDown() {
		speed = speed -10;
	}
	void color(String Color) {
		color = Color;
	}
}

class Rect{
	int width, height;
	public Rect(int w, int h) {
		this.width = w;
		this.height = h;
	}
	double getArea() {
		return (double)width*height;
	}
}
public class Ex16Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 교재 클래스 134 페이지

			p156 PizzaTest  생성자 기초 예제
			p156 TelevisionTest 생성자 기초 예제
			p178 CarTest   toString 오버라이드 예제
			p210 RectArrayTest  객체 배열 예제 (Rect 클래스는 209p)
			p238 EmployeeTest 상속 예제

		 */
		Car myCar = new Car();
		myCar.changeGear(1);
		myCar.SpeedUp();
		myCar.color("red");
		//myCar.SpeedDown();
		System.out.println(myCar);
		
		Rect[] list;
		list = new Rect[5];
		
		for (int i = 0; i < list.length; i++) {
			list [i] = new Rect(i, i);
		}
		for (int i = 0; i < list.length; i++) {
			System.out.println(i + "번 " + list[i].getArea());
		}
		
		
	}

}
