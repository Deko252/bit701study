package study.Day0303;

import java.util.Iterator;
import java.util.Scanner;

public class Ex14ArrayInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int [] score, rank;
		int count;
		int total = 0;
		double avg;
		
		/*
		 * 입력할 점수의 갯수를 입력받아 그 갯수만큼 배열을 할당 받은후
		 * 점수를 입력받아 합계와 평균을 구해보자
		 * 
		 */
		
		//count 입력
		System.out.print("배열의 길이 : ");
		count = sc.nextInt();
		System.out.println();
		//count 갯수만큼 score, rank할당
		score = new int[count];
		rank = new int[count];
		//배열 갯수만큼 점수 입력, 총점, 평균구하기
		for (int i = 0; i < rank.length; i++) {
			System.out.print(i + "번지의 들어갈 값 : ");
			score[i] = sc.nextInt();
			total += score[i];
		}
		System.out.println();
		avg = (double)total/count;
		//등수 구하기 다중 for
		for (int i = 0; i < rank.length; i++) {
			for (int j = 0; j < rank.length; j++) {
				if(score[i] < score[j]) {
					rank[i]++;
				}
			}
			rank[i]++;
			System.out.println("점수는 "+ score[i] + "점" + " 등수는 " + rank[i] + "등");
		}
		//출력
		System.out.printf("총점은 %d 평균은 %1.0f",total,avg);
	}

}
