package study.Day0308;

public class Ex01Inheri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s1 = new Student();
		System.out.println(s1.toString());// s1만 쓰면 to String()과 같음
		
		//s1에 값을 넣어보기
		s1.setSchoolName("강남고");
		s1.setSchoolLoc("청담동");
		s1.setStuName("미자");
		s1.setStdAddr("강남구");
		s1.setScore(99);
		System.out.println(s1);
		
		System.out.println("=".repeat(30));
		Student s2 = new Student("역삼고","역삼동","김철수","역삼동",85);
		System.out.println(s2);
	}

}
