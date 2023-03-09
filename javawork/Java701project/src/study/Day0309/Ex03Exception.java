package study.Day0309;

public class Ex03Exception {
	public static void excepTest() {
		System.out.println("여러분 안녕하세요");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("2초뒤 여러분 반가워요");
	}

	public static void excepTest2() throws InterruptedException {
		Thread.sleep(1000);
		System.out.println("둘");
		Thread.sleep(2000);
		System.out.println("2초뒤 둘둘");
		Thread.sleep(3000);
		System.out.println("3초뒤 둘둘둘");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		excepTest();
		try {
			excepTest2();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
