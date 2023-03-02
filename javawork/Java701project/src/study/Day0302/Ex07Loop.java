package study.Day0302;

public class Ex07Loop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 4; j++) {
				if(j == 3) {
					continue;//j++ 로 이동
				}
				System.out.printf("i = %d, j = %d\n", i, j);
			}
		}
		System.out.println("=".repeat(20));
		Loop1:
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 4; j++) {
				if(j == 3) {
					continue Loop1;//i++ 로 이동
				}
				System.out.printf("i = %d, j = %d\n", i, j);
			}
		}
		System.out.println("=".repeat(20));
		Loop2:
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 4; j++) {
				System.out.printf("i = %d, j = %d\n", i, j);
				if(j == 2) {
					break Loop2;//다중 for문을 빠져나온다
				}
			}
		}
		System.out.println("=".repeat(20));
	}

}
