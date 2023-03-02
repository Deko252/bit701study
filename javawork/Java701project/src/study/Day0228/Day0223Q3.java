package study.Day0228;

import java.util.Date;
import java.util.Scanner;

public class Day0223Q3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		[문제3]
//		태어난 년도와 월 일을 키보드로부터 입력받아 그날이 무슨 요일인지 출력하시오
//		(Scanner, Date  클래스 사용)
		Scanner sc = new Scanner(System.in);
		int year, month, day,weekday;
		String week = "";
		System.out.println("년도 입력");
		year = sc.nextInt();
		System.out.println("월 입력");
		month = sc.nextInt();
		System.out.println("일 입력");
		day = sc.nextInt();
		Date date = new Date(year-1900, month-1, day);
		weekday = date.getDay();		
		if(weekday == 0) {
			week = "일";
			System.out.println(year + "년" + month + "월" + day + "일은 " + week + "요일 입니다.");
		}else if(weekday == 1) {
			week = "월";
			System.out.println(year + "년" + month + "월" + day + "일은 " + week + "요일 입니다.");
		}else if(weekday == 2) {
			week = "화";
			System.out.println(year + "년" + month + "월" + day + "일은 " + week + "요일 입니다.");
		}else if(weekday == 3) {
			week = "수";
			System.out.println(year + "년" + month + "월" + day + "일은 " + week + "요일 입니다.");
		}else if(weekday == 4) {
			week = "목";
			System.out.println(year + "년" + month + "월" + day + "일은 " + week + "요일 입니다.");
		}else if(weekday == 5) {
			week = "금";
			System.out.println(year + "년" + month + "월" + day + "일은 " + week + "요일 입니다.");
		}else if(weekday == 6) {
			week = "토";
			System.out.println(year + "년" + month + "월" + day + "일은 " + week + "요일 입니다.");
		}
	}

}
