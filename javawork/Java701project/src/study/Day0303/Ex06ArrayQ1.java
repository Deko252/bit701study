package study.Day0303;

public class Ex06ArrayQ1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] data= {100,200,50,95,87,23,65,15,-48,-12,12,5,-220};
		int max = data[0];
		double min = data[0];
		
		for (int i = 0; i < data.length; i++) {
			if(max < data[i]) {				
				max = data[i];
			}
			if(min > data[i]) {
				min = data[i];
			}
		}
		System.out.println(max);
		System.out.printf("%3.0f",min);
	}

}
