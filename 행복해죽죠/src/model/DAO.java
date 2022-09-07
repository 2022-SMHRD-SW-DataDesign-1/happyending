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
			 psmt.setInt(8, 30);
			 
			 
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
		String sql ="select * from users u,grade g where g.gd_lv = u.lv";
		
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				if((dto.getUser_id()).equals(rs.getString(1)) && (dto.getUser_pw()).equals(rs.getString(2))) {
					ment = "로그인 성공!";//+ rs.getString(1)+"님 환영합니다";
					
					dto.setUser_name(rs.getString(3));
					dto.setAge(rs.getInt(4));
					dto.setLevel(rs.getInt(5));
					dto.setCoin(rs.getInt(6));
					dto.setEx(rs.getInt(7));
					dto.setScore(rs.getInt(8));
					dto.setGrade(rs.getString(10));
		
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
	//game종료후 update

	public int update(DTO dto) {
		connect();
		int cnt =0;
		try {
			String sql = "update users set coin=?,score=?,ex=?,lv=? where user_id=? ";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, dto.getCoin());
			psmt.setInt(2, dto.getScore());
			psmt.setInt(3, dto.getEx());
			psmt.setInt(4, dto.getLevel());
			psmt.setString(5, dto.getUser_id());
			
			cnt = psmt.executeUpdate();
			
//			sql = "commit";
//			psmt = conn.prepareStatement(sql);
//			cnt = psmt.executeUpdate();
			
			sql = "select coin,score from users where user_id=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getUser_id());
			rs = psmt.executeQuery();
			rs.next();
			dto.setCoin(rs.getInt(1)); 
			dto.setScore(rs.getInt(2)); 
			
			
			
			
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
		
		
		return cnt;
	}
	
	public String ranksel() {
		connect();
		String user_id = null;
		int user_lv = 0;				
		String user_grade = null;
		int user_ex = 0;
		
		try {
			String sql ="select * from(select u.user_id,u.lv,g.grade_g,u.ex from users u,grade g where g.gd_lv = u.lv order by u.lv desc) where rownum<10";
			psmt = conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			System.out.println("ID"+"\t\t"+"LV"+"\t"+"등급"+"\t"+"경험치");
			int cnt =1;
			while(rs.next()) {
			user_id = rs.getString(1);
			user_lv = rs.getInt(2);				
			user_grade = rs.getString(3);
			user_ex = rs.getInt(4);
			System.out.printf(cnt++ + "위 "+"%s\n\t\t%s\t%s\t%s\n",user_id,user_lv,user_grade,user_ex);
			
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
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
	