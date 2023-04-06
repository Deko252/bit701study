package Study3;

public class Person {
	MyShop myShop;
	String name;
	String address;
	
	public Person(String name, String address) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.address=address;
	}
	
	
	
	public void setMyShop(MyShop myShop) {
		this.myShop = myShop;
	}



	public void write() {
		// TODO Auto-generated method stub
		System.out.println("* *  상품 구입정보  * *");
		myShop.showShop();
		
		System.out.println("이름 : " + name);
		System.out.println("주소 : " + address);
	}
}
