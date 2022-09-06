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
			
			System.out.println("[1]ȸ������ [2]�α���");
			int sel = sc.nextInt();
			switch (sel) {
			
				case 1:
					System.out.println("ID�� �Է��ϼ��� <�ڷΰ����Է½� �ʱ�ȭ������ ���ư��ϴ�>");
					String user_id = sc.next();
					if(user_id.equals("�ڷΰ���")) {
						break;
					}
					DAO dao = new DAO();
					DTO dto_overlap = new DTO(user_id);
					System.out.println(dao.selectCreateUser(dto_overlap));
					if(dao.selectCreateUser(dto_overlap).equals("�̹� �����ϴ� ID �Դϴ�.")) {
						break;
					}
					
					
					boolean isRun_pw = true;
					while(isRun_pw) {
						System.out.println("PASSWORD�� �Է��ϼ���");
						user_pw = sc.next();

						System.out.println("PASSWORD�� �ѹ� �� �Է��ϼ���");
						user_pw2 =sc.next();

						if(user_pw.equals(user_pw2)) {		//PASSWORD ��Ż�� ���� 
							System.out.println("PASSWORD�� ��ġ�մϴ�.");
							isRun_pw = false;
						}
						else {
							System.out.println("ȸ������ ����! PASSWORD�� ��ġ���� �ʽ��ϴ�.");
							isRun_pw = true;
						}
					}
					
					System.out.println("�̸��� �Է��ϼ���.<�ڷΰ����Է½� �ʱ�ȭ������ ���ư��ϴ�>");
					String user_name =sc.next();
					if(user_name.equals("�ڷΰ���")) {
						break;
					}
					System.out.println("���̸� �Է��ϼ���.");
					int user_age = sc.nextInt();
					if(user_age<20) {
						System.out.println("�̼����ڴ� �̿��� �� �����ϴ�.");
						break;
					}else {
						System.out.println("ȸ������ ����!");
					}
					start_day = formatedNow;
					last_day ="1994/02/23";
					
					
					DTO dto = new DTO(user_id, user_pw, user_name, user_age,start_day,last_day);
					
//					int cnt=0;
//					cnt = dao.insertCreateUser(dto);
//					if(cnt>0) {
//						System.out.println("����");
//					}else {
//						System.out.println("����");
//					}
					
					break;

				case 2://�α���
					System.out.println("ID�� �Է��ϼ��� ");
					user_id = sc.next();
					System.out.println("PW�� �Է��ϼ��� ");
					user_pw = sc.next();
					
					dao = new DAO();
					dto = new DTO(user_id,user_pw);
					System.out.println(dao.login(dto));
					if(dao.login(dto).equals("�α��� ����!")) {
						isRun =  false;
						break;
					}else {
						break;
					}
			}
		}
		
		boolean isRun_main=true;
		while(isRun_main) {
			System.out.println("�����̴�");
			int sel=0;
			switch (sel) {
			case 1 ://���Ӽ���
					
				break;
			case 2 : //��������ȸ
				
				break;
			case 3 ://��ŷ��ȸ
				
				break;
			case 4 ://����
				
				break;
			case 5 : //����
				
				break;
			default:
				break;
			}
			break;
		}
	}


}
