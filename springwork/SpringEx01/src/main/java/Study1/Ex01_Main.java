package Study1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex01_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//자바 방식으로 호출해보자
		
		MessageInter m1 = new Message01();
		m1.sayHello("양말");
				
		MessageInter m2 = new Message02();
		m2.sayHello("고기");
		
		//스프링 방식으로 호출
		ApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
		MessageInter m3 = (Message01)context.getBean("mes1");//방법1
		MessageInter m33 = (Message01)context.getBean("mes1");
		MessageInter m4 = context.getBean("mes2", Message02.class);//방법2
		
		
		m3.sayHello("이영자");
		m33.sayHello("이영자33");
		
		//scope = "singletone" 인경우 두 주소가 서로 같다(singletone)
		System.out.println("주소비교 : " + m3.hashCode() + " : " + m33.hashCode());
		
		//scope = "prototype" 인경우 두 주소가 서로 다르다(prototype)
		System.out.println("주소비교 : " + m3.hashCode() + " : " + m33.hashCode());
		
		m4.sayHello("강호동");
	}

}
