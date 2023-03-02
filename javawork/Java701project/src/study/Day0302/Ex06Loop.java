package study.Day0302;

import java.util.Iterator;
import java.util.Scanner;

public class Ex06Loop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int menu,dan;
		
		while(true) {
			System.out.println("1.구구단 입력후 출력 2.전체 구구단 3.종료");
			
			menu = sc.nextInt();
			
			if(menu == 1) {
				//조건: 2~9사이 숫자 입력시 해당 구구단출력
				//그 값을 벗어날 경우 "잘못입력했어요" 메세지 나온후 다시 메뉴가 나오도록하기
				System.out.println("단을 입력하세요");
				dan = sc.nextInt();
				if(dan > 9 || dan < 2) {
					System.out.println("잘못입력했어요");
					continue;
				}else {
					for (int j = 1; j <= 9; j++) {
						System.out.println(dan + " X " + j + " = " + (int)(dan*j));
					}					
				}
				System.out.println("");		
			}else if(menu == 2) {
				//2~9단을 가로방향으로 출력
				for (int i = 1; i <= 9; i++) {
					for (int j = 2; j <= 9; j++) {
						System.out.printf("%d X %d = %2d |", j, i, j*i);
					}
					System.out.println(" ");		
				}			
			}else {
				System.err.println("**프로그램 종료**");
				break;
			}
		}
	}

}
