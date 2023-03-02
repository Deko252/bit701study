package study.Day0302;

public class Ex04Loop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int idx;
		idx = 5;
		for (int i = 0; i < 5; i++) {
			for (int j = 1; j < idx; j++) {
				System.out.print(" ");
			}
			idx--;
			System.out.print("*".repeat(i+1));
			System.out.println("");
		}
		System.out.println("=".repeat(20));
		
		idx = 6;
		for (int i = 0; i < 5; i++) {
			for (int j = 5; j >= idx; j--) {
				System.out.print(" ");
			}
			idx--;
			System.out.print("*".repeat(idx));
			System.out.println("");
		}
		System.out.println("=".repeat(20));
		
		idx = 5;
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < idx; j++) {
				System.out.print(" ");
			}
			idx--;
			System.out.print("*".repeat(i++));
			System.out.println("");
		}
		System.out.println("=".repeat(20));
	}

}
