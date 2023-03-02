package study.Day0302;

import java.util.Scanner;

public class Ex05Loop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int menu;
		int su1, su2, sum;

		Exit: while (true) {
			System.out.println("**메뉴**");
			System.out.println("1. 숫자 입력후 1부터 그 숫자까지 합계구하기");
			System.out.println("2. 숫자 입력후 숫자1 ~ 숫자2 까지 합계 구하기");
			System.out.println("3. 숫자 입력후 1부터 그 숫자까지 Factorial구하기");
			System.out.println("4. 두개의 숫자 숫자1,숫자2 입력후 숫자1의 숫자2승 구하기");
			System.out.println("5. 종료");

			menu = sc.nextInt();
			switch (menu) {
			case 1:
				System.out.print("숫자를 입력하세요 : ");
				su1 = sc.nextInt();
				
				sum = 0;
				for (int i = 1; i <= su1; i++) {
					sum += i;
				}
				System.out.println("1부터" + su1 + "까지의 합계는 " + sum + "입니다\n");
				break;
			case 2:
				for (int i = 0; i < 1; i++) {
					System.out.print("첫번째 숫자를 입력하세요 : ");
					su1 = sc.nextInt();
					
					System.out.print("두번째 숫자를 입력하세요 : ");
					su2 = sc.nextInt();
					if(su1 > su2) {
						System.out.println("다시입력하세요(첫번쨰 숫자가 두번째 숫자보다 작아야합니다)");
						i--;
					}else {					
						sum = 0;
						for (int j = su1; j <= su2; j++) {
							sum += j;
						}
						System.out.println(su1 + "부터" + su2 + "까지의 합계는 " + sum + "입니다\n");
					}		
				}
				break;
			case 3:
				System.out.print("숫자를 입력하세요 : ");
				su1 = sc.nextInt();
				
				sum = 1;
				for (int i = 1; i <= su1; i++) {
					sum *= i;
				}
				System.out.println("1부터" + su1 + "까지의 곱은 " + sum + "입니다\n");
				break;
			case 4:
				System.out.print("첫번째 숫자를 입력하세요 : ");
				su1 = sc.nextInt();
				System.out.print("두번째 숫자를 입력하세요 : ");
				su2 = sc.nextInt();
				//sum = (int)Math.pow(su1, su2);
				sum = 1;
				for (int i = 1; i <= su2; i++) {
					sum *= su1;
				}
				System.out.println(su1 + " 의 " + su2 + "승은 " + sum + " 입니다\n");
				break;
			default:
				System.err.println("*** 프로그램 종료 ***");
				// break; 만쓸경우 switch만 빠져나와서 while문은 계속 반복
				break Exit;// while문을 빠져나옴
			}
		}
	}

}
