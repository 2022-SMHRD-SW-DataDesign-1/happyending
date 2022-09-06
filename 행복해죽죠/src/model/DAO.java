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
	public int insertCreateUser(DTO dto) {
		int cnt =0;
		
		connect();
	   
		try {
			 String or_id = dto.getUser_id();
			 String or_pw = dto.getUser_pw();
			 String or_name = dto.getUser_name();
			 int or_age = dto.getAge();
			 String start_day = dto.getStart_day();
			 String last_day = dto.getLast_day();
				
			 String sql = "insert into users values(?,?,?,?,?,?,?,?)";//id,pw,name,age,level,coin,ex
			 psmt = conn.prepareStatement(sql);
			 
			 psmt.setString(1, or_id);
			 psmt.setString(2, or_pw);
			 psmt.setString(3, or_name);
			 psmt.setInt(4, or_age);
			 psmt.setInt(5, 1);
			 psmt.setInt(6,0);
			 psmt.setInt(7, 0);
			 psmt.setInt(8, 0);
			 
			 
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
	//회원가입 도중 중복체크
	String overlap ="";
	public String selectCreateUser(DTO dto) {
		connect();
		
		String sql = "select user_id from users";
		
		try {
			psmt =conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				if((dto.getUser_id()).equals(rs.getString(1))) {
					overlap = "이미 존재하는 ID 입니다.";
				}
				else {
					overlap = "사용가능한 ID입니다.";
				}
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(conn!=null) {
				conn.close();
			}
			if(psmt!=null) {
				psmt.close();
			}
			if(rs!=null) {
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return overlap;
	}

	//로그인
	public String login(DTO dto) {
		connect();
		String ment ="";
		String sql ="select user_id,pw from users";
		
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				if((dto.getUser_id()).equals(rs.getString(1)) && (dto.getUser_pw()).equals(rs.getString(2))) {
					ment = "로그인 성공!";//+ rs.getString(1)+"님 환영합니다";
					break;
				}else {
					ment = "로그인 실패! ID와 PW를 확인해 주세요.";
				}	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(conn!=null) {
				conn.close();
			}
			if(psmt!=null) {
				psmt.close();
			}
			if(rs!=null) {
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ment;
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
