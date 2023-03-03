package study.Day0303;

public class Ex05Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] arr = {
				{34,56,100},
				{45,68,10,89},
				{55,87,156,949,12,11}
		};
		System.out.println("행 갯수: " + arr.length);
		System.out.println("0번행의 열갯수: " + arr[0].length);
		System.out.println("1번행의 열갯수: " + arr[1].length);
		System.out.println("2번행의 열갯수: " + arr[2].length);
		
		System.out.println("** 촐력1 **");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.printf("%5d",arr[i][j]);
			}
			System.out.println("");
		}
		System.out.println("** 촐력2 **");
		for(int []a:arr) {
			for(int n:a) {
				System.out.printf("%5d",n);
			}
			System.out.println("");
		}
	}

}
