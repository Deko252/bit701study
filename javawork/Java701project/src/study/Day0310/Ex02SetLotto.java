package study.Day0310;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Ex02SetLotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();
		int[]arr = new int[6];
		Set<Integer> setLotto = new TreeSet<>();
		
		//1~45의 난수를 6개 생성한후 오름차순으로 출력
		for (int i = 0; i < 6; i++) {
			arr[i] = r.nextInt((45)+1);
			setLotto.add(arr[i]);
			if(setLotto.size() == 6) {
				break;
			}else {
				i--;
			}
		}
		System.out.println("setLotto = " + setLotto.size() + "개");
		
		for (int a : setLotto) {
			System.out.printf("%5d", a);
		}
	}

}
