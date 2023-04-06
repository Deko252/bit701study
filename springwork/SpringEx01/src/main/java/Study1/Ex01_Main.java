package Study1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex01_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�ڹ� ������� ȣ���غ���
		
		MessageInter m1 = new Message01();
		m1.sayHello("�縻");
				
		MessageInter m2 = new Message02();
		m2.sayHello("���");
		
		//������ ������� ȣ��
		ApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
		MessageInter m3 = (Message01)context.getBean("mes1");//���1
		MessageInter m33 = (Message01)context.getBean("mes1");
		MessageInter m4 = context.getBean("mes2", Message02.class);//���2
		
		
		m3.sayHello("�̿���");
		m33.sayHello("�̿���33");
		
		//scope = "singletone" �ΰ�� �� �ּҰ� ���� ����(singletone)
		System.out.println("�ּҺ� : " + m3.hashCode() + " : " + m33.hashCode());
		
		//scope = "prototype" �ΰ�� �� �ּҰ� ���� �ٸ���(prototype)
		System.out.println("�ּҺ� : " + m3.hashCode() + " : " + m33.hashCode());
		
		m4.sayHello("��ȣ��");
	}

}
