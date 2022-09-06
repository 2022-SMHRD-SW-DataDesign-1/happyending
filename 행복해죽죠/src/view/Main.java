package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.LocalDate;
import model.DAO;
import model.DTO;


public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String user_pw =null;
		String user_pw2=null;
		String start_day =null;
		String last_day=null;
		
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String formatedNow = now.format(formatter);
		boolean isRun =true;
		while(isRun) {
			
			System.out.println("[1]회원가입 [2]로그인");
			int sel = sc.nextInt();
			switch (sel) {
			
				case 1:
					System.out.println("ID를 입력하세요 <뒤로가기입력시 초기화면으로 돌아갑니다>");
					String user_id = sc.next();
					if(user_id.equals("뒤로가기")) {
						break;
					}
					DAO dao = new DAO();
					DTO dto_overlap = new DTO(user_id);
					System.out.println(dao.selectCreateUser(dto_overlap));
					if(dao.selectCreateUser(dto_overlap).equals("이미 존재하는 ID 입니다.")) {
						break;
					}
					
					
					boolean isRun_pw = true;
					while(isRun_pw) {
						System.out.println("PASSWORD를 입력하세요");
						user_pw = sc.next();

						System.out.println("PASSWORD를 한번 더 입력하세요");
						user_pw2 =sc.next();

						if(user_pw.equals(user_pw2)) {		//PASSWORD 오탈자 방지 
							System.out.println("PASSWORD가 일치합니다.");
							isRun_pw = false;
						}
						else {
							System.out.println("회원가입 실패! PASSWORD가 일치하지 않습니다.");
							isRun_pw = true;
						}
					}
					
					System.out.println("이름을 입력하세요.<뒤로가기입력시 초기화면으로 돌아갑니다>");
					String user_name =sc.next();
					if(user_name.equals("뒤로가기")) {
						break;
					}
					System.out.println("나이를 입력하세요.");
					int user_age = sc.nextInt();
					if(user_age<20) {
						System.out.println("미성년자는 이용할 수 없습니다.");
						break;
					}else {
						System.out.println("회원가입 성공!");
					}
					start_day = formatedNow;
					last_day ="1994/02/23";
					
					
					DTO dto = new DTO(user_id, user_pw, user_name, user_age,start_day,last_day);
					
//					int cnt=0;
//					cnt = dao.insertCreateUser(dto);
//					if(cnt>0) {
//						System.out.println("성공");
//					}else {
//						System.out.println("실패");
//					}
					
					break;

				case 2://로그인
					System.out.println("ID를 입력하세요 ");
					user_id = sc.next();
					System.out.println("PW를 입력하세요 ");
					user_pw = sc.next();
					
					dao = new DAO();
					dto = new DTO(user_id,user_pw);
					System.out.println(dao.login(dto));
					if(dao.login(dto).equals("로그인 성공!")) {
						isRun =  false;
						break;
					}else {
						break;
					}
			}
		}
		
		boolean isRun_main=true;
		while(isRun_main) {
			System.out.println("메인이당");
			int sel=0;
			switch (sel) {
			case 1 ://게임선택
					
				break;
			case 2 : //내정보조회
				
				break;
			case 3 ://랭킹조회
				
				break;
			case 4 ://상점
				
				break;
			case 5 : //종료
				
				break;
			default:
				break;
			}
			break;
		}
	}


}
