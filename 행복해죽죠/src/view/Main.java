package view;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.lang.reflect.Field;
import java.nio.charset.Charset;

import game.RaceHorse;
import game.slotmachine;
import game.trickery;
import game.Store;
import model.DAO;
import model.DTO;
public class Main {
	public static void main(String[] args) {
		System.setProperty("file.encoding","UTF-8");
		  try{
		  Field charset = Charset.class.getDeclaredField("defaultCharset");
		  charset.setAccessible(true);
		  charset.set(null,null);
		  }
		  catch(Exception e){
		   
		  }
		
		
		
		
		
		Scanner sc = new Scanner(System.in);
		
		String user_pw =null;
		String user_pw2=null;
		String start_day =null;
		String last_day=null;
		String user_id =null;
		ui.main();
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String formatedNow = now.format(formatter);
		boolean isRun =true;
		while(isRun) {
			ui.main2();
			music.mainms();
			System.out.println("[1]회원가입 [2]로그인");
			int sel = sc.nextInt();
			switch (sel) {
			
				case 1:
					System.out.println("ID를 입력하세요 <뒤로가기입력시 초기화면으로 돌아갑니다>");
					user_id = sc.next();
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
					int cnt=0;
					cnt = dao.insertCreateUser(dto);
					if(cnt>0) {
						System.out.println("성공");
					}else {
						System.out.println("실패");
					}

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
		
		DAO dao= new DAO();
		DTO user_inf= new DTO(user_id,user_pw);
		dao.login(user_inf);

//		int coin = user_inf.getCoin();
//		int score = user_inf.getScore();

//		System.out.println(coin);
//		System.out.println(score);



		
		

		boolean isRun_main=true;
		while(isRun_main) {
			int coin = user_inf.getCoin();
			int score = user_inf.getScore();
			int ex = user_inf.getEx();
			int lv = user_inf.getLevel();
			System.out.println("[1]게임선택 [2]내정보 [3]랭킹 [4]상점 [5]종료");
			int sel=sc.nextInt();

			switch (sel) {
			case 1 ://게임선택
				System.out.println("[1]슬롯머신 [2]야바위 [3]경마");
				int sel_game = sc.nextInt();
				
				if(sel_game ==1) {
					slotmachine game = new slotmachine(coin, score);
					game.play();
					user_inf.setCoin(game.getcoin());
					user_inf.setScore(game.getScore());
					dao.update(user_inf);
				}else if(sel_game ==2) {
					trickery tr_game= new trickery(coin, score);
					tr_game.trickery_game();
					user_inf.setCoin(tr_game.getcoin());
					user_inf.setScore(tr_game.getScore());
					dao.update(user_inf);

				}else if(sel_game ==3) {
					ui.racehorse();
					RaceHorse horse_game =new RaceHorse(coin,score);
					horse_game.Horse();
					user_inf.setCoin(horse_game.getcoin());
					user_inf.setScore(horse_game.getScore());
					dao.update(user_inf);
				}else {
					
				}
				
				
				break;
			case 2 : //내정보조회
				System.out.println("ID"+"\t"+"이름"+"\t"+"나이"+"\t"+"score"+"\t"+"레벨"+"\t"+"경험치"+"\t"+"코인수"+"\t"+"내등급");
				System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\n",user_inf.getUser_id(),user_inf.getUser_name(),+user_inf.getAge(),+user_inf.getScore(),user_inf.getLevel(),user_inf.getEx(),user_inf.getCoin(),user_inf.getGrade());
				System.out.println("=========================================================");
//				System.out.println("[0]뒤로가기"+"\t"+"[1]회원탈퇴");
//				int infsel = sc.nextInt();
//				if(infsel==1) {
//					System.out.println("탈퇴하시겠습니까?(y/n)");
//					if(sc.next().equals("y")) {
//						
//					}else {
//						
//					}.
//				}
				
				break;
			case 3 ://랭킹조회
				dao.ranksel();

				break;
			case 4 ://상점
				//score를 경험치로 교환.
				//경험치는 최대 10
				//경험치가 10이되면 lv+1
				//lv1은 score 100당 경험치1
				//lv2는 score 200당 경험치1
				Store shop = new Store(score, coin, ex, lv);
				shop.trade();
				user_inf.setScore(shop.getScore());
				user_inf.setCoin(shop.getCoin());
				user_inf.setEx(shop.getEx());
				user_inf.setLevel(shop.getLv());
				dao.update(user_inf);
				break;
			case 5 : //종료
				isRun_main =false;
				break;
			}
		}
	}
}