package study.Day0310;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Ex03Map {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Map 인터페이스를 구현하는 HashMap, TreeMap
		//key 와 value 의 쌍으로 저장되는 구조
		//이때 key의 타입이 Set이다 (중복허용 x , 비순차적)
		int[]arr ;
		Map<String, String>map = new HashMap<>();
		map.put("name", "이효리");
		map.put("addr", "강남구");
		map.put("blood", "AB형");
		
		System.out.println(map.size());
		//key를 이용해서 value 값을 얻는다
		System.out.println("이름 : " + map.get("name"));
		System.out.println("주소 : " + map.get("addr"));
		System.out.println("혈액형 : " + map.get("blood"));
		
		map.put("name", "어이 송씨");
		System.out.println(map.size());
		System.out.println("이름 : " + map.get("name"));//덮어쓰기
		System.out.println("나이 : " + map.get("age"));//key가 없을경우 null
		
		//일괄적으로 map에 들어있는 모든 값을 얻고자 한다면
		Set<String> KeySet = map.keySet();//key 들만 얻는다 (set타입)
		System.out.println("=".repeat(30));
		for (String key:KeySet) {
			String v = map.get(key);
			System.out.println(key + "=>" + v);
		}
		arr = new int[map.size()];
		for (int i = 0; i < map.size(); i++) {
			arr[i] = map.get(i);
			String v = map.get(arr[i]);
			System.out.println(i + "=>" + v);
		}
	}

}
