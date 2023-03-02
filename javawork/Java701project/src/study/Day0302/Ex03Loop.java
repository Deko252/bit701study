package study.Day0302;

import java.util.Iterator;

public class Ex03Loop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//5행 5열 별표 출력
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		System.out.println("=".repeat(20));
		
		int idx = 1;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < idx; j++) {
				System.out.print("*");
			}
			idx++;
			System.out.println("");
		}
		System.out.println("=".repeat(20));
		
		idx = 1;
		for (int i = 0; i < 5; i++) {
			for (int j = 5; j >= idx; j--) {
				System.out.print("*");
			}
			idx++;
			System.out.println("");
		}		
	}

}
