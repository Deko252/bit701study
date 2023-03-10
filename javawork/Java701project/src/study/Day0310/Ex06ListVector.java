package study.Day0310;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.Iterator;

public class Ex06ListVector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//list 인터페이스를 구현한 클래스
		//Vector<String> list1 = new Vector<>();//일단 10개로 할당 // 기본값 10개
		//Vector<String> list1 = new Vector<>(5);//일단 5개로 할당 , 초과될 경우 2배로 늘어난다
		Vector<String> list1 = new Vector<>(5,3);//일단 5개로 할당 , 초과될 경우 3개씩 늘어난다
		
		System.out.println("size는 실제 데이터가 들어있는 갯수: " + list1.size());//0
		System.out.println("capacity 는 할당 갯수 : " + list1.capacity());//10 vector만이 가지고있는 메서드
		
		list1.add("장미꽃");
		list1.add("코스코스");
		list1.add("안개꽃");
		list1.add("장미꽃");
		
		System.out.println(list1.size());//중복 제거 x
		
		List<String> list2 = new Vector<>();
		//나열된 문자열이 List 타입으로 변환되서 리턴
		list2 = Arrays.asList("빨강색","파란색","노란색","검정색","분홍색");
		System.out.println(list2.size());
		
		System.out.println("-- list1 출력 --");
		int n = 1;
		for (String s : list1) {
			System.out.println(n++ + ":" + s);
		}
		
		System.out.println("++ list2 출력 ++");
		for (int i = 0; i < list2.size(); i++) {
			String s = list2.get(i);
			System.out.println(i+1 + ":" + s);
		}
		
		System.out.println("-- list2 출력 --");
		n=1;
		Iterator<String> iter = list2.iterator();
		while(iter.hasNext()) {
			String s = iter.next();
			System.out.println(n++ + ":" + s);
		}
	}

}
