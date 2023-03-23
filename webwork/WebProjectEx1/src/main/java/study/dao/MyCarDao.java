package study.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.mysql.cj.x.protobuf.MysqlxConnection.Close;

import db.DbConnect;
import study.dto.MyCarDto;


public class MyCarDao {
	DbConnect db = new DbConnect();

	public void insertCar(MyCarDto dto) {
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into mycar values(null,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			
			//바인딩
			pstmt.setString(1, dto.getCarname());
			pstmt.setInt(2, dto.getCarprice());
			pstmt.setString(3, dto.getCarphoto());
			pstmt.setString(4, dto.getBuyday());
			
			//실행
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		
	}

	public List<MyCarDto> getAllCars() {
		List<MyCarDto> list = new Vector<>();
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from mycar order by num asc";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MyCarDto dto = new MyCarDto();
				dto.setNum(rs.getInt("num"));
				dto.setCarname(rs.getString("carname"));
				dto.setCarprice(rs.getInt("carprice"));
				dto.setCarphoto(rs.getString("carphoto"));
				dto.setBuyday(rs.getString("buyday"));
				
				list.add(dto);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.dbClose(rs, pstmt, conn);
		}
		
		return list;

	}

	public void deleteCar(int num) {
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		
		String sql = "delete from mycar where num = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			pstmt.execute();		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt,conn);
		}
	}
	
	//get data
	public MyCarDto getData(int num) {
		MyCarDto dto = new MyCarDto();
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from mycar where num = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setNum(rs.getInt("num"));
				dto.setCarname(rs.getString("carname"));
				dto.setCarprice(rs.getInt("carprice"));
				dto.setBuyday(rs.getString("buyday"));
				dto.setCarphoto(rs.getString("carphoto"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.dbClose(rs, pstmt, conn);
		}
		return dto;

	}
	//update
	public void updateCar(MyCarDto dto) {
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		String sql = "update mycar set carname = ?, carprice = ?, carphoto = ?, buyday = ? where num =?";
		try {
			pstmt = conn.prepareStatement(sql);
			
			//바인딩
			pstmt.setString(1, dto.getCarname());
			pstmt.setInt(2, dto.getCarprice());
			pstmt.setString(3, dto.getCarphoto());
			pstmt.setString(4, dto.getBuyday());
			pstmt.setInt(5, dto.getNum());
			
			//실행
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	
}