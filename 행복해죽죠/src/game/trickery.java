package game;

import java.util.Random;
import java.util.Scanner;

public class trickery{

	public static void main(String[] args) {
		// 사용자는 코인 10개를 가지고 있다.
		// 코인 10개를 가지고 게임을 시작한다.
		// 야바위 게임은 초급 중급 고급 순으로 전개된다.

		// 코인이 0개가 되면 죽는다.
		// 코인이 0개가 되기 전까지는 계속 게임은 나온다.- while문은 횟수를 모를 때.
		Random rd = new Random();

		Scanner sc = new Scanner(System.in);
		// 코인 설정
		int coin = 10;
		int score = 0;

		int mbonus = 200;
		int hbonus = 300;

		System.out.println("♩♪♬♩♪♬♩ 야바위 타~임 ♩♪♬♬♩♪♬♩");
		System.out.println("------------------------------");

		// 종이컵 이미지
		System.out.println("------------------------------");
		System.out.print("[1] 초급 [2] 중급 [3] 고급>>"+" " );
		int lv_select = sc.nextInt();
		System.out.println("------------------------------");


		if(lv_select == 1) {	
		// 초급버전
      		while (coin != 0) {

				// 다시 시작하기
				// 야바위 배열
				int[] ybw = new int[3];

				// 0과 1 이 배열에 들어간다. // 중복없이
				for (int i = 0; i < ybw.length; i++) {
					ybw[i] = rd.nextInt(2);
					// ybawi 첫번쨰 배열에 1이 들어갔을 떄
					if (ybw[0] == 1) {
						ybw[1] = 0;
						ybw[2] = 0;
						// ybawi 두번쨰 배열에 1이 들어갔을 떄
					} else if (ybw[1] == 1) {
						ybw[0] = 0;
						ybw[2] = 0;
						// ybawi 세번쨰 배열에 1이 들어갔을 떄
					} else if (ybw[2] == 1) {
						ybw[0] = 0;
						ybw[1] = 0;
						// ybw 모든 배열에 0이 들어갔을 때
					} else if (ybw[0] == 0 && ybw[1] == 0 && ybw[2] == 0) {
						ybw[0] = 0;
						ybw[1] = 0;
						ybw[2] = 1;
					}

				}

//				// 배열에 잘 들어갔는지 확인
//				for (int k = 0; k < 3; k++) {
//					System.out.println("야바위 : " + ybw[k] + " ");
//				}


				// 사용자가 번호를 고른다

				System.out.print("어디에 있을까요? >>");
				int usr_slct = sc.nextInt();



				// 야바위 사용자 답 
				int usr_answer = usr_slct - 1;


					if (usr_slct == 1) {

						// 정답이 ybw[0]일 때

						if (ybw[usr_answer] == 1) {
							System.out.println("------------------------------");
							System.out.println("당신이 이겼습니다.");
							score = score + 100;
							System.out.println("점수는 " + score + "입니다.");
							System.out.println("------------------------------");

						}
						// 정답이 아닐 때
						else {
							System.out.println("------------------------------");
							System.out.println("당신이 졌습니다.");
							System.out.println("점수는 " + score + "입니다.");
							coin--;
							System.out.println("남은 코인 : " + coin);
							System.out.println("------------------------------");
						}

						// 사용자의 선택이 2일 때
					}

					else if (usr_slct == 2) {

						// 정답이 ybw[1]일 때

						if (ybw[usr_answer] == 1) {
							System.out.println("------------------------------");
							System.out.println("당신이 이겼습니다.");
							score = score + 100;
							System.out.println("점수는 " + score + "입니다.");
							System.out.println("------------------------------");

						} else {
							System.out.println("------------------------------");
							System.out.println("당신이 졌습니다.");
							coin--;
							System.out.println("남은 코인 : " + coin);
							System.out.println("------------------------------");
						}

					} else if (usr_slct == 3) {

						// 정답이 ybw[2]일 때

						if (ybw[usr_answer] == 1) {
							System.out.println("------------------------------");
							System.out.println("당신이 이겼습니다.");
							score = score + 100;
							System.out.println("점수는 " + score + "입니다.");
							System.out.println("------------------------------");

						} else {
							System.out.println("------------------------------");
							System.out.println("당신이 졌습니다.");
							coin--;
							System.out.println("남은 코인 : " + coin);
							System.out.println("------------------------------");
						}
					} else if (usr_slct > 3 || usr_slct == 0) {
						System.out.println("1,2,3 중에서 입력하세요!");
					}
							
      		
      		}
		}



// 점수가 1000점 이상일 때 => 중급
// 중급버전
//			
		else if(lv_select == 2) {
			while (coin != 0 ) {

				// 다시 시작하기
				// 야바위 배열
				int[] ybw = new int[4];

				// 0과 1 이 배열에 들어간다. // 중복없이
				for (int i = 0; i < ybw.length; i++) {
					ybw[i] = rd.nextInt(2);
					// ybawi 첫번쨰 배열에 1이 들어갔을 떄
					if (ybw[0] == 1) {
						ybw[1] = 0;
						ybw[2] = 0;
						ybw[3] = 0;
						// ybawi 두번쨰 배열에 1이 들어갔을 떄
					} else if (ybw[1] == 1) {
						ybw[0] = 0;
						ybw[2] = 0;
						ybw[3] = 0;
						// ybawi 세번쨰 배열에 1이 들어갔을 떄
					} else if (ybw[2] == 1) {
						ybw[0] = 0;
						ybw[1] = 0;
						ybw[3] = 0;
						// ybw 모든 배열에 0이 들어갔을 때
					} else if (ybw[0] == 0 && ybw[1] == 0 && ybw[2] == 0) {
						ybw[0] = 0;
						ybw[1] = 0;
						ybw[2] = 0;
						ybw[3] = 1;
					}

				}
//
//				// 배열에 잘 들어갔는지 확인
//				for (int k = 0; k < ybw.length; k++) {
//					System.out.println("야바위 : " + ybw[k] + " ");
//				}
//				System.out.println(
//
//						 "░░░░███████░░░░░░███████░░░░░░███████░░░░░░███████░░░\r\n"
//						+"░░░░███████░░░░░░███████░░░░░░███████░░░░░░███████░░░\r\n"
//						+"░░░░███❶███░░░░░░███❷███░░░░░░███❸███░░░░░░███❹███░░\r\n"
//						+"░░███████████░░███████████░░███████████░░███████████░\r\n"
//						);

				// 사용자가 번호를 고른다
				System.out.print("어디에 있을까요?>>");

				int usr_slct = sc.nextInt();

				// 야바위 배열 인덱스
				int usr_answer = usr_slct - 1;

					if (usr_slct == 1) {

						// 정답이 ybw[0]일 때

						if (ybw[usr_answer] == 1) {
							System.out.println("------------------------------");
							System.out.println("당신이 이겼습니다.");
							score = score + 100 + mbonus;
							System.out.println("점수는 " + score + "입니다.");
							System.out.println("------------------------------");
						}
						// 정답이 아닐 때
						else {
							System.out.println("------------------------------");
							System.out.println("당신이 졌습니다.");
							System.out.println("점수는 " + score + "입니다.");
							coin--;
							System.out.println("남은 코인 : " + coin);
							System.out.println("------------------------------");
						}

						// 사용자의 선택이 2일 때
					}

					else if (usr_slct == 2) {

						// 정답이 ybw[1]일 때

						if (ybw[usr_answer] == 1) {
							System.out.println("------------------------------");
							System.out.println("당신이 이겼습니다.");
							score = score + 100 + mbonus;
							System.out.println("점수는 " + score + "입니다.");
							System.out.println("------------------------------");
						} else {
							System.out.println("당신이 졌습니다.");
							coin--;
							System.out.println("남은 코인 : " + coin);
							System.out.println("------------------------------");
						}

					} else if (usr_slct == 3) {

						// 정답이 ybw[2]일 때

						if (ybw[usr_answer] == 1) {
							System.out.println("------------------------------");
							System.out.println("당신이 이겼습니다.");
							score = score + 100 + mbonus;
							System.out.println("점수는 " + score + "입니다.");
							System.out.println("------------------------------");
						} else {
							System.out.println("------------------------------");
							System.out.println("당신이 졌습니다.");
							coin--;
							System.out.println("남은 코인 : " + coin);
							System.out.println("------------------------------");
						}
					} else if (usr_slct == 4) {

						// 정답이 ybw[3]일 때

						if (ybw[usr_answer] == 1) {
							System.out.println("------------------------------");
							System.out.println("당신이 이겼습니다.");
							score = score + 100 + mbonus;
							System.out.println("점수는 " + score + "입니다.");
							System.out.println("------------------------------");
						} else {
							System.out.println("------------------------------");
							System.out.println("당신이 졌습니다.");
							coin--;
							System.out.println("남은 코인 : " + coin);
							System.out.println("------------------------------");
						}
					} else if (usr_slct > 4 || usr_slct == 0) {

						System.out.println("1,2,3,4 중에서 입력하세요!");
						System.out.println("------------------------------");
					}
				}

			}


// 고급

// 점수가 3000점 이상일 때 3000점 까지
//System.out.println("대단하시네요! 한번 더 업!♩ ♪ ♬♬");
		else if(lv_select == 3) {
			while (coin != 0) {

				// 다시 시작하기
				// 야바위 배열
				int[] ybw = new int[5];

				// 0과 1 이 배열에 들어간다. // 중복없이
				for (int i = 0; i < ybw.length; i++) {
					ybw[i] = rd.nextInt(2);
				
					// ybawi 첫번쨰 배열에 1이 들어갔을 떄
					if (ybw[0] == 1) {
						ybw[1] = 0;
						ybw[2] = 0;
						ybw[3] = 0;
						ybw[4] = 0;
						// ybawi 두번쨰 배열에 1이 들어갔을 떄
					} else if (ybw[1] == 1) {
						ybw[0] = 0;
						ybw[2] = 0;
						ybw[3] = 0;
						ybw[4] = 0;
						// ybawi 세번쨰 배열에 1이 들어갔을 떄
					} else if (ybw[2] == 1) {
						ybw[0] = 0;
						ybw[1] = 0;
						ybw[3] = 0;
						ybw[4] = 0;
						// ybw 모든 배열에 0이 들어갔을 때
					} else if (ybw[3] == 1) {
						ybw[0] = 0;
						ybw[1] = 0;
						ybw[2] = 0;
						ybw[4] = 0;
						// ybw 모든 배열에 0이 들어갔을 때
					}else if (ybw[4] == 1) {
						ybw[0] = 0;
						ybw[1] = 0;
						ybw[3] = 0;
						ybw[2] = 0;
						// ybw 모든 배열에 0이 들어갔을 때
					}  
					else if (ybw[0] == 0 && ybw[1] == 0 && ybw[2] == 0 && ybw[3] == 0 && ybw[4] == 0) {
						ybw[0] = 0;
						ybw[1] = 0;
						ybw[2] = 0;
						ybw[3] = 1;
						ybw[4] = 0;
					}

				}

//				// 배열에 잘 들어갔는지 확인
//				for (int k = 0; k < ybw.length; k++) {
//					System.out.println("야바위 : " + ybw[k] + " ");
//				}
//				System.out.println(
//
//						 "░░░░███████░░░░░░███████░░░░░░███████░░░░░░███████░░░░░░███████░░░\r\n"
//						+"░░░░███████░░░░░░███████░░░░░░███████░░░░░░███████░░░░░░███████░░░\r\n"
//						+"░░░░███❶███░░░░░░███❷███░░░░░░███❸███░░░░░░███❹███░░░░░░███❺███░░\r\n"
//						+"░░███████████░░███████████░░███████████░░███████████░░███████████░\r\n"
//						);
				// 사용자가 번호를 고른다
				System.out.print("어디에 있을까요?>>");
				int usr_slct = sc.nextInt();

				// 야바위 배열 인덱스
				int usr_answer = usr_slct - 1;



					if (usr_slct == 1) {

						// 정답이 ybw[0]일 때

						if (ybw[usr_answer] == 1) {
							System.out.println("------------------------------");
							System.out.println("당신이 이겼습니다.");
							score = score + 100 + hbonus;
							System.out.println("점수는 " + score + "입니다.");
							System.out.println("------------------------------");
						}
						// 정답이 아닐 때
						else {
							System.out.println("------------------------------");
							System.out.println("당신이 졌습니다.");
							System.out.println("점수는 " + score + "입니다.");
							coin--;
							System.out.println("남은 코인 : " + coin);
							System.out.println("------------------------------");

						}

						// 사용자의 선택이 2일 때
					}

					else if (usr_slct == 2) {

						// 정답이 ybw[1]일 때

						if (ybw[usr_answer] == 1) {
							System.out.println("------------------------------");
							System.out.println("당신이 이겼습니다.");
							score = score + 100 + hbonus;
							System.out.println("점수는 " + score + "입니다.");
							System.out.println("------------------------------");
						} else {
							System.out.println("------------------------------");
							System.out.println("당신이 졌습니다.");
							coin--;
							System.out.println("남은 코인 : " + coin);
							System.out.println("------------------------------");
						}

					} else if (usr_slct == 3) {

						// 정답이 ybw[2]일 때

						if (ybw[usr_answer] == 1) {
							System.out.println("------------------------------");
							System.out.println("당신이 이겼습니다.");
							score = score + 100 + hbonus;
							System.out.println("점수는 " + score + "입니다.");
							System.out.println("------------------------------");
						} else {
							System.out.println("------------------------------");
							System.out.println("당신이 졌습니다.");
							coin--;
							System.out.println("남은 코인 : " + coin);
							System.out.println("------------------------------");

						}
					} else if (usr_slct == 4) {

						// 정답이 ybw[3]일 때

						if (ybw[usr_answer] == 1) {
							System.out.println("------------------------------");
							System.out.println("당신이 이겼습니다.");
							score = score + 100 + hbonus;
							System.out.println("점수는 " + score + "입니다.");
							System.out.println("------------------------------");
						} else {
							System.out.println("------------------------------");
							System.out.println("당신이 졌습니다.");
							coin--;
							System.out.println("남은 코인 : " + coin);
							System.out.println("------------------------------");

						}
					}else if (usr_slct == 5) {

						// 정답이 ybw[4]일 때

						if (ybw[usr_answer] == 1) {
							System.out.println("------------------------------");
							System.out.println("당신이 이겼습니다.");
							score = score + 100 + hbonus;
							System.out.println("점수는 " + score + "입니다.");
							System.out.println("------------------------------");

						} else {
							System.out.println("------------------------------");
							System.out.println("당신이 졌습니다.");
							coin--;
							System.out.println("남은 코인 : " + coin);
							System.out.println("------------------------------");
						}
					} else if (usr_slct > 5 || usr_slct == 0) {
						System.out.println("1,2,3,4,5 중에서 입력하세요!");
					}
				}
			

			}
	
	}
	// 종료 메소드
			public static void end (String y) {
				Scanner sc = new Scanner(System.in);
				System.out.println("다시 하시겠습니까?:y");
				String ynanswer = sc.next();
				
				switch(ynanswer) {
				default:
					System.out.println("다시 입력하세요");
				case "y":
					break;
				}
				}
	}