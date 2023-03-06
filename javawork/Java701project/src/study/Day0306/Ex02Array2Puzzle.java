package study.Day0306;

import java.util.Scanner;

public class Ex02Array2Puzzle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int [][] puzzle = new int[3][3];
		int binggo;
		String exit;
		
		while(true) {
			//3행 3열에 1-3의 난수를 구해서 넣는다
			for (int i = 0; i < puzzle.length; i++) {
				for (int j = 0; j < puzzle[i].length; j++) {
					puzzle[i][j] = (int)(Math.random()*3)+1;
				}
			}
			for (int i = 0; i < puzzle.length; i++) {
				for (int j = 0; j < puzzle.length; j++) {
					System.out.printf("%4d",puzzle[i][j]);
				}
				System.out.println();
			}
			binggo = 0;
			for (int i = 0; i < puzzle.length; i++) {
					if(puzzle[i][0] == puzzle[i][1] && puzzle[i][0] == puzzle[i][2]) {
						binggo++;
					if (puzzle[0][i] == puzzle[1][i] && puzzle[1][i] == puzzle[2][i]) {
						binggo++;
					}
					
						
					}
			}
			if(puzzle[0][0] == puzzle[1][1] && puzzle[1][1] == puzzle[2][2]) {
				binggo++;
			}
			if(puzzle[0][2] == puzzle[1][1] && puzzle[1][1] == puzzle[2][0]) {
				binggo++;
			}
			if(binggo == 0) {
				System.out.println("꽝");
			}else {
				System.out.println("빙고" + binggo + "개");
			}
			
			System.out.println("=".repeat(20));
			exit = sc.nextLine();
			if(exit.equals("q")) {
				System.out.println("게임종료");
				break;
			}
		}
		

	}

}
