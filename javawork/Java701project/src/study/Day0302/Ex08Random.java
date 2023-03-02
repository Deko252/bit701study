package study.Day0302;

import java.util.Random;

public class Ex08Random {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//자바에서는 난수를 구하는 방법이 2가있다
		//1. Math.random();
		for (int i = 1; i < 6; i++) {
//			double r = Math.random();//0.0000... ~ 0.9999...  까지의 난수 발생
//			System.out.println(r);
			
			//0~9까지의 난수
			int r = (int)(Math.random()*10); //0~9
			System.out.print(r + " ");
		}
		System.out.println("");
		System.out.println("=".repeat(20));
		
		//2. Random 클래스
		Random random = new Random();
		for (int i = 1; i <= 5; i++) {
			int r = random.nextInt(10);// 0~9
			System.out.print(r + " ");
		}
		System.out.println("");
		System.out.println("=".repeat(20));
		for (int i = 1; i <= 5; i++) {
			//int r = random.nextInt(26)+65;//A~Z(65~90)
			int r = random.nextInt(26)+97;//a~z(97~122)
			System.out.println((char)r);
		}
		
	}

}
