package study.Day0303;

public class Ex04Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [][]arr = new int[3][3];
		
		arr[0][0] = 5;
		arr[1][1] = 10;
		arr[1][2] = 15;
		
		System.out.println("행 갯수 : " + arr.length);
		System.out.println("0번행의 열 갯수 : " + arr[0].length);
		
		System.out.println("2차원 데이터 출력");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println("");
		}
	}

}
