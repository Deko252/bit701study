package study.Day0302;

import java.util.Iterator;

public class Ex01Loop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 65;//'A'(아스키코드)
		while(a<='Z') {
			System.out.print((char)a++ + " ");
		}
		System.out.println("");
		char b = 'A';
		do {
			System.out.print(b++ + " ");
		}while(b<='Z');
		System.out.println("");
		for(char ch = 'a'; ch <='z'; ch++) {
			System.out.printf("%c" + " ",ch);
		}
		System.out.println("");
		System.out.println("-".repeat(52));// - 를 52개만큼반복
		String msg = "Happy";
		int idx = 0;
		while(true) {
			System.out.printf("%8s",msg);
			idx++;
			if (idx == 5) {
				break;
			}
		}
		System.out.println("");
		int id = 0;
		do {		
			System.out.printf("%7s",msg);
			id++;
			if (id == 5) {
				break;
			}
		}while(true);
		System.out.println("");
		for (int i = 0; i < 5; i++) {
			System.out.printf("%8s",msg);
		}
		System.out.println("");
		System.out.println("-".repeat(52));
		//msg를 5번씩 출력하는데 총 3번 반복
		//다중 for문 이용
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.printf("%8s",msg);	
			}
			System.out.println("");
		}
		
		
	}

}
