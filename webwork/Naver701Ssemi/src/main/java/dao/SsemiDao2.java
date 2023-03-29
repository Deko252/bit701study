package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Vector;

import db.DbConnect;
import dto.SsemiDto2;

public class SsemiDao2 {
	DbConnect db = new DbConnect();
	
	//insert
	public void insertcklist(SsemiDto2 dto) {
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		String slq = "insert into cklist (name, birthyear, phone, photo, content, law) values(?,?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(slq);
			
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getBirthyear());
			pstmt.setInt(3, dto.getPhone());
			pstmt.setString(4, dto.getPhoto());
			pstmt.setString(5, dto.getContent());
			pstmt.setString(6, dto.getLaw());
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	//allempo 전부 가지고와서 화면 출력
		public List<SsemiDto2> getallcklist(){
			List<SsemiDto2> list = new Vector<>();
			Connection conn = db.getMysqlConnection();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String sql = "select * from cklist order by num asc";
			
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					int num = rs.getInt("num");
					String name = rs.getString("name");
					int birthyear = rs.getInt("birthyear");
					int phone = rs.getInt("phone");
					String law = rs.getString("law");
					Timestamp writeday = rs.getTimestamp("writeday");
					
					SsemiDto2 dto = new SsemiDto2(num, name, birthyear, phone, writeday, law);
					
					list.add(dto);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				db.dbClose(rs, pstmt, conn);
			}
			
			
			return list;
			
		}
		//getdata (클릭한 데이터 가지고오기)
		public SsemiDto2 getdata(int num) {
			SsemiDto2 dto = new SsemiDto2();
			Connection conn = db.getMysqlConnection();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "select * from cklist where num = ?";
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, num);
				rs = pstmt.executeQuery();
			
				if(rs.next()) {
					dto.setNum(rs.getInt("num"));
					dto.setName(rs.getString("name"));
					dto.setBirthyear(rs.getInt("birthyear"));
					dto.setPhone(rs.getInt("phone"));	
					dto.setPhoto(rs.getString("photo"));
					dto.setContent(rs.getString("content"));
					dto.setWriteday(rs.getTimestamp("writeday"));
					dto.setLaw(rs.getString("law"));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				db.dbClose(rs, pstmt, conn);
			}
			
			return dto;
		}
	
	public static void main(String[] args) {
		

	}

}
