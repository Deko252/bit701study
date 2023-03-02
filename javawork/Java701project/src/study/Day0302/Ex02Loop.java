package study.Day0302;

import java.util.Iterator;

public class Ex02Loop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1. 1 ~ 20 까지의 숫자중 3의 배수만 출력 (pirntf("%4d")
		for (int i = 1; i < 21; i++) {
			if(i%3 == 0) {
				System.out.printf("%4d",i);				
			}
		}
		System.out.println("");
		
		//2. 10 ~ 1까지 거꾸로 출력
		for (int i = 10; i > 0; i--) {
			System.out.printf("%4d",i);
		}
		System.out.println("");
		
		//3. 1 ~ 30 까지 숫자중 5의 배수 출력
		for (int i = 1; i < 31; i++) {
			if(i%5 == 0) {
				System.out.printf("%4d",i);				
			}
		}
		System.out.println("");
		
		//4. * 20개 출력
		for (int i = 0; i < 20; i++) {
			System.out.print(" * ");
		}
		System.out.println("");
		System.out.print(" * ".repeat(20));
		System.out.println("");
		
		for (int i = 1; i < 51; i++) {
			if(i%5 == 0 || i%3 == 0) {
				System.out.printf("%4d",i);				
			}
		}
		System.out.println("");
		
		//5. 1~20까지 홀수만 출력
		for (int i = 1; i < 21; i+=2) {
			System.out.print(" " + i + " ");
		}
		System.out.println("");
		for (int i = 1; i < 21; i++) {
			if (i%2 != 0) {
				System.out.print(" " + i + " ");
			}
		}
	}

}
