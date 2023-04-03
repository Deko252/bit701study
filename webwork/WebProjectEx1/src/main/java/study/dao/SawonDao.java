package study.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import db.DbConnect;
import study.dto.SawonDto;

public class SawonDao {
	DbConnect db = new DbConnect();
	
	// db에서 데이타를 list 에 담아서 리턴하는 메서드
		public List<SawonDto> getAllSawon() {
			List<SawonDto> list = new Vector<>();
			Connection conn = db.getMysqlConnection();
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			String sql = "select * from sawon order by num asc";

			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					SawonDto dto = new SawonDto();
					// dto 에 데이타를 넣는다
					dto.setNum(rs.getInt("num"));
					dto.setName(rs.getString("name"));
					dto.setScore(rs.getInt("score"));
					dto.setGender(rs.getString("gender"));
					dto.setBuseo(rs.getString("buseo"));
					// dto를 list 에 추가한다
					list.add(dto);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				db.dbClose(rs, pstmt, conn);
			}

			return list;
		}
		
		// db에서 데이타를 list 에 담아서 리턴하는 메서드
				public SawonDto getSelectSawon(String gender) {
					SawonDto dto = new SawonDto();
					Connection conn = db.getMysqlConnection();
					PreparedStatement pstmt = null;
					ResultSet rs = null;

					String sql = "select * from sawon where gender = ? order by num asc";

					try {
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, gender);
						rs = pstmt.executeQuery();
						while (rs.next()) {
							// dto 에 데이타를 넣는다
							dto.setNum(rs.getInt("num"));
							dto.setName(rs.getString("name"));
							dto.setScore(rs.getInt("score"));
							dto.setGender(rs.getString("gender"));
							dto.setBuseo(rs.getString("buseo"));
							// dto를 list 에 추가한다
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						db.dbClose(rs, pstmt, conn);
					}
					return dto;
				}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
