package study.Day0303;

public class Ex11ArrayRank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] score = {90,89,67,89,100};
		int [] rank = new int[5];

		
		//등수구하기 , 동정인경우 동순위
		//출력
		System.out.println("점수\t등수");
		System.out.println("=".repeat(20));
		for (int i = 0; i < rank.length; i++) {
			for (int j = 0; j < rank.length; j++) {
				if(score[i] < score[j]) {
					rank[i]++;
				}
			}
			rank[i]++;
			System.out.println(score[i] + "점\t"+rank[i]+"등");
		}
	}

}
