package study.Day0306;

import java.util.Scanner;

class Employee {
	public static final String EMPNAME = "삼성전자";

	private String name;
	private String addr;
	private int gibon;
	private int sudang;
	private int co;

	public void setName(String name) {
		this.name = name;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	public void setPrice(int gibon, int sudang) {
		this.gibon = gibon;
		this.sudang = sudang;
	}
	public void setCo(int co) {
		this.co = co;
	}

	public String getName() {
		return this.name;
	}

	public String getAddr() {
		return this.addr;
	}

	public int getGibon() {
		return this.gibon;
	}

	public int getSudang() {
		return this.sudang;
	}
	public int getCo() {
		return this.co;
	}

	public int getTax() {
		return (int) (gibon * 0.03);
	}

	public int getNetPay() {
		return gibon + sudang - getTax();
	}

}

public class Ex08Q1 {
	static Scanner sc = new Scanner(System.in);
	public static void writeSawon(Employee e) {		
		System.out.print( e.getCo() + "\t" + e.getName() + "\t" + e.getAddr()+ "\t" + e.getGibon() + "\t" + e.getSudang() + "\t" + e.getTax() + "\t" + e.getNetPay() + "\n");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.print("사원수를 입력해주세요.");
		int cnt = Integer.parseInt(sc.nextLine());
		Employee [] s = new Employee[cnt];
		for (int i = 0; i < s.length; i++) {
			s[i] = new Employee();
			s[i].setCo(i+1);
			System.out.println("이름을 입력하세요");
			String name = sc.nextLine();
			s[i].setName(name);
			System.out.println("주소를 입력하세요");
			String addr = sc.nextLine();
			s[i].setAddr(addr);
			System.out.println("기본급을 입력하세요");
			int gibon = Integer.parseInt(sc.nextLine());
			System.out.println("수당을 입력하세요");
			int sudang = Integer.parseInt(sc.nextLine());
			s[i].setPrice(gibon, sudang);
		}
		System.out.println("회사명 : " + Employee.EMPNAME);
		System.out.print("번호\t사원명\t주소\t기본급\t수당\t세금\t실수령액\n");
		System.out.println("=".repeat(50));
		for (Employee employee : s) {
			writeSawon(employee);
			
		}
		
		/*
		 * [클래스 문제]
		 * 
		 * 
		 * 클래스명 Employee
		 * 
		 * 멤버변수 회사명명 EMPNAME=”삼성전자” 사원명 name 주소 addr 기본급 gibon 수당 sudang
		 * 
		 * 
		 * 메서드 기본 setter & getter
		 * 
		 * 세금구하는 메서드 (기본급의 3프로 반환) : 메서드명 getTax() 실수령액 반환하는 메서드 getNetPay() : 기본급+수당-세금
		 * 출력하는 메서드 writeSawon()
		 * 
		 * 
		 * 메인 cnt : 처음 입력할 갯수부터 입력후 배열할당하세요
		 * 
		 * 순서대로 사원명,주소,기본급,수당 을 인원수만큼 입력후 출력하세요
		 * 
		 * 
		 * 출력 예시
		 * 
		 * “삼성전자” 직원 현황
		 * 
		 * 번호 사원명 주소 기본급 수당 세금 실수령액
		 * —------------------------------------------------------------ 1 이영자 강남구
		 * 2500000 300000 75000 2725000
		 * 
		 */
		

	}


}
