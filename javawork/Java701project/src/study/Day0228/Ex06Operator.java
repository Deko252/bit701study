package study.Day0228;

public class Ex06Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//산술연산자 : +, -, *, /, %
		int su1 = 7;
		int su2 = 4;
		System.out.printf("%d+%d=%d\n", su1, su2, su1+su2);
		System.out.printf("%d-%d=%d\n", su1, su2, su1-su2);
		System.out.printf("%d*%d=%d\n", su1, su2, su1*su2);
		System.out.printf("%d/%d=%d\n", su1, su2, su1/su2);
		System.out.printf("%d/%d=%3.1f\n", su1, su2, (double)su1/su2);
		System.out.printf("%d%%%d=%d\n", su1, su2, su1%su2);//printf에서 %자체 출력시 %%
		
		
		
	}

}
