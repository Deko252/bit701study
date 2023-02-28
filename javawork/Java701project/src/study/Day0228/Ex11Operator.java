package study.Day0228;

import java.util.Scanner;

public class Ex11Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//조건 연산자(삼항연산자)
		//조건시?참일때 값:거짓일떄 값;
		//조건식1? 참일때값:조건2? 참일떄:.....:거짓일때값
		
		Scanner sc = new Scanner(System.in);
		int score;
		String msg;
		//점수입력
		System.out.println("점수입력");
		score = sc.nextInt();
		//90이상:참잘했어요,90미만:노력하세요
		msg = score>=90?"참잘했어요":"노력하세요";
		System.out.println(score + "점 "+msg);
		
		//msg에 90이상이면 "A그룹" 80이상이면 "B그룹" 나머지는 "C"그룹
		msg = score>=90?"A그룹":score>=80?"B그룹":"C그룹";
		System.out.println(score + "점 "+msg);
		
		//90이상은 "A", 80이상은 "B", 70이상은 "C", 60이상은 "D", 60미만 "F"
		msg = score>=90?"A":score>=80?"B":score>=70?"C":score>=60?"D":"F";
		System.out.println(score + "점 "+msg + "학점");
	}

}
