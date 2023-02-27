package study.Day0227;

import java.util.Iterator;

public class Ex02StringType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//2글자 이상 저장시 문자열 철
		String s1 = new String("Hello");
		String s2 = "Apple Pen";
		String s4 = "   Happy   ";
		System.out.println(s1 + ", " + s2);
		
		String s3 = s1+100;
		System.out.println(s3);
		System.out.println("34 + 89 = " + 34+89);
		System.out.println("34 + 89 = " + (char)(34+89));
		
		//String 클래스가 가진 메서드들
		System.out.println("s1의 length = " + s1.length());//길이를 구하는 length() 메서드
		System.out.println("s2의 length = " + s2.length());
		System.out.println("s4의 length = " + s4.trim().length());//s4의 값에서 앞뒤 공백을 제거한 뒤 길이구하기
		
		//charAt(인덱스) : 문자열에서 인덱스 번지에 해당하는 문자 (1글자) 반환
		//indexOf(문자) : 해당문자가 어디에 있는지 인덱스값 반환
		String msg = "Have a good day";
		System.out.println(msg.charAt(7));
		System.out.println(msg.charAt(10));
		System.out.println(msg.indexOf("g"));
		System.out.println(msg.indexOf('d'));
		System.out.println(msg.indexOf('a'));//처음만난 a의인덱스 반환
		System.out.println(msg.lastIndexOf('a'));//마지막으로 만난 a의인데스 반환
		
		//변수.startsWith("문자열"):변수가 "문자열" 로 시작하면 ture 반환
		System.out.println(msg.startsWith("Have"));//true
		System.out.println(msg.startsWith("have"));//false (대소문자 구분)
		
		//변수.endsWith("문자열"):변수가 "문자열" 로 끝나면 ture 반환
		System.out.println(msg.endsWith("Hello"));//false
		System.out.println(msg.endsWith("day"));//true
		
		//substring(5) : 5번 인덱스부터 끝까지반환
		//substring(1, 10) : 1~ (10-1) 인덱스의 해당하는 문자열 반환
		System.out.println(msg.substring(7));//7번부터 끝까지 추출해서 반환
		System.out.println(msg.substring(7, 10));//goo ( 7부터 9까지만 추출)
		
		System.out.println(msg.toLowerCase());//전부 소문자로 변환
		System.out.println(msg.toUpperCase());//전부 대문자로 변환
		
		//replace : 일부 문자 또는 단어 변경후 반환
		System.out.println(msg.replace('a', '*'));//H*ve * good d*y
		System.out.println(msg.replace("good", "Happy"));//Have a Happy day
		
		//문자열 비교 : equals, compareTo
		String m1 = "Apple";
		String m2 = "apple";
		String m3 = "Orange";
		
		//기본형에서는 값으로 비교, 클래스타입에서는 주소비교를 의미
		System.out.println(m1==m2);//주소비교
		//문자열 같은경우는 정확하게 값으로 비교하려면 위의 두 메서드를 사용
		System.out.println(m1.equals(m2));//m1이 m2와 같은지 비교 (대소문자가 다를경우 false)
		System.out.println(m1.equals("Apple"));//true
		System.out.println(m1.equalsIgnoreCase(m2));//대소문자는 무시하고 철자만 비교 : true
		
		//compareTo는 두 문자열의 아스키코드값의 차이를 반환
		System.out.println(m1.compareTo(m3));//A(65) , O(79) : -14 : (음수 :m1이 작을경우)
		System.out.println(m1.compareTo("Apple"));//두 변수의 값이 완전히 같을경우 0이 나온다
		System.out.println("computer".compareTo("command"));//'p'(112),'m'(109) 비교 : 3(양수 값은 앞의 값이 더 크다는 뜻)
		
		//split(','):,로 분리하여 배열타입으로 반환
		String colors = "red,blue,orange,black,yellow,green";
		String []mycolors = colors.split(",");
		System.out.println("총 " + mycolors.length + " 개 분리함");
		//for문으로 출력 ( 배열 갯수만큼 자동으로 반복)
		for(String ch:mycolors) {
			System.out.println(ch);
		}
		for (int i = 0; i < mycolors.length; i++) {
			System.out.println(mycolors.length);
		}
	}

}
