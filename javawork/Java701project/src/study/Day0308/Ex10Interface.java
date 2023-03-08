package study.Day0308;

import java.util.Scanner;

interface Command{
	public void process();
}
class Add implements Command{

	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("Add입니다");
	}

}
class Delete implements Command{

	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("Delete입니다");
	}

}
class Select implements Command{

	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("Select입니다");
	}

}
class Update implements Command{

	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("Update입니다");
	}

}

public class Ex10Interface {
	public static void process(Command comm) {
		comm.process();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int menu;
		Command comm = null; //Command는 interface
		
		Exit:
			while(true) {
				System.out.println("1.추가 2.삭제 3.조회 4.수정 5.종료");
				menu = sc.nextInt();
				switch(menu) {
				case 1:
					comm = new Add();
					break;
				case 2:
					comm = new Delete();
					break;
				case 3:
					comm = new Select();
					break;
				case 4:
					comm = new Update();
					break;
				default:
					System.out.println("종료");
					break Exit;
				}
				process(comm);
				System.out.println("=".repeat(30));
			}
	}

}
