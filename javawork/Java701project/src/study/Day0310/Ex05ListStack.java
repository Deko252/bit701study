package study.Day0310;

import java.util.Stack;

public class Ex05ListStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> list1 = new Stack<>();
		list1.push("사과");
		list1.push("과사");
		list1.push("나나바");
		list1.push("사과");
		
		System.out.println(list1.size());
		
		while(!list1.isEmpty()) {
			System.out.println(list1.pop());
		}
	}

}
