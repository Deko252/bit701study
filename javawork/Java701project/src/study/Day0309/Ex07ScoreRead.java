package study.Day0309;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * 총 10개의 점수 읽음
 * 90 50 55 .... (한줄에 5개씩 출력)
 * 총점 : XXXX
 * 평균 : XXXX.X
 * 
 */
public class Ex07ScoreRead {
	static final String FILENAME = "c:/Bit701naver\\score.txt";

	public static void scoreRead() {
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			System.out.println("파일이 있어요");
			int tot = 0;
			double count = 0;
			int idx = 1;
			while (true) {
				String data = br.readLine();
				if (data == null || data.length() == 0) {
					break;
				}
				try {
					System.out.printf("%5s", data);
					if (idx % 5 == 0) {
						System.out.println("");
					}
					tot += Integer.parseInt(data);
					count++;
					idx++;

				} catch (NumberFormatException e) {
					//System.out.println("문자가 들어있어요");
				}
			}
			System.out.println("");
			System.out.println("총점 : " + tot);
			double avg = tot / count;
			System.out.println("평균 : " + avg);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("파일이 업성요");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (fr != null) {
					fr.close();
				}

			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println("프로그램 종료");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		scoreRead();
	}

}
