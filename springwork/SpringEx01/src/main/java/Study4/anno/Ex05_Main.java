package Study4.anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex05_Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("appContext2.xml");
		Car car = (Car) context.getBean("car"); 
		car.myCarTire();
		
	}
}
