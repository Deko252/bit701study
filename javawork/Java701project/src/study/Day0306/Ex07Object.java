package study.Day0306;

import java.util.Scanner;

class MyCar{
	public static final String EMP = "현대자동차";
	private String carName;
	private String carColor;
	private int carPrice;
	
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}
	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}
	
	public String getCarName() {
		return this.carName;
	}
	public String getCarColor() {
		return this.carColor;
	}
	public int getCarPrice() {
		return this.carPrice;
	}
	
	//출력하기위한 메서드
	public void writeCar() {
		System.out.printf("%12s%7s%8s\n",this.getCarName(), this.getCarColor(),this.getCarPrice());
	}
	
}

public class Ex07Object {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int cnt;
	
		MyCar [] cars;
		
		//입력할 갯수
		System.out.print("입력할 자동차 갯수는?");
		cnt = Integer.parseInt(sc.nextLine());
		//갯수만큼 할당
		cars = new MyCar[cnt];
		//갯수만큼 자동차에 대한 데이터 넣기
		for (int i = 0; i < cars.length; i++) {
			cars[i] = new MyCar();
			System.out.print("자동차 명 : ");
			String carName = sc.nextLine();
			cars[i].setCarName(carName);
			
			System.out.print("자동차 색상 : ");
			String carColor = sc.nextLine();
			cars[i].setCarColor(carColor);
			
			System.out.print("자동차 가격 : ");
			int carPrice = Integer.parseInt(sc.nextLine());
			cars[i].setCarPrice(carPrice);
			
			
		}		
		
		//출력
		System.out.println("");
		System.out.println("자동차 회사명 : " + MyCar.EMP);
		System.out.println();
		System.out.printf("%12s%7s%8s\n","자동차 명","자동차 색상","자동차 가격");
		System.out.println("=".repeat(50));
		for(MyCar my:cars) {
			my.writeCar();
		}
		
	}

}
