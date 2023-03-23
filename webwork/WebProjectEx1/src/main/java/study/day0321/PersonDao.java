package study.day0321;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import db.DbConnect;

public class PersonDao {
	DbConnect db=new DbConnect();

	//db에서 데이타를 list 에 담아서 리턴하는 메서드
	public List<PersonDto> getAllPersons()
	{
		List<PersonDto> list=new Vector<>();
		Connection conn=db.getMysqlConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		String sql="select * from person order by num asc";

		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				PersonDto dto=new PersonDto();
				//dto 에 데이타를 넣는다
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setBirthyear(rs.getInt("birthyear"));
				dto.setAddress(rs.getString("address"));
				dto.setJob(rs.getString("job"));
				dto.setPhoto(rs.getString("photo"));
				//dto를 list 에 추가한다
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
}
