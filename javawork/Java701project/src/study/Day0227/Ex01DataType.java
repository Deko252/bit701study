package study.Day0227;

public class Ex01DataType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("자바프로젝트 생성");
		//정수타입 byte(1) = short(2) - int(4) - long(8)
		byte a = 127;
		byte b = (byte)999;//강제로 자료형보다 큰값을 넣는경우 값손실이 발생한다
		System.out.println(a);
		System.out.println(b); // 틀린값이 나온다
		char c = 'A';
		char d = '가';//자바에서 char는 2바이트라 한글도 한글자 가능
		System.out.println(c + "," + d);
		System.out.println((int)c);//변수 c 의 아스키코드 10진수의 값이 나옴
		
		//묵시적 형변환 : 연산시에 자동으로 경졍되는 타입(int + int = int, double + int = double
		//String + int = String, char + int = int)
		System.out.println(c + 32);
		System.out.println((char)(c + 32));
		
		char e = 66; //내부적으로는 문자 'B'로 인식
		int f = 'A';
		System.out.println(e + "," + f);
	}

}
