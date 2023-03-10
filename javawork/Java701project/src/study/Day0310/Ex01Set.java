package study.Day0310;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Ex01Set {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Set 인터페이스를 구현한 클래스 HashSet : 비순차적
		//								 TreeSet : 정렬되어 나옴, 중복허용X
		//제네릭스 : <String> : String 타입만 넣을수 있다는 뜻
		Set<String> set1 = new HashSet<>();
		Set<Integer> set2 = new TreeSet<>();
		
		set1.add("apple");
		set1.add("orange");
		set1.add("apple");
		set1.add("banana");
		//set1.add(3) 오류발생 - generics 때문에
		
		
		System.out.println("set1 = " + set1.size() + "개"); //3개 .. apple은 1번으로 계산
		
		System.out.println(" *** 출력 ***");
		for (String s : set1) {
			System.out.println(s);//추가한 순서대로 안나온다 (비 순차적)
			
		}
		
		System.out.println("** 출력 2 **");
		Iterator<String> iter = set1.iterator();
		while (iter.hasNext()) {//hasNext(); 다음 데이터가 있을경우 true:true인 동안 반복하면 된다
			String s = iter.next();//다음 데이터를 얻어서 출력
			System.out.println(s);
			
		}
		//set2 : 배열에 int를 넣은후 set2에 넣기
		int[]arr= {4,8,5,9,1,6};
		for (int a : arr) {
			set2.add(a);
			
		}
		System.out.println("set2 = " + set2.size() + "개");
		
		for(int a:set2) {//중복 x 숫자 정렬
			System.out.printf("%5d",a);
		}
	}

}
