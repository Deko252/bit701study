package study.Day0302;

import java.util.Random;
import java.util.Scanner;

public class Ex09Random {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int su,cnt,rnd;
		char ans;
		/*
		 * 1~100 사이의 난수를 10회 이내에 맞추기
		 * 정답을 맞췄을 경우
		 * "계속하려면 y, 그만하려면 n"
		 * y면 다른 난수 발생, cnt도 초기화등등
		 * n이면 프로그램 종료
		 */
		
		Exit://break Exit;
			while(true) {//continue Exit;
				//새로운 난수 1 ~ 100
				rnd = r.nextInt(100)+1;
				//입력횟수 초기화
				cnt = 0;
				while(true) {
					cnt++;
					System.out.print(cnt + "회:");
					//숫자 다음메 문자열 입력시 엔터때문에 문제가 발생
					//그래서 한줄을 문자열로 읽은후 정수로 변환함
					su = Integer.parseInt(sc.nextLine());
					if(su > rnd) {
						System.out.println("\t Down!");
					}else if(su < rnd){
						System.out.println("\t UP!");
					}else {
						System.out.println("\t 정답!(" + rnd + ")");
						System.out.println("계속하려면 Y, 그만하려면 N을 눌러주세요");
						ans = sc.nextLine().charAt(0);
						if(ans == 'y') {
							System.out.println("새로운 난수 발생");
							continue Exit;// 바깥쪽 while문의 처음으로
						}else {
							break Exit;//다중 while문을 나감
						}
					}if(cnt >= 10) {
						System.out.println("실패!");
						System.out.println("계속하려면 Y, 그만하려면 N을 눌러주세요");
						ans = sc.nextLine().charAt(0);
						if(ans == 'y') {
							System.out.println("새로운 난수 발생");
							continue Exit;// 바깥쪽 while문의 처음으로
						}else {
							break Exit;//다중 while문을 나감
						}
					}
				}
			}
		System.err.println(" -- 프로그램 종료 -- ");
		
	}

}
