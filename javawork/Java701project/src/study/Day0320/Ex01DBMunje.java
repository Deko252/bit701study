package study.Day0320;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import study.Day0310.Emp;

//오라클 or Mysql
//
//bitcamp(테이블 명)
//
//    시퀀스번호    num  숫자
//    이 름            name  문자열
//   자바점수         java    숫자 ( 1-100 만 입력가능 bitcamp_ck_java)
//   스프링점수      spring   숫자( 위와 동일)
//   글쓴날짜         today   날짜
//
//** 데이타 10개 정도 추가
//
//
//자바(파일 새로 만든후)
//
//전체 출력   2. 이름검색  3. 평균검색  4.종료
//
//
//1 번 누르면 전체 출력 (번호 이름 자바  스프링 합계  평균 날짜(년월일))
//
//2번 누르면 이름입력(이름으로 시작하는 데이타 출력)  (번호 이름 자바  스프링 합계  평균 날짜(년월일))
//
//3번 누르면  
//       평균점수를 입력하면 그 점수 이상의 데이타만 출력합니다 
//       90  <- 평균이 90 이상인 데이타만 출력

public class Ex01DBMunje {
	static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL = "jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";

	Ex01DBMunje() {
		try {
			Class.forName(MYSQL_DRIVER);
			System.out.println("MYSQL 드라이버 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("MYSQL 드라이버 실패" + e.getMessage());
		}
	}

	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(MYSQL_URL, "angel", "1234");
			System.out.println("로컬 MYSQL 연결 성공");
		} catch (SQLException e) {
			System.out.println("로컬 MYSQL 연결 실패" + e.getMessage());
		}
		return conn;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Ex01DBMunje q1 = new Ex01DBMunje();
		int select;
		System.out.println("1.전체 출력   2. 이름검색  3. 평균검색 4.데이터 추가 5.종료");
		System.out.println("번호를 입력해 주세요");
		while (true) {
			select = Integer.parseInt(sc.nextLine());
			switch (select) {
			case 1:
				q1.all();
				System.out.println("=".repeat(60));
				System.out.println("1.전체 출력   2. 이름검색  3. 평균검색 4.데이터 추가 5.종료");
				System.out.println("번호를 입력해 주세요");
				break;
			case 2:
				q1.search();
				System.out.println("=".repeat(60));
				System.out.println("1.전체 출력   2. 이름검색  3. 평균검색 4.데이터 추가 5.종료");
				System.out.println("번호를 입력해 주세요");
				break;
			case 3:
				q1.avg();
				System.out.println("=".repeat(60));
				System.out.println("1.전체 출력   2. 이름검색  3. 평균검색 4.데이터 추가 5.종료");
				System.out.println("번호를 입력해 주세요");
				break;
			case 4:
				q1.insertData();
				System.out.println("=".repeat(60));
				System.out.println("1.전체 출력   2. 이름검색  3. 평균검색 4.데이터 추가 5.종료");
				System.out.println("번호를 입력해 주세요");
				break;
			case 5 :
				System.out.println("=".repeat(60));
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			default:
				System.out.println("잘못 입력 했어요 다시 입력하세요");
				System.out.println("1.전체 출력   2. 이름검색  3. 평균검색 4.데이터 추가 5.종료");
				continue;
			}
		}
	}

	public void all() {
		Connection conn = this.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select" + " num,name,java,spring,today" + " from bitcamp";
		System.out.println("번호 \t 이름 \t 자바점수 \t스프링점수\t합계\t평균\t    날짜");
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				int java = rs.getInt("java");
				int spring = rs.getInt("spring");
				String today = rs.getString("today");

				System.out.println(num + "\t" + name + "\t  " + java + "      \t    " + spring + "  \t"
						+ (java + spring) + " \t " + (java + spring)/2 + "  \t  " + today);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

	public void search() {
		Scanner sc = new Scanner(System.in);
		Ex01DBMunje q1 = new Ex01DBMunje();
		while (true) {
			System.out.println("검색할 이름 입력해 주세요(종료:exit)");
			String name = sc.nextLine();
			if (name.equalsIgnoreCase("exit")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			Connection conn = this.getConnection();
			Statement stmt = null;
			ResultSet rs = null;
			String sql = "select count(*) from bitcamp where name like '%" + name + "' or  name like '" + name + "%'";
			int cnt = 0;		
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				if (rs.next()) {
					cnt = rs.getInt("count(*)");// 열 이름으로 가지고오기
					// cnt = rs.getInt(1);//열 번호 가자고오기
					
				}
				if (cnt == 0) {
					System.out.println("\"" + name + "\" 검색 결과가 없습니다.");
					continue;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					rs.close();
					stmt.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			Connection conn1 = this.getConnection();
			Statement stmt1 = null;
			ResultSet rs1 = null;
			String sql1 = "select * from bitcamp where name like '%" + name +"' or  name like '" + name + "%'";
			try {
				stmt1 = conn1.createStatement();
				rs1 = stmt1.executeQuery(sql1);
				System.out.println();
				System.out.println("\""+name + "\" 검색 결과");
				System.out.println("-".repeat(30));
				System.out.println("번호" + "  "+ "이름" + "  "+ "자바점수" + "  "+ "스프링점수" + "         "+ "날짜");
				System.out.println("=".repeat(60));			
				
				while(rs1.next()) {
					int num = rs1.getInt("num");
					String names = rs1.getString("name");			
					int java = rs1.getInt("java");
					int spring = rs1.getInt("spring");
					//String today = rs.getString("today");
					Timestamp today = rs1.getTimestamp("today");
					//SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					//SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd EEEE");
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
					
					System.out.println(num + "    "+ names + "    "+ java + "        "+ spring + "          " + dateFormat.format(today));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					if(rs1!=null) {
						rs1.close();
					}
					if(stmt1!=null) {
						stmt1.close();
					}
					if(conn1!=null) {
						conn1.close();
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			
		}
			
		}
	

	public void avg() {
		Scanner sc = new Scanner(System.in);
		Ex01DBMunje q1 = new Ex01DBMunje();
		while (true) {
			System.out.println("검색할 평균 입력해 주세요(종료:0)");
			int avg = sc.nextInt();
			if (avg == 0) {
				System.out.println("프로그램을 종료합니다");
				break;
			}
			Connection conn = this.getConnection();
			Statement stmt = null;
			ResultSet rs = null;
			String sql = "select count(*) from bitcamp where (java+spring)/2 >= " + avg;
			int cnt = 0;		
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				if (rs.next()) {
					cnt = rs.getInt("count(*)");// 열 이름으로 가지고오기
					// cnt = rs.getInt(1);//열 번호 가자고오기
					
				}
				if (cnt == 0) {
					System.out.println("\"" + avg + "\" 이상 평균을 가진 검색 결과가 없습니다.");
					continue;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					rs.close();
					stmt.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			Connection conn1 = this.getConnection();
			Statement stmt1 = null;
			ResultSet rs1 = null;
			String sql1 = "select * from bitcamp where (java+spring)/2 >= " + avg;
			try {
				stmt1 = conn1.createStatement();
				rs1 = stmt1.executeQuery(sql1);
				System.out.println();
				System.out.println("\"평균 : "+avg + "\" 검색 결과");
				System.out.println("-".repeat(30));
				System.out.println("번호" + "  "+ "이름" + "  "+ "자바점수" + "  "+ "스프링점수" + "    "+ "평균" + "         " + "날짜");
				System.out.println("=".repeat(60));			
				
				while(rs1.next()) {
					int num = rs1.getInt("num");
					String names = rs1.getString("name");			
					int java = rs1.getInt("java");
					int spring = rs1.getInt("spring");
					//String today = rs.getString("today");
					Timestamp today = rs1.getTimestamp("today");
					int avg2 = (java+spring)/2;
					//SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					//SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd EEEE");
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
					
					System.out.println(num + "    "+ names + "    "+ java + "        "+ spring + "          " + avg2 + "      " +dateFormat.format(today));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					if(rs1!=null) {
						rs1.close();
					}
					if(stmt1!=null) {
						stmt1.close();
					}
					if(conn1!=null) {
						conn1.close();
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			
		}
	}
	
	//데이터 추가
	public void insertData() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("이릅을 입력해 주세요.");
		String name = sc.nextLine();
		System.out.println("자바 점수를 입력해 주세요.");
		int java = sc.nextInt();
		System.out.println("스프링 점수를 입력해 주세요");
		int spring = sc.nextInt();
		
		Connection conn = this.getConnection();
		Statement stmt = null;
		int rs = 0;
		String sql = "insert into bitcamp values(null,'"+ name +"',"+ java +"," + spring + ",now())";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeUpdate(sql);
				System.out.println("이름 : " + name + "\t자바점수 : " + java + "\t스프링점수 : " + spring + " 데이터를 추가했습니다." );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	//
}
