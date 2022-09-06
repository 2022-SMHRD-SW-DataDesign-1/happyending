package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	
	//insert회원가입 
	public int insert(DTO dto) {
		int cnt =0;
		
		connect();
	   
		try {
			 String or_id = dto.getUser_id();
			 String or_pw = dto.getUser_pw();
			 String or_name = dto.getUser_name();
			 int or_age = dto.getAge();
			 String start_day = dto.getStart_day();
			 String last_day = dto.getLast_day();
				
			 String sql = "insert into users values(?,?,?,?,?,?,?)";//id,pw,name,age,level,coin,ex
			 psmt = conn.prepareStatement(sql);
			 
			 psmt.setString(1, or_id);
			 psmt.setString(2, or_pw);
			 psmt.setString(3, or_name);
			 psmt.setInt(4, or_age);
			 psmt.setInt(5, 1);
			 psmt.setInt(6,0);
			 psmt.setInt(7, 0);
			 
			 
			 
			 cnt = psmt.executeUpdate();
			 if(cnt>0) {
				 System.out.println("쿼리전송성공.");
			 }else {
				 System.out.println("쿼리전송 실패.");
			 }
			 
			 
			 String sql2 ="insert into log values(?,?,?)";
			 psmt =conn.prepareStatement(sql2);
			 psmt.setString(1, or_id);
			 psmt.setString(2, start_day); //setDate가 있는데 잠시 대기.
			 psmt.setString(3, last_day);
			 cnt = psmt.executeUpdate();
			 
			 
			
		} catch (SQLException e) {
			System.out.println("쿼리전송 실패.");
		}
		

		
			try {
				if(conn!=null) {
					conn.close();
				}
				if(psmt!=null) {
					psmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
		
		return cnt;	
	}

	public ResultSet selectCreateUser(DTO dto) {
		connect();
		
		String sql = "select name from users";
		
		try {
			psmt =conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				//.equals(rs.getString(1));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return rs;
	}


	
	
	
	
	
	
	
	
	
	
	
	private void connect() {
		//동적로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		//db연결
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String id = "campus_g_0830_5";
			String pw = "smhrd5";
			
			//힌번에 묶기
		conn = DriverManager.getConnection(url,id,pw);
		} catch (ClassNotFoundException e) {
			System.out.println("동적로딩실패.");
		} catch (SQLException e) {
			System.out.println("db연결 실패.");
		}
	}

}
