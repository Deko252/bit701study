package study.Day0228;

import java.util.Scanner;

public class Ex03Scanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
//		int kor, eng;
//		System.out.println("input kor?");
//		kor = sc.nextInt();
//		System.out.println("input eng?");
//		eng = sc.nextInt();
//		
//		int sum = kor+eng;
//		System.out.println("두 과목의 합계는" + sum + "점 입니다.");
		
//		String name;
//		int age;
//		System.out.println("이름은 ?");
//		name = sc.nextLine();
//		System.out.println("나이는 ?");
//		age = sc.nextInt();
//		System.out.printf("%s님의 나이는 %d세 입니다.", name, age);
		
		String name;
		int age;
		System.out.println("나이는 ?");
		age = sc.nextInt();
		
		//키보드 버퍼의 엔터문자를 먼저 읽어서 없앤다
		sc.nextLine();
		
		System.out.println("이름은 ?");
		name = sc.nextLine();
		System.out.printf("%s님의 나이는 %d세 입니다.", name, age);
	}

}
