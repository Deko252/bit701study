package study.Day0306;

class Person{
	static final String CITY = "Seoul";
	
	private String name;
	private String hp;
	
	//setter
	public void setName(String name) {
		this.name = name; 
	}
	public void setHp(String hp) {
		this.hp = hp; 
	}
	//getter
	public String getName() {
		return this.name;
	}
	public String getHp() {
		return this.hp;
	}
	
	public void setInfo(String name, String hp) {
		setName(name);
		setHp(hp);
	}
}

public class Ex06Object {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Person [] per = new Person[3];//메모리 할당, 생성X
		
		for (int i = 0; i < per.length; i++) {//생성
			per[i] = new Person();
		}
		per[0].setName("아무개");
		per[0].setHp("010-9999-8888");
		
		per[1].setName("개아무");
		per[1].setHp("010-8888-7777");
		
		per[2].setName("무개아");
		per[2].setHp("010-7777-6666");
		
		//출력방법1
		System.out.println("City\tName\tHp");
		for (int i = 0; i < per.length; i++) {
			System.out.println(Person.CITY + "\t" + per[i].getName() + "\t" + per[i].getHp());
			
		}
		System.out.println("_".repeat(30));
		
		//출력방법2
		for(Person p:per) {
			System.out.println(Person.CITY + "\t" + p.getName() + "\t" + p.getHp());
		}
	}

}
