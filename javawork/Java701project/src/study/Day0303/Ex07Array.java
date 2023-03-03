package study.Day0303;

import java.util.Scanner;

public class Ex07Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int [] data = {12, 5, 9, 2, 20, 15, 3, 7, 17, 15};
		System.out.println(data.length);
		
		//숫자 입력후 그 숫자가 배열 몇번째 있는지 출력하기
		//없을경우 x는 배열에 없습니다 라고 출력
		
		//방법1 : int 타입에 배열번지에 없는 값을 초기값으로 지정후 그 배열번지 값을 대입한다
		
		int n = -1;
		int su;
		System.out.println("검색할 숫자 입력");
		su = sc.nextInt();
		for (int i = 0; i < data.length; i++) {
			if(data[i] == su) {	
				n = i;
			}
		}
		if(n == -1) {
			System.out.println("해당 숫자가 없습니다.");
		}else {
			System.out.println((n+1) + "번째 있습니다.");
		}
		
		boolean s = true;
		System.out.println("검색할 숫자 입력");
		su = sc.nextInt();
		for (int i = 0; i < data.length; i++) {
			if(data[i] == su) {	
				s = false;
				n = i;
			}
		}
		if(s) {
			System.out.println("해당 숫자가 없습니다.");
		}else {
			System.out.println((n+1) + "번째 있습니다.");
		}
	}

}
