package study.Day0310;

//T로 String이 전달될경우 멤버변수는 String 배열타입이 되고
//Integer로 전달될겅우 멤버변수는 Integer 의 배열타입이 된다.
class GenericType<T>{
	T[] v;
	
	public void setV(T[] v) {
		this.v = v;
	}
	public void print() {
		for (T n : v) {
			System.out.println(n);
		}
		System.out.println("=".repeat(30));
	}
}

public class Ex04Type {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] color = {"Red","Yellow","Blue","Green"};
		GenericType<String> list1 = new GenericType<>();
		list1.setV(color);
		list1.print();
		
		Integer [] nums = {100, 300, 200, 67};
		GenericType<Integer> list2 = new GenericType<>();
		
		list2.setV(nums);
		list2.print();
		}
	}

