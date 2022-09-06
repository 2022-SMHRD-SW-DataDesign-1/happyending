package Casino;


import java.util.Random;
import java.util.Scanner;

public class ?��바위_최종 {

	public static void main(String[] args) {
		// ?��?��?��?�� 코인 10개�?? �?�?�? ?��?��.
		// 코인 10개�?? �?�?�? 게임?�� ?��?��?��?��.
		// ?��바위 게임?? 초급 중급 고급 ?��?���? ?��개된?��.
		
		// 코인?�� 0개�? ?���? 죽는?��.
		// 코인?�� 0개�? ?���? ?��까�??�� 계속 게임?? ?��?��?��.- while문�? ?��?���? 모�?? ?��.
		Random rd = new Random();

		Scanner sc = new Scanner(System.in);
		// 코인 ?��?��
		int coin = 10;
		int score = 0;

		int mbonus = 200;
		int hbonus = 300;

		System.out.println("?��?��?��?��?��?��?�� ?��바위 ??~?�� ?��?��?��?��?��?��?��?��");
		System.out.println("------------------------------");
//		System.out.println(
//				
//				 "?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��\r\n"
//				+"?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��\r\n"
//				+"?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��\r\n"
//				+"?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��\r\n"
//				);
		// 종이�? ?��미�?
		System.out.println("------------------------------");
		System.out.print("[1] 초급 [2] 중급 [3] 고급>>"+" " );
		int lv_select = sc.nextInt();
		System.out.println("------------------------------");
		
		
		if(lv_select == 1) {	
		// 초급버전
      		while (true) {

				// ?��?�� ?��?��?���?
				// ?��바위 배열
				int[] ybw = new int[3];

				// 0�? 1 ?�� 배열?�� ?��?��간다. // 중복?��?��
				for (int i = 0; i < ybw.length; i++) {
					ybw[i] = rd.nextInt(2);
					// ybawi 첫번�? 배열?�� 1?�� ?��?��갔을 ?��
					if (ybw[0] == 1) {
						ybw[1] = 0;
						ybw[2] = 0;
						// ybawi ?��번�?? 배열?�� 1?�� ?��?��갔을 ?��
					} else if (ybw[1] == 1) {
						ybw[0] = 0;
						ybw[2] = 0;
						// ybawi ?��번�?? 배열?�� 1?�� ?��?��갔을 ?��
					} else if (ybw[2] == 1) {
						ybw[0] = 0;
						ybw[1] = 0;
						// ybw 모든 배열?�� 0?�� ?��?��갔을 ?��
					} else if (ybw[0] == 0 && ybw[1] == 0 && ybw[2] == 0) {
						ybw[0] = 0;
						ybw[1] = 0;
						ybw[2] = 1;
					}

				}

//				// 배열?�� ?�� ?��?��갔는�? ?��?��
//				for (int k = 0; k < 3; k++) {
//					System.out.println("?��바위 : " + ybw[k] + " ");
//				}
				
		
				// ?��?��?���? 번호�? 고른?��
				
				System.out.print("?��?��?�� ?��?��까요? >>");
				int usr_slct = sc.nextInt();
				
				

				// ?��바위 ?��?��?�� ?�� 
				int usr_answer = usr_slct - 1;
				
				
					if (usr_slct == 1) {

						// ?��?��?�� ybw[0]?�� ?��

						if (ybw[usr_answer] == 1) {
							System.out.println("------------------------------");
							System.out.println("?��?��?�� ?��겼습?��?��.");
							score = score + 100;
							System.out.println("?��?��?�� " + score + "?��?��?��.");
							System.out.println("------------------------------");

						}
						// ?��?��?�� ?��?�� ?��
						else {
							System.out.println("------------------------------");
							System.out.println("?��?��?�� 졌습?��?��.");
							System.out.println("?��?��?�� " + score + "?��?��?��.");
							coin--;
							System.out.println("?��?? 코인 : " + coin);
							System.out.println("------------------------------");
						}

						// ?��?��?��?�� ?��?��?�� 2?�� ?��
					}

					else if (usr_slct == 2) {

						// ?��?��?�� ybw[1]?�� ?��

						if (ybw[usr_answer] == 1) {
							System.out.println("------------------------------");
							System.out.println("?��?��?�� ?��겼습?��?��.");
							score = score + 100;
							System.out.println("?��?��?�� " + score + "?��?��?��.");
							System.out.println("------------------------------");

						} else {
							System.out.println("------------------------------");
							System.out.println("?��?��?�� 졌습?��?��.");
							coin--;
							System.out.println("?��?? 코인 : " + coin);
							System.out.println("------------------------------");
						}

					} else if (usr_slct == 3) {

						// ?��?��?�� ybw[2]?�� ?��

						if (ybw[usr_answer] == 1) {
							System.out.println("------------------------------");
							System.out.println("?��?��?�� ?��겼습?��?��.");
							score = score + 100;
							System.out.println("?��?��?�� " + score + "?��?��?��.");
							System.out.println("------------------------------");

						} else {
							System.out.println("------------------------------");
							System.out.println("?��?��?�� 졌습?��?��.");
							coin--;
							System.out.println("?��?? 코인 : " + coin);
							System.out.println("------------------------------");
						}
					} else if (usr_slct > 3 || usr_slct == 0) {
						System.out.println("1,2,3 중에?�� ?��?��?��?��?��!");
					}
			
      		
      		}
		}
		
			

// ?��?���? 1000?�� ?��?��?�� ?�� => 중급
// 중급버전
//			
		else if(lv_select == 2) {
			while (true ) {

				// ?��?�� ?��?��?���?
				// ?��바위 배열
				int[] ybw = new int[4];

				// 0�? 1 ?�� 배열?�� ?��?��간다. // 중복?��?��
				for (int i = 0; i < ybw.length; i++) {
					ybw[i] = rd.nextInt(2);
					// ybawi 첫번�? 배열?�� 1?�� ?��?��갔을 ?��
					if (ybw[0] == 1) {
						ybw[1] = 0;
						ybw[2] = 0;
						ybw[3] = 0;
						// ybawi ?��번�?? 배열?�� 1?�� ?��?��갔을 ?��
					} else if (ybw[1] == 1) {
						ybw[0] = 0;
						ybw[2] = 0;
						ybw[3] = 0;
						// ybawi ?��번�?? 배열?�� 1?�� ?��?��갔을 ?��
					} else if (ybw[2] == 1) {
						ybw[0] = 0;
						ybw[1] = 0;
						ybw[3] = 0;
						// ybw 모든 배열?�� 0?�� ?��?��갔을 ?��
					} else if (ybw[0] == 0 && ybw[1] == 0 && ybw[2] == 0) {
						ybw[0] = 0;
						ybw[1] = 0;
						ybw[2] = 0;
						ybw[3] = 1;
					}

				}
//
//				// 배열?�� ?�� ?��?��갔는�? ?��?��
//				for (int k = 0; k < ybw.length; k++) {
//					System.out.println("?��바위 : " + ybw[k] + " ");
//				}
				System.out.println(
						
						 "?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��\r\n"
						+"?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��\r\n"
						+"?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��\r\n"
						+"?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��\r\n"
						);
				
				// ?��?��?���? 번호�? 고른?��
				System.out.print("?��?��?�� ?��?��까요?>>");
				
				int usr_slct = sc.nextInt();

				// ?��바위 배열 ?��?��?��
				int usr_answer = usr_slct - 1;

					if (usr_slct == 1) {

						// ?��?��?�� ybw[0]?�� ?��

						if (ybw[usr_answer] == 1) {
							System.out.println("------------------------------");
							System.out.println("?��?��?�� ?��겼습?��?��.");
							score = score + 100 + mbonus;
							System.out.println("?��?��?�� " + score + "?��?��?��.");
							System.out.println("------------------------------");
						}
						// ?��?��?�� ?��?�� ?��
						else {
							System.out.println("------------------------------");
							System.out.println("?��?��?�� 졌습?��?��.");
							System.out.println("?��?��?�� " + score + "?��?��?��.");
							coin--;
							System.out.println("?��?? 코인 : " + coin);
							System.out.println("------------------------------");
						}

						// ?��?��?��?�� ?��?��?�� 2?�� ?��
					}

					else if (usr_slct == 2) {

						// ?��?��?�� ybw[1]?�� ?��

						if (ybw[usr_answer] == 1) {
							System.out.println("------------------------------");
							System.out.println("?��?��?�� ?��겼습?��?��.");
							score = score + 100 + mbonus;
							System.out.println("?��?��?�� " + score + "?��?��?��.");
							System.out.println("------------------------------");
						} else {
							System.out.println("?��?��?�� 졌습?��?��.");
							coin--;
							System.out.println("?��?? 코인 : " + coin);
							System.out.println("------------------------------");
						}

					} else if (usr_slct == 3) {

						// ?��?��?�� ybw[2]?�� ?��

						if (ybw[usr_answer] == 1) {
							System.out.println("------------------------------");
							System.out.println("?��?��?�� ?��겼습?��?��.");
							score = score + 100 + mbonus;
							System.out.println("?��?��?�� " + score + "?��?��?��.");
							System.out.println("------------------------------");
						} else {
							System.out.println("------------------------------");
							System.out.println("?��?��?�� 졌습?��?��.");
							coin--;
							System.out.println("?��?? 코인 : " + coin);
							System.out.println("------------------------------");
						}
					} else if (usr_slct == 4) {

						// ?��?��?�� ybw[3]?�� ?��

						if (ybw[usr_answer] == 1) {
							System.out.println("------------------------------");
							System.out.println("?��?��?�� ?��겼습?��?��.");
							score = score + 100 + mbonus;
							System.out.println("?��?��?�� " + score + "?��?��?��.");
							System.out.println("------------------------------");
						} else {
							System.out.println("------------------------------");
							System.out.println("?��?��?�� 졌습?��?��.");
							coin--;
							System.out.println("?��?? 코인 : " + coin);
							System.out.println("------------------------------");
						}
					} else if (usr_slct > 4 || usr_slct == 0) {
						
						System.out.println("1,2,3,4 중에?�� ?��?��?��?��?��!");
						System.out.println("------------------------------");
					}
				}

			}
		
			
// 고급

// ?��?���? 3000?�� ?��?��?�� ?�� 3000?�� 까�?
//System.out.println("???��?��?��?��?��! ?���? ?�� ?��!?�� ?�� ?��?��");
		else if(lv_select == 3) {
			while (true) {

				// ?��?�� ?��?��?���?
				// ?��바위 배열
				int[] ybw = new int[5];

				// 0�? 1 ?�� 배열?�� ?��?��간다. // 중복?��?��
				for (int i = 0; i < ybw.length; i++) {
					ybw[i] = rd.nextInt(2);
					// ybawi 첫번�? 배열?�� 1?�� ?��?��갔을 ?��
					if (ybw[0] == 1) {
						ybw[1] = 0;
						ybw[2] = 0;
						ybw[3] = 0;
						ybw[4] = 0;
						// ybawi ?��번�?? 배열?�� 1?�� ?��?��갔을 ?��
					} else if (ybw[1] == 1) {
						ybw[0] = 0;
						ybw[2] = 0;
						ybw[3] = 0;
						ybw[4] = 0;
						// ybawi ?��번�?? 배열?�� 1?�� ?��?��갔을 ?��
					} else if (ybw[2] == 1) {
						ybw[0] = 0;
						ybw[1] = 0;
						ybw[3] = 0;
						ybw[4] = 0;
						// ybw 모든 배열?�� 0?�� ?��?��갔을 ?��
					} else if (ybw[3] == 1) {
						ybw[0] = 0;
						ybw[1] = 0;
						ybw[2] = 0;
						ybw[4] = 0;
						// ybw 모든 배열?�� 0?�� ?��?��갔을 ?��
					}else if (ybw[4] == 1) {
						ybw[0] = 0;
						ybw[1] = 0;
						ybw[3] = 0;
						ybw[2] = 0;
						// ybw 모든 배열?�� 0?�� ?��?��갔을 ?��
					}  
					else if (ybw[0] == 0 && ybw[1] == 0 && ybw[2] == 0 && ybw[3] == 0 && ybw[4] == 0) {
						ybw[0] = 0;
						ybw[1] = 0;
						ybw[2] = 0;
						ybw[3] = 1;
						ybw[4] = 0;
					}

				}

				// 배열?�� ?�� ?��?��갔는�? ?��?��
				for (int k = 0; k < ybw.length; k++) {
					System.out.println("?��바위 : " + ybw[k] + " ");
				}
				System.out.println(
						
						 "?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��\r\n"
						+"?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��\r\n"
						+"?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��\r\n"
						+"?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��?��\r\n"
						);
				// ?��?��?���? 번호�? 고른?��
				System.out.print("?��?��?�� ?��?��까요?>>");
				int usr_slct = sc.nextInt();

				// ?��바위 배열 ?��?��?��
				int usr_answer = usr_slct - 1;

				
				
					if (usr_slct == 1) {

						// ?��?��?�� ybw[0]?�� ?��

						if (ybw[usr_answer] == 1) {
							System.out.println("------------------------------");
							System.out.println("?��?��?�� ?��겼습?��?��.");
							score = score + 100 + hbonus;
							System.out.println("?��?��?�� " + score + "?��?��?��.");
							System.out.println("------------------------------");
						}
						// ?��?��?�� ?��?�� ?��
						else {
							System.out.println("------------------------------");
							System.out.println("?��?��?�� 졌습?��?��.");
							System.out.println("?��?��?�� " + score + "?��?��?��.");
							coin--;
							System.out.println("?��?? 코인 : " + coin);
							System.out.println("------------------------------");

						}

						// ?��?��?��?�� ?��?��?�� 2?�� ?��
					}

					else if (usr_slct == 2) {

						// ?��?��?�� ybw[1]?�� ?��

						if (ybw[usr_answer] == 1) {
							System.out.println("------------------------------");
							System.out.println("?��?��?�� ?��겼습?��?��.");
							score = score + 100 + hbonus;
							System.out.println("?��?��?�� " + score + "?��?��?��.");
							System.out.println("------------------------------");
						} else {
							System.out.println("------------------------------");
							System.out.println("?��?��?�� 졌습?��?��.");
							coin--;
							System.out.println("?��?? 코인 : " + coin);
							System.out.println("------------------------------");
						}

					} else if (usr_slct == 3) {

						// ?��?��?�� ybw[2]?�� ?��

						if (ybw[usr_answer] == 1) {
							System.out.println("------------------------------");
							System.out.println("?��?��?�� ?��겼습?��?��.");
							score = score + 100 + hbonus;
							System.out.println("?��?��?�� " + score + "?��?��?��.");
							System.out.println("------------------------------");
						} else {
							System.out.println("------------------------------");
							System.out.println("?��?��?�� 졌습?��?��.");
							coin--;
							System.out.println("?��?? 코인 : " + coin);
							System.out.println("------------------------------");

						}
					} else if (usr_slct == 4) {

						// ?��?��?�� ybw[3]?�� ?��

						if (ybw[usr_answer] == 1) {
							System.out.println("------------------------------");
							System.out.println("?��?��?�� ?��겼습?��?��.");
							score = score + 100 + hbonus;
							System.out.println("?��?��?�� " + score + "?��?��?��.");
							System.out.println("------------------------------");
						} else {
							System.out.println("------------------------------");
							System.out.println("?��?��?�� 졌습?��?��.");
							coin--;
							System.out.println("?��?? 코인 : " + coin);
							System.out.println("------------------------------");

						}
					}else if (usr_slct == 5) {

						// ?��?��?�� ybw[4]?�� ?��

						if (ybw[usr_answer] == 1) {
							System.out.println("------------------------------");
							System.out.println("?��?��?�� ?��겼습?��?��.");
							score = score + 100 + hbonus;
							System.out.println("?��?��?�� " + score + "?��?��?��.");
							System.out.println("------------------------------");

						} else {
							System.out.println("------------------------------");
							System.out.println("?��?��?�� 졌습?��?��.");
							coin--;
							System.out.println("?��?? 코인 : " + coin);
							System.out.println("------------------------------");
						}
					} else if (usr_slct > 5 || usr_slct == 0) {
						System.out.println("1,2,3,4,5 중에?�� ?��?��?��?��?��!");
					}
				}

			}
		}
	}
