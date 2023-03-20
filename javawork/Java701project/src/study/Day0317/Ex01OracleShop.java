package study.Day0317;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Ex01OracleShop {
	static final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
	static final String ORACLE_URL="jdbc:oracle:thin:@localhost:1521:xe";
	//static final String ORACLE_URL="jdbc:oracle:thin:@192.168.0.24:1521:xe";//강사 pc
	
	Ex01OracleShop(){
		try {
			Class.forName(ORACLE_DRIVER);
			System.out.println("오라클 드라이버 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버 실패" + e.getMessage());
		}
	}
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(ORACLE_URL, "angel", "a1234");
			System.out.println("로컬 오라클 연결 성공");
		} catch (SQLException e) {
			System.out.println("로컬 오라클 연결 실패" + e.getMessage());
		}
		return conn;
	}
	
	
	public void writeshop() {
		Connection conn = this.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from shop order by num";
		
		try {
			stmt = conn.createStatement();
			//데이터를 가지고오는 select 문은 무조건 executeQuery() 로 sql문을 실행한다 (반환타입 때문에)
			rs = stmt.executeQuery(sql);
			
			//rs.next()는 다음레코드로 이동 다음 데이터가 있으면 true 반환, 없으면 false
			while(rs.next()) {
				int num = rs.getInt(1);
				String sangpum = rs.getString(2);
				
				int su = rs.getInt("su");
				int dan = rs.getInt("dan");
				String color = rs.getString("color");
				//String today = rs.getString("today");
				Timestamp today = rs.getTimestamp("today");
				//SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				//SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd EEEE");
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				
				System.out.println(num + "\t"+ sangpum + "\t"+ su + "\t"+ dan + "\t" + color + "\t"+ dateFormat.format(today));
			}
			
		} catch (SQLException e) {
			System.out.println("sql 오류"+e.getMessage());
		} finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex01OracleShop ex1 = new Ex01OracleShop();
		//ex1.writeshop();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("검색할 상품명을 입력해 주세요(종료:exit)");
			String sang = sc.nextLine();
			if(sang.equalsIgnoreCase("exit")) {
				System.out.println("프로그램을 종료합니다");
				break;
			}
			int totalCount = ex1.searchCount(sang);
			if(totalCount == 0) {
				System.out.println("\""+sang + "\" 검색 결과가 없습니다.");
				continue;
			}
			
			ex1.searchSangpum(sang);
			
		}
	}
	private int searchCount(String sang) {
		// TODO Auto-generated method stub
		String sql = "select count(*) from shop where sangpum like '%" + sang +"' or  sangpum like '" + sang + "%'";
		Connection conn = this.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		int cnt = 0;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				cnt = rs.getInt("count(*)");//열 이름으로 가지고오기
				//cnt = rs.getInt(1);//열 번호 가자고오기
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cnt;
	}
	private void searchSangpum(String sang) {
		// TODO Auto-generated method stub
		String sql = "select * from shop where sangpum like '%" + sang +"' or  sangpum like '" + sang + "%'";
		Connection conn = this.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			System.out.println();
			System.out.println("\""+sang + "\" 검색 결과");
			System.out.println("-".repeat(30));
			System.out.println("상품번호" + "  "+ "상품명" + "  "+ "상품수량" + "  "+ "상품가격" + "    " + "상품색상" + "    "+ "구매날짜");
			System.out.println("=".repeat(60));

			
			
			while(rs.next()) {
				int num = rs.getInt("num");
				String sangpum = rs.getString("sangpum");			
				int su = rs.getInt("su");
				int dan = rs.getInt("dan");
				String color = rs.getString("color");
				//String today = rs.getString("today");
				Timestamp today = rs.getTimestamp("today");
				//SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				//SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd EEEE");
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				
				System.out.println(num + "\t  "+ sangpum + "       "+ su + "       "+ dan + "  \t" + color + "\t"+ dateFormat.format(today));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

}
