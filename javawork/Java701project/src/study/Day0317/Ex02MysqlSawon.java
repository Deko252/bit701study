package study.Day0317;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex02MysqlSawon {
	static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL = "jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";

	Ex02MysqlSawon() {
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

	public void writesawon() {
		Connection conn = this.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select" + " s.num,name,gender,buseo,age,hp,addr,score" + " from sawon s, sawoninfo si"
				+ " where s.num = si.num";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int num = rs.getInt("s.num");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				String buseo = rs.getString("buseo");
				int age = rs.getInt("age");
				String hp = rs.getString("hp");
				String addr = rs.getString("addr");
				int score = rs.getInt("score");

				System.out.println("**" + name + " 사원의 개인정보 **");
				System.out.println("사원번호 = " + num + ", 점수 = " + score);
				System.out.println("부서명 : " + buseo);
				System.out.println("나이 : " + age);
				System.out.println("성별 : " + gender);
				System.out.println("주소 : " + addr);
				System.out.println("휴대폰 : " + hp);
				System.out.println("=".repeat(30));
			}

		} catch (Exception e) {
			// TODO: handle exception
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex02MysqlSawon ex2 = new Ex02MysqlSawon();
		ex2.countSawon();
		ex2.writesawon();
		ex2.bunseokSawon();
	}

	private void bunseokSawon() {
		// TODO Auto-generated method stub
		String sql = "select buseo, count(*) count, round(avg(score),1) avgscore, max(score) maxscore,"
				+ "min(score) minscore from sawon group by buseo";
		System.out.println("부서명 인원수 평균점수 최고점수 최저점수");
		System.out.println("=".repeat(40));
		Connection conn = this.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int count = rs.getInt("count");
				String buseo = rs.getString("buseo");
				int avgscore = rs.getInt("avgscore");
				int maxscore = rs.getInt("maxscore");
				int minscore = rs.getInt("minscore");
				System.out.println(buseo + "\t" + count + "\t" + avgscore + "\t" + maxscore + "\t" + minscore);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void countSawon() {
		// TODO Auto-generated method stub
		Connection conn = this.getConnection();
		String sql = "select count(*) cnt from sawon, sawoninfo where sawon.num = sawoninfo.num";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				int cnt = rs.getInt("cnt");
				System.out.println("사원 수 = " + cnt + "명");
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

}
