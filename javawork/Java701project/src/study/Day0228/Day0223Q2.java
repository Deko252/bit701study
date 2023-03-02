package study.Day0228;

import java.util.Scanner;

public class Day0223Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		[문제2]
//		상품명과 수량 단가를 입력받아서 총 금액을 구해서 출력하시오
//		(단 수량이 5개 이상이면 총금액 출력후 10프로 디씨되니 금액도 같이 출력해주세요)
//		(예)
//			상품명 
//			   딸기
//			수량
//			   5
//			단가
//			   1000
//			                
//			총 5000 원
//			   10프로 할인된 금액  4500 원
		Scanner sc = new Scanner(System.in);
		System.out.println("상품명을 입력해주세요");
		String name = sc.nextLine();
		
		System.out.println("수량을 입력해주세요");
		int num = sc.nextInt();
		
		System.out.println("가격을 입력해주세요");		
		int price = sc.nextInt();
		System.out.println("");
		
		System.out.println("상품명\n	" + name);
		System.out.println("수량\n	" + num);
		System.out.println("가격\n	" + price);
		
		int sum = num*price;
		System.out.println("총 " + sum + "원 입니다.");
		
		int dc = 0;
		if(num >= 5) {
			dc = (sum/10)*9;
			System.out.println("10프로 할인된 금액 " + dc + "입니다.");
		}
		
		
		
	}

}
