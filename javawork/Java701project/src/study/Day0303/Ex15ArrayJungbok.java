package study.Day0303;

import java.util.Iterator;
import java.util.Random;

public class Ex15ArrayJungbok {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 10개의 데이터를 저장할 배열을 생성후
		 * 1 부터 30 사이에 중복 없는 숫자를 랜덤하게 배열에 넣기
		 */
		int [] data = new int[10];
		
		Random r = new Random();
		Loop:
		for (int i = 0; i < data.length; i++) {
			data[i] = r.nextInt(30)+1;
			//중복숫자가 i이전 번지에 있을경우 다시구하기
			for (int j = 0; j < i; j++) {
				if(data[i] == data[j]) {
					i--;
					continue Loop;
				}
			}
			System.out.printf(data[i] + "\t");
		}
		
	}

}
