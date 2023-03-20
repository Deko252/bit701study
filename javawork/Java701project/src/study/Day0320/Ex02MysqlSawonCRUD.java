package study.Day0320;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Ex02MysqlSawonCRUD {
	static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL = "jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
	Scanner sc = new Scanner(System.in);
	void Ex02MysqlSawon() {
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
			//System.out.println("로컬 MYSQL 연결 성공");
		} catch (SQLException e) {
			System.out.println("로컬 MYSQL 연결 실패" + e.getMessage());
		}
		return conn;
	}

	
	//메뉴 반환
	public int getMenu() {
		int select;
		Ex02MysqlSawonCRUD q1 = new Ex02MysqlSawonCRUD();
		System.out.println(" -- 메뉴 -- ");
		System.out.println(" 1.사원 추가   \n 2. 전체사원 출력  \n 3.이름으로 검색 \n 4.이름으로 삭제 \n 5.시퀀스번호로 수정 \n 6.남여 성별로 분석 \n 7.부서별 분석 \n 8.종료");
		System.out.println("번호를 입력해 주세요");
		select = Integer.parseInt(sc.nextLine());
		return select;
	}
	//사원추가
	public void addSawon() {
		System.out.println("추가할 사원명은 ? ");
		String name = sc.nextLine();
		System.out.println("사원 점수는 ? ");
		int score = Integer.parseInt(sc.nextLine());
		System.out.println("성별 선택 1.남자 2.여자");
		int gidx = Integer.parseInt(sc.nextLine());
		if(!(gidx == 1 || gidx == 2)) {
			System.out.println("잘못 입력 했습니다.");
			return; // 현재 메서드 종료
		}
		String gender = gidx==1?"남자":"여자";
		System.out.println("사원이 속한 부서명을 입력하세요.");
		String buseo = sc.nextLine();
		
		
		Connection conn = getConnection();
		Statement stmt = null;
		String  sql = "";
		
		sql = "insert into sawon values (null, '" + name + "'," + score + ",'" + gender + "','" + buseo + "')";
		//System.out.println(sql);
		try {
			stmt = conn.createStatement();
			stmt.execute(sql);
			System.out.println("사원 데이터가 추가 되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}
	}
	
	//사원 전체 출력
	public void writeSawon() {
		Connection conn = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String  sql = "";
		sql = "select * from sawon order by num";
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			System.out.println(" ** 전체 사원 명단 **");
			System.out.println();
			System.out.println("번호\t사원명\t성별\t부서명\t점수");
			System.out.println("=".repeat(40));
			while(rs.next()) {
				System.out.println(rs.getInt("num") + "\t" 
						+ rs.getString("name") + "\t" 
						+ rs.getString("gender") + "\t" 
						+ rs.getString("buseo") + "\t" 
						+ rs.getInt("score"));
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
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}
	}
	
	//이름으로 검색
	public void searchSawonName() {
		
		System.out.println("검색할 사원명을 입력하세요");
		String searchName = sc.nextLine();
		
		Connection conn = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String  sql = "";
		sql = "select * from sawon where name = '" + searchName + "'";
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			System.out.println("\""+searchName + "\" 사원 검색결과");
			
			while(rs.next()) {
				System.out.println("-----------------------");
				System.out.println("성별 : " + rs.getString("gender"));
				System.out.println("부서 : " + rs.getString("buseo"));
				System.out.println("점수 : " + rs.getInt("score"));
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
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}
	}
	
	//이름으로 삭제
	public void deleteSawonName() {
		
		System.out.println("삭제할 이름을 입력해 주세요.");
		String name = sc.nextLine();
		
		Connection conn = getConnection();
		Statement stmt = null;
		String  sql = "";
		sql = "delete from sawon where name = '" + name + "'";
		
		try {
			stmt = conn.createStatement();
			int n = stmt.executeUpdate(sql);//반환타입 : 성공적으로 삭제된 데이터 갯수
			if(n==0) {
				System.out.println("사원중 '" + name + "' 님은 없습니다.");
			}else {
				System.out.println("총 '" + n + "'명의 '" + name + "' 님이 삭제되었습니다.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}
	}
	
	//시퀀스번호로 수정
	public void updateSawonNum() {
		System.out.println("수정할 시퀀스 번호를 입력하세요");
		int num = Integer.parseInt(sc.nextLine());
		System.out.println("수정할 이름은 ?");
		String name = sc.nextLine();
		System.out.println("수정할 부서는?");
		String buseo = sc.nextLine();
		
		Connection conn = getConnection();
		Statement stmt = null;
		String  sql = "";
		sql = "update sawon set buseo = " + buseo + " where name = '" + name + "' and num = " + num ;
		//System.out.println(sql);
		
		try {
			stmt = conn.createStatement();
			int n = stmt.executeUpdate(sql);
			if(n==0) {
				System.out.println("해당 번호는 없습니다.");
			}else {
				System.out.println("사원의 정보를 수정했습니다.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}
	}
	
	//남여 분석
	public void analysisGender() {
		Connection conn = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String  sql = "";
		sql = "select gender,count(*) count, round(avg(score),1) avg from sawon group by gender";
		
		try {	
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			System.out.println("성별\t인원수\t평균");
			while(rs.next()) {
				String gender = rs.getString("gender");
				int avg = rs.getInt("avg");
				int count = rs.getInt("count");
				System.out.println(gender + "\t"+ count + "\t" + avg);				
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
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}
	}
	
	//부서별 분석
	public void analysisBuseo() {
		Connection conn = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String  sql = "";
		sql = "select buseo,count(*) count, round(avg(score),1) avg from sawon group by buseo";
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			System.out.println("부서\t인원수\t평균");
			while(rs.next()) {
				String buseo = rs.getString("buseo");
				int avg = rs.getInt("avg");
				int count = rs.getInt("count");
				System.out.println(buseo + "\t"+ count + "\t" + avg);				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex02MysqlSawonCRUD q1 = new Ex02MysqlSawonCRUD();
		while (true) {
			switch (q1.getMenu()) {
			case 1:
				q1.addSawon();
				break;
			case 2:
				q1.writeSawon();
				break;
			case 3:
				q1.searchSawonName();
				break;
			case 4:
				q1.deleteSawonName();
				break;
			case 5 :
				q1.updateSawonNum();
				break;
			case 6 :
				q1.analysisGender();
				break;
			case 7 :
				q1.analysisBuseo();
				break;
			default:
				System.err.println("프로그램 종료");
				System.exit(0);
			}
		}
	}
}
