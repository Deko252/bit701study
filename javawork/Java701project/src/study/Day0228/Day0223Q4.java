package study.Day0228;

import java.util.Scanner;

public class Day0223Q4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		[문제4]
//			** 메뉴 **
//			원의 넓이 구하기
//			사각형의 넓이 구하기
//			1번 선택시 원의 반지름을 입력받아 원의 넓이를 구해서 출력하고
//			2번 선택시 가로와 세로길이를 입력받아 사각형의 넓이를 구해서 출력하시오
//			(switch 문 사용)
		
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("번호를 입력해주세요. 원:1 , 사각형:2 , 종료 : 0");
			int i = sc.nextInt();
			if(i == 0) {
				break;
			}
			switch(i){		
			case 1:
				System.out.println("반지름을 입력해주세요.");
				int r = sc.nextInt();
				double r2 = r*r*Math.PI;
				System.out.printf("원의 넓이는 %3.2f\n",r2);
				break;
			case 2:
				System.out.println("가로길이를 입력해주세요.");
				int w = sc.nextInt();
				System.out.println("세로길이를 입력해주세요.");
				int h = sc.nextInt();
				int sq = w*h;
				System.out.println("사각형의 넓이는 " + sq);
				break;
			default:
				System.out.println("숫자를 다시 입력하세요");
				break;
			}
		}
		System.out.println("종료합니다.");

	}

}
