package study.Day0228;

import java.util.Scanner;

public class Ex09Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//관계연산자 : > < >= <= == !=
		//논리연산자 : && , ||, !
		
//		int kor=100,eng=80,mat=100;
//		System.out.println(kor>eng);
//		System.out.println(kor==mat);
//		System.out.println(!(kor==mat));
//		System.out.println(kor>eng && kor>mat);
//		System.out.println(kor>eng || kor>mat);
		
		Scanner sc = new Scanner(System.in);
		int kor, eng, mat;
		/*
		 * 3과목의 점수가 40이상이고 평균이 60이상이면 "합격"
		 * 그렇지 않으면 "불합격"
		 * 
		 */
		
		double avg;
		System.out.println("국어 점수 입력");
		kor = sc.nextInt();
		System.out.println("영어 점수 입력");
		eng = sc.nextInt();
		System.out.println("수학 점수 입력");
		mat = sc.nextInt();
		
		avg = (kor+eng+mat)/3.0;
		System.out.printf("3과목 평균 : %3.1f\n",avg);
		
		//나머지 조건부분을 이용해 구해보기
		if(kor >= 40 && eng >= 40 && mat >= 40 && avg >= 60) {
			System.out.println("합격");
		}else {
			System.out.println("불합격");
		}
	}

}
