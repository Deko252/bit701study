package study.Day0309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex04Exception {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		InputStreamReader isr = null;
		BufferedReader br = null;
		
		String name="";
		String addr="";
		
		isr =  new InputStreamReader(System.in);
		br = new BufferedReader(isr);
		
		System.out.println("이름 입력");
		name = br.readLine();
		
		System.out.println("주소 입력");
		addr = br.readLine();
		
		System.out.println(name + "님의 주소는 " + addr + "입니다.");
	}

}
