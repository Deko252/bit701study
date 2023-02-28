package study.Day0228;

import java.util.Scanner;

public class Ex04Scanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String name, java, spring;
		System.out.println("이름입력");
		name = sc.nextLine();
		System.out.println("자바점수 입력");
		java = sc.nextLine();
		System.out.println("스프링 점수 입력");
		spring = sc.nextLine();
		
		//int tot=Integer.parseInt(java) + Integer.parseInt(spring);
		//실수형 타입으러 입력시 double 타입으로 변환
		
		//wrapper class = Integer,Double, Float 드등 변환 을하기위한 클래스들
		double tot= Double.parseDouble(java) + Double.parseDouble(spring);
//		System.out.println("이름 : " + name);
//		System.out.println("자바점수 : " + java);
//		System.out.println("스프링점수 : " + spring);
//		System.out.println("총점 : " + tot);
		
		//printf를 이용한 출력
		System.out.printf("이름 : %s\n",name);
		System.out.printf("자바점수 : %s\n",java);
		System.out.printf("스프링점수 : %s\n",spring);
		System.out.printf("총점 : %5.1f\n",tot);
	}
	

}
