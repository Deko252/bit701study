package study.Day0313;

public class Ex01Thread extends Thread{

	int num;
	String threadName;

	public Ex01Thread(String threadName, int num) {
		// TODO Auto-generated constructor stub
		this.threadName = threadName;
		this.num = num;
	}
	
	@Override
	public void run() {
		for (int i = 1; i <= num; i++) {
			System.out.println(threadName + "=>" + i);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex01Thread ex01 = new Ex01Thread("one-thread", 500);
		Ex01Thread ex02 = new Ex01Thread("two-thread", 500);
		Ex01Thread ex03 = new Ex01Thread("three-thread", 500);
		
		//thread 에서는 run 호출이 start()
		ex01.start();
		ex02.start();
		ex03.start();
	}
	

}
