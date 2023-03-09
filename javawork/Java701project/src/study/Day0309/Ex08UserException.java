package study.Day0309;

import java.util.Scanner;

class UserException extends Exception{
	public UserException(String message) {
		super(message);
	}
}
public class Ex08UserException {
public static void inputName() throws UserException {
	Scanner sc = new Scanner(System.in);
	System.out.println("이름을 입력하세요");
	String name = sc.nextLine();
	
	//김태희 또는 송혜고 입력시 강제 예외 설정
	if(name.equals("김태희")||name.equals("송혜교")) {
		throw new UserException("잘못된 이름입니다.");
	}else {
		System.out.println("내이름은 " + name);
	}
	
}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			inputName();
		} catch (UserException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("이름 오류" + e.getMessage());
		}
	}

}
