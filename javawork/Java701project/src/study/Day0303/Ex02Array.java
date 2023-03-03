package study.Day0303;

public class Ex02Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] names = new String[5];//null 값 으로 초기화
		int [] scores = new int[5];//0으로 초기화값
		
		//데이터 넣기
		names[0] = "한가인";
		scores[0] = 98;
		names[1] = "한인";
		scores[1] = 95;
		names[2] = "한가";
		scores[2] = 86;
		names[3] = "인";
		scores[3] = 25;
//		names[4] = "가인";
//		scores[4] = 85;
		
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i] + "\t" + scores[i]);
		}
		
	}

}
