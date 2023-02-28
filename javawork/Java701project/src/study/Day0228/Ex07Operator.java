package study.Day0228;

import java.util.Arrays;
import java.util.Scanner;

public class Ex07Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int money;
		System.err.println("당신의 월 급여는 ?");
		money = sc.nextInt();
		/*예) 234567
		 * 만원 234장
		 * 천원 5장 .... 1원까지*/
		int m = money/10000;
		int c = (money%10000)/1000;
		int b = (money%1000)/100;
		int s = (money%100)/10;
		int i = (money%10);
		System.out.printf("만원 : %d 개\n천원 : %d 개\n백원 : %d 개\n십원 : %d 개\n일원 : %d 개\n", m, c, b, s, i);
		
		String smoney = Integer.toString(money);
		int[] amoney = new int[smoney.length()];
		int man = 0;
		int k = 1;
		for (int j = 0; j < smoney.length(); j++) {
			amoney[j] = smoney.charAt((smoney.length() - j-1)) - '0';
			if(j > 3) {
				man += amoney[j] * k;
				k *= 10;
			}
		}
		System.out.println(Arrays.toString(amoney)); 
		System.out.println("만원 : " + man + " 개");
		System.out.println("천원 : " + amoney[3] + " 개");
		System.out.println("백원 : " + amoney[2] + " 개");
		System.out.println("십원 : " + amoney[1] + " 개");
		System.out.println("일원 : " + amoney[0] + " 개");
		
	}

}
