package study.Day0313;

//Thread 클래스를 상속 받을수 없는경우 (이미 다른클래스를 상속받는경우)
//Runnable 인터페이스를 구현해서 Thread를 실행하면된다

public class Ex02Runnable implements Runnable{

	int num;
	String threadName;	
	
	public Ex02Runnable(String threadName, int num) {
		// TODO Auto-generated constructor stub
		this.threadName = threadName;
		this.num = num;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 1; i <= num; i++) {
			System.out.println(threadName + "=>" + i);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread th1 = new Thread(new Ex02Runnable("one-thread", 300));
		Thread th2 = new Thread(new Ex02Runnable("two-thread", 300));
		Thread th3 = new Thread(new Ex02Runnable("three-thread", 300));
		
		th1.start();
		th2.start();
		th3.start();
	}


}
