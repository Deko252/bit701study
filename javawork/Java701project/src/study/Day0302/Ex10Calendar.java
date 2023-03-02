package study.Day0302;

import java.util.Date;
import java.util.Scanner;

public class Ex10Calendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//년도와 월을 입력시 해당 달력을 출력하시오
		Scanner sc = new Scanner(System.in);
		int year, month, week, endday;
		
		System.out.print("년도 입력 : ");
		year = sc.nextInt();
		System.out.println();
		System.out.print("월 입력 : ");
		month = sc.nextInt();
		System.out.println();
		if(month<1 || month>12) {
			System.out.println("월 입력을 잘못했어요(1~12)");
			return;
		}
		
		System.out.printf("%20d년 %2d월 달력\n\n", year, month);
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		System.out.println("=".repeat(50));
		
		//입력한 년도, 월의 1일이 무슨 요일 week값 필요
		Date date = new Date(year-1900, month-1, 1);
		week = date.getDay();
		
		//입력한 년도의 월이 몇일까지 있는지 구하기
		switch(month) {
		case 2:
			//윤년이면 29일 평년이면 28일
			if(year%4==0 && year%100!=0 || year%400==0) {
				endday = 29;
			}else {
				endday = 28;
			}
			break;
		case 4: 
			endday = 30;
			break;
		case 6: 
			endday = 30;
			break;
		case 9: 
			endday = 30;
			break;
		case 11:
			endday = 30;
			break;
		default:
			endday = 31;
			break;
		}
		
		//week 숫자만큼 \t으로 띄워주기
		for (int i = 1; i <= week; i++) {
			System.out.print("\t");
		}
		
		//1일부터 endday까지 출력(토요일은 출력후\n)
		for(int i = 1; i <= endday; i++) {
			week++;
			System.out.printf("%2d\t",i);
			if(week%7 == 0) {
				System.out.println();
			}
		}
	}

}
