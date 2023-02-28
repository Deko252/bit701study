package study.Day0228;

import java.util.Scanner;

public class Ex16Asciicode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		char ch;
		while(true) {
			System.out.println("키보드의 키를 눌러보세요");
			ch = sc.nextLine().charAt(0);//첫 글자를 char타입으로 반환
			if(ch == 'q' || ch == 'Q') {
				break;
			}
			
			System.out.printf("%c => %d\n", ch, (int)ch);
		}
		System.out.println("**End**");
	}

}
