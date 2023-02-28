package study.Day0228;

public class Ex02MainArugs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println(args[1] + args[0]);
		//"100"문자열 100을 계산 가능한 숫자 100으로 변환
		int su1 = Integer.parseInt(args[0]);// "100" --> 100
		int su2 = Integer.parseInt(args[1]);// "200" --> 200
		System.out.println(su1 + su2);
	}

}
