package study.Day0307;

class Animal
{
	private String animalName;
	
	Animal(String animalName)
	{
		this.animalName=animalName;
	}
	
	public void writeData()
	{
		System.out.println("animalName="+animalName);		
	}
}

class Dog extends Animal
{
	private String animalColor;
	
	Dog(String animalName,String animalColor)
	{
		super(animalName);//반드시 첫줄
		this.animalColor=animalColor;
	}
	
	/*
	 * 부모가 가진 메서드와 동일한 메서드명과 인자를 가진 메서드를 구현
	 * 미완성의 메서드를 완성할 목적으로 오버라이드한다
	 * @Override : @를 어노테이션이라고 한다,오버라이드 규칙에 어긋나지 않도록 해준다(어긋날경우 오류발생)
	 */
	@Override
	public void writeData() {
		// TODO Auto-generated method stub
		super.writeData();//부모가 먼저 처리할경우 첫줄,어디에 넣든 상관없다
		System.out.println("animalColor="+animalColor);
	}
}

public class Ex14Inheri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog d1=new Dog("리트리버", "갈색");
		d1.writeData();
		
		//Dog d2=new Dog("스피츠", "흰색");
		
		//super 클래스로 선언한경우 오버라이드 메서드와 부모가 가진 메서드만 호출 가능하다
		//즉 sub가 가진 메서드는 호출할수 없다
		Animal d2=new Dog("스피츠", "흰색");
		d2.writeData();
	}

}









