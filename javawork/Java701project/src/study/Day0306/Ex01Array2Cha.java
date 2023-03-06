package study.Day0306;

import java.util.Scanner;

public class Ex01Array2Cha {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		//이름을 저장할 배열
		String [] names = new String[3];
		//3고목의 점수와 총점을 구할 2차원 배열 선언
		int [][]scores = new int[3][5];//3행 5열(3과목점수, 총점, 등수)
		
		//입력
		for (int i = 0; i < scores.length; i++) {
			System.out.println(i + "번의 이름은?");
			names[i] = sc.nextLine();
			
			System.out.println("3과목의 점수를 입력해 주세요.");
			for (int j = 0; j < 3; j++) {
				scores[i][j] = sc.nextInt();
			}
			//마지막 정수 입력후 버퍼에 저장된 엔터를 따로 읽어서 처리한다
			sc.nextLine();
		}
		//총점구하기
		for (int i = 0; i < scores.length; i++) {
			for (int j = 0; j < 3; j++) {
				scores[i][3] += scores[i][j];
			}
		}
		
		//등수
		
		for (int i = 0; i < scores.length; i++) {
			scores[i][4] = 1;
			//상대방이 (j) 총점 기준(i)보다 더 높을경우
			for (int j = 0; j < scores.length; j++) {
				if(scores[i][3] < scores[j][3]) {
					scores[i][4]++;
				}
			}
		}
		
		//출력
		System.out.println("이름\t국어\t영어\t수학\t총점\t등수");
		System.out.println("=".repeat(30));
		for (int i = 0; i < scores.length; i++) {
			System.out.printf("%-10s",names[i]);
			
			for (int j = 0; j < scores[i].length; j++) {
				System.out.printf("%5d",scores[i][j]);
			}
			System.out.println();
		}
		
	}

}
