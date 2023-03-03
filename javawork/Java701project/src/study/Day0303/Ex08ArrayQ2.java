package study.Day0303;

import java.util.Scanner;

public class Ex08ArrayQ2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String [] members = {"이효리","강호동","손미나","손흥민","강호효","이진","박재범",
				"이효호","박재순","손예진","김순자","김말자","이진상","박진상","손진상",
				"마이클","재니퍼","재니슨","마이콜","이순자"};
		
		//System.out.println(members.length);
		
		/*
		 * 검색할 이름을 입력후 몇번째에 있는지 출력
		 * 없을경우 없다는 메세지 출력
		 */
		String name;
		boolean s = true;
		System.out.println("검색할 이름 입력");
		name = sc.nextLine();
		for (int i = 0; i < members.length; i++) {
			if(name.equals(members[i])) {
				s = false;
				System.out.println( name + "은(는) " + (i+1) + "번쨰 있습니다.");
				break;
			}
		}
		if(s) {
			System.out.println(name + "은(는) 없습니다.");
		}
		System.out.println("");
		s = true;
		System.out.println("검색할 이름 입력");
		name = sc.nextLine();
		for (int i = 0; i < members.length; i++) {
			if(name.compareTo(members[i]) == 0) {
				s = false;
				System.out.println( name + "은(는) " + (i+1) + "번쨰 있습니다.");
				break;
			}
		}
		if(s) {
			System.out.println(name + "은(는) 없습니다.");
		}
	}

}
