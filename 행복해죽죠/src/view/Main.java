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
					
					//if qury���� ��� name���� �����;���. �����ͼ� id�� ��. �ߺ��� ������ �ٽ�.�ڷΰ��� �Է½� ����ȭ�� 
					//else
					
					
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
					
					int cnt=0;
					cnt = dao.insert(dto);
					if(cnt>0) {
						System.out.println("����");
					}else {
						System.out.println("����");
					}
					
					break;

				case 2:
					
				
					break;
					
				default :
					
					break;
			}
		
		
		
		
		
		
		
		}
	}


}
