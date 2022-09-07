package game;

import java.util.Random;
import java.util.Scanner;

public class slotmachine {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random rd = new Random();

		// 변수 선언!
		int coin = 10; // 코인 
		int score = 0; // 총 스코어  
		int bonus = 20; // easy 보너스 점수
		int bonus1 = 30; // normal 보너스 점수 
		int bonus2 = 50; // hard 보너스 점수 
		

		while (coin != 0) {

			int[] slotmc = new int[5];
			// 각 배열에 랜덤함수 적용
			slotmc[0] = rd.nextInt(9) + 1;
			slotmc[1] = rd.nextInt(9) + 1;
			slotmc[2] = rd.nextInt(9) + 1;
			slotmc[3] = rd.nextInt(9) + 1;
			slotmc[4] = rd.nextInt(9) + 1;

			System.out.println("=============슬롯머신============");
			System.out.println("[1]easy [2] normal [3]hard [4]종료");
			System.out.println();
			System.out.print("숫자입력 :");

			int select = sc.nextInt();

			// 게임시작
			if (select == 1) { //easy
				System.out.println(slotmc[0] + " " + slotmc[1] + " " + slotmc[2]);
				if (slotmc[0] == slotmc[1] && slotmc[0] == slotmc[2]) {
					System.out.println("100 점 획득 / 코인2개 획득!! ");
					coin = coin + 2;
					score = score + 100;
					System.out.println("현재 점수 :" + score);
				} 
				// 랜덤 숫자 3개중 2개 맞추면 20점 획득!
				else if (slotmc[0] == slotmc[1]) {
					System.out.println("20점 획득");
					score = score + bonus;
					System.out.println("현재 점수 :" + score);
				} else if (slotmc[0] == slotmc[2]) {
					System.out.println("20점 획득");
					score = score + bonus;
					System.out.println("현재 점수 :" + score);
				} else if (slotmc[1] == slotmc[2]) {
					System.out.println("20점 획득");
					score = score + bonus;
					System.out.println("현재 점수 :" + score);
				} else {
					System.out.println("코인 차감 ㅠㅠ ");
					coin--;
					System.out.println("남은코인수 :" + coin);
					System.out.println("현재 점수 :" + score);
				}

			}
			if (select == 2) { //normal
				System.out.println(slotmc[0] + " " + slotmc[1] + " " + slotmc[2] + " " + slotmc[3]);
				if (slotmc[0] == slotmc[1] && slotmc[0] == slotmc[2] && slotmc[0] == slotmc[3]) {
					System.out.println("200 점 획득 / 코인3개 획득 !! ");
					coin = coin + 3;
					score = score + 200;
					System.out.println("현재 점수 :" + score);
				} 
				
				// 랜덤 숫자 4개 중 2개 맞출시 점수 20점 획득 
				else if(slotmc[0] == slotmc[1]) {
					System.out.println("20점 획득");
					score = score + bonus;
					System.out.println("현재 점수 :" + score);
				} else if(slotmc[0] == slotmc[2]) {
					System.out.println("20점 획득");
					score = score + bonus;
					System.out.println("현재 점수 :" + score);
				} else if(slotmc[0] == slotmc[3]) {
					System.out.println("20점 획득");
					score = score + bonus;
					System.out.println("현재 점수 :" + score);
				}				 
				 else if(slotmc[1] == slotmc[2]) {
					System.out.println("20점 획득");
					score = score + bonus;
					System.out.println("현재 점수 :" + score);
				
				} else if(slotmc[1] == slotmc[3]) {
					System.out.println("20점 획득");
					score = score + bonus;
					System.out.println("현재 점수 :" + score);
				
				}else if(slotmc[2] == slotmc[3]) {
					System.out.println("20점 획득");
					score = score + bonus;
					System.out.println("현재 점수 :" + score);		
				}				 	 	 	 	 
				
				// 랜덤 숫자 4개중 3개 맞췄을때 30점 획득 .. 
				else if (slotmc[0] == slotmc[1] && slotmc[0] == slotmc[2]) {
					System.out.println("30점 획득");
					score = score + bonus1;
					System.out.println("현재 점수 :" + score);
				} else if (slotmc[0] == slotmc[1] && slotmc[0] == slotmc[3]) {
					System.out.println("30점 획득");
					score = score + bonus1;
					System.out.println("현재 점수 :" + score);
				} else if (slotmc[1] == slotmc[2] && slotmc[0] == slotmc[3]) {
					System.out.println("30점 획득");
					score = score + bonus1;
					System.out.println("현재 점수 :" + score);
				} else if (slotmc[1] == slotmc[2] && slotmc[3] == slotmc[0]) {
					System.out.println("30점 획득");
					score = score + bonus1;
					System.out.println("현재 점수 :" + score);
				} else {
					System.out.println("코인 차감 ㅠㅠ ");
					coin--;
					System.out.println("남은코인수 :" + coin);
					System.out.println("현재 점수 :" + score);
				}
			}
				if (select == 3) { //hard 
					System.out.println(slotmc[0] + " " + slotmc[1] + " " + slotmc[2] + " " + slotmc[3] + " " + slotmc[4]);
					if (slotmc[0] == slotmc[1] && slotmc[0] == slotmc[2] && slotmc[0] == slotmc[3]&& slotmc[0] == slotmc[4]) {
						System.out.println("300 점 획득 / 코인5개 획득!! ");
						coin = coin + 5;
						score = score + 300;
						System.out.println("현재 점수 :" + score);
					} 
					
					// 랜덤 숫자 5개중 4개 맞출시 40점 획득  
					else if (slotmc[1] == slotmc[2] && slotmc[1] == slotmc[3] && slotmc[1] == slotmc[4]) {
						System.out.println("50점 획득");
						score = score + bonus2;
						System.out.println("현재 점수 :" + score);
					} else if (slotmc[2] == slotmc[1] && slotmc[2] == slotmc[3] && slotmc[2] == slotmc[0]) {
						System.out.println("50점 획득");
						score = score + bonus2;
						System.out.println("현재 점수 :" + score);
					} else if (slotmc[3] == slotmc[4] && slotmc[3] == slotmc[1] && slotmc[3] == slotmc[0]) {
						System.out.println("50점 획득");
						score = score + bonus2;
						System.out.println("현재 점수 :" + score);
					}else if (slotmc[4] == slotmc[0] && slotmc[4] == slotmc[1] && slotmc[4] == slotmc[2]) {
						System.out.println("50점 획득");
						score = score + bonus2;
						System.out.println("현재 점수 :" + score);
					}
					
					// 랜덤 숫자 5개 중 3개 맞추면 30점 획득 ! 
					else if(slotmc[0] == slotmc[1] && slotmc[0] == slotmc[2]) {
						System.out.println("30점 획득");
						score = score + bonus1;
						System.out.println("현재 점수 :" + score);
					}else if(slotmc[0] == slotmc[1] && slotmc[0] == slotmc[3]) {
						System.out.println("30점 획득");
						score = score + bonus1;
						System.out.println("현재 점수 :" + score);
					}else if(slotmc[0] == slotmc[2] && slotmc[2] == slotmc[3]) {
						System.out.println("30점 획득");
						score = score + bonus1;
						System.out.println("현재 점수 :" + score);
					}else if(slotmc[0] == slotmc[2] && slotmc[2] == slotmc[4]) {
						System.out.println("30점 획득");
						score = score + bonus1;
						System.out.println("현재 점수 :" + score);
					}else if(slotmc[0] == slotmc[1] && slotmc[0] == slotmc[4]) {
						System.out.println("30점 획득");
						score = score + bonus1;
						System.out.println("현재 점수 :" + score);
					}else if(slotmc[1] == slotmc[2] && slotmc[2] == slotmc[3]) {
						System.out.println("30점 획득");
						score = score + bonus1;
						System.out.println("현재 점수 :" + score);
					}else if(slotmc[1] == slotmc[2] && slotmc[2] == slotmc[4]) {
						System.out.println("30점 획득");
						score = score + bonus1;
						System.out.println("현재 점수 :" + score);
					}else if(slotmc[2] == slotmc[3] && slotmc[3] == slotmc[4]) {
						System.out.println("30점 획득");
						score = score + bonus1;
						System.out.println("현재 점수 :" + score);
					}
					else {
						System.out.println("코인 차감 ㅠㅠ ");
						coin--;
						System.out.println("남은코인수 :" + coin);
						System.out.println("현재 점수 :" + score);
					}
				}if(select == 4) {
					System.out.println("종료");
					
					break;

			}

		}
	}
}