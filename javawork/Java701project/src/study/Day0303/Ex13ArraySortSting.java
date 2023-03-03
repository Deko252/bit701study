package study.Day0303;

public class Ex13ArraySortSting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] names = {"홍길동","강호동","James","남순희","신지아"};
		String name;
		//오름차순 정렬해서 출력하기
		for (int i = 0; i < names.length; i++) {
			for (int j = i+1; j < names.length; j++) {
				if(names[i].compareTo(names[j]) > 0) {
					// ex)a<b 나중에 오는 값이 작으면(오름차순) 양수, 크면(내림차순) 음수 
					name = names[i];
					names[i] = names[j];
					names[j] = name;
				}
			}
			System.out.println(names[i]);	
		}
	}

}
