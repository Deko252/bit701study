package study.Day0228;

import java.util.Scanner;

public class Day0223Q1 {

	public static void main(String[] args) {
//		[문제1]
//		점수를 반복적으로 입력받아 총 몇개 입력인지 출력하고
//		그 점수들의 합계를 출력하시오(점수를 0 입력시 while문 빠져나와서 합계와 갯수 출력)
//		(while,Scanner)
		Scanner sc = new Scanner(System.in);
		int nums = 0;
		int sum = 0;
		while(true) {
			System.out.println("점수를 입력하세요");
			int num = sc.nextInt();			
			if(num == 0) {
				break;
			}else {
				sum += num;
				nums++;
			}
		}
		System.out.println("합계는 " + sum + " 총 " + nums + "개");

	}

}
