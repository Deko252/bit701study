package study.Day0303;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Ex16ArrayLotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int money;
		int count, dang, num= 0;
		int[] lotto = new int[6];
		int[] lucky = new int[6];

		// 금액을 입력후 금액만큼 로또 출력(1~45사이 중복없는 숫자로 오름차순 정렬로 출력)
		// 단 금액이 1000원 미만이면 "금액이 부족합니다" 출력후 종료
		// 입력한 금액만큼(천원당 1회) 반복해서 로또숫자 구한후 정렬후 출력
		/*
		 * 예) 로또 구입 금약 : 5000
		 * 
		 * 1회 : 5 12 25 34 41 45 . . .
		 */
		System.out.print("금액을 입력해주세요.(1장에 1000원)");
		money = sc.nextInt();
		if (money < 1000) {
			System.out.println("금액이 부족합니다. " + money + "원으로 구매할수없습니다.");
		} else {
			System.out.println((money / 1000) + "장을 구매했습니다.");
		}
		Loop2: for (int i = 0; i < lucky.length; i++) {
			int r2 = (int) (Math.random() * 45 + 1);
			lucky[i] = r2;
			for (int j = 0; j < i; j++) {
				if (lucky[i] == lucky[j]) {
					i--;
					continue Loop2;
				}
			}
		}
		for (int i = 0; i < lucky.length; i++) {
			for (int j = i + 1; j < lucky.length; j++) {
				if (lucky[i] > lucky[j]) {
					int temp2 = lucky[i];
					lucky[i] = lucky[j];
					lucky[j] = temp2;
				}
			}
		}
		System.err.print("당첨 번호 : " + Arrays.toString(lucky) + " \n");
		while (money >= 1000) {
			System.out.print((num+1)+ "회 :");
			Loop: for (int i = 0; i < lotto.length; i++) {
				int r = (int) (Math.random() * 45 + 1);
				lotto[i] = r;
				for (int j = 0; j < i; j++) {
					if (lotto[i] == lotto[j]) {
						i--;
						continue Loop;
					}
				}
			}
			for (int i = 0; i < lotto.length; i++) {
				for (int j = i + 1; j < lotto.length; j++) {
					if (lotto[i] > lotto[j]) {
						int temp = lotto[i];
						lotto[i] = lotto[j];
						lotto[j] = temp;
					}
				}
				System.out.print(lotto[i] + " ");
			}
			System.out.println("");
			money -= 1000;
			num++;
			count = 0;
			for (int i = 0; i < lotto.length; i++) {
				for (int j = 0; j < lotto.length; j++) {
					if (lucky[i] == lotto[j]) {
						count++;
					}
				}
			}
			//System.out.println("맞은 번호 갯수 : " + count);
			if(count == 6) {
				System.err.println("1등 당첨");
			}else if(count == 5) {
				System.err.println("2등 당첨");
			}else if(count == 4) {
				System.err.println("3등 당첨");
			}else if(count == 3) {
				System.err.println("4등 당첨");
			}else {
				System.out.println("낙첨");
			}
			
		}
		
	}

}
