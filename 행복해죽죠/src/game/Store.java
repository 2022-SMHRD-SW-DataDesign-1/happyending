package game;

import java.util.Scanner;

public class Store {
	//score를 경험치로 교환.
	//경험치는 최대 10
	//경험치가 10이되면 lv+1
	//lv1은 score 100당 경험치1
	//lv2는 score 200당 경험치1
	private int score;
	private int coin;
	private int ex;
	private int lv;
	private int much_score=100;
	Scanner sc = new Scanner(System.in);
	
	public Store(int score, int coin, int ex, int lv) {
		this.score = score;
		this.coin = coin;
		this.ex = ex;
		this.lv = lv;
	}

	
	public int getScore() {
		return score;
	}


	public int getCoin() {
		return coin;
	}


	public int getEx() {
		return ex;
	}


	public int getLv() {
		return lv;
	}


	public void trade(){
		
		boolean isRun = true;
		while(isRun) {
			System.out.println("상점에 오신것을 환영합니다. 이곳에서는 게임으로 얻은 score을 코인이나 경험치로 전환이 가능합니다.");
			System.out.println("=========================================================================");
			System.out.println("[0]메인화면 [1] coin구매 [2]ex(경험치)구매");
			
			int sel_trade = sc.nextInt();
			
			switch (sel_trade) {
			case 1:
				System.out.println("=== 게임을 하기위한 coin은 score 20점당 1개를 지급받을 수 있습니다. ===");
				System.out.println("== 필요한 코인을 입력하세요 ==");
				int coin_trade = sc.nextInt();
				if(score<20) {
					System.out.println("거래를 위한 score가 부족합니다.");
				}else {
					if(coin_trade*20>score) {
						System.out.println("거래하기 위한 scroe가 부족합니다.");
					}else {
						int becoin = coin;
						int bescore = score;
						this.coin+=coin_trade;
						this.score =score-(coin_trade*20);
						System.out.println("거래 후 코인 : "+becoin+"=>"+ this.coin);
						System.out.println("거래 후 스코어 :"+bescore+ "=>" +  this.score);	
					}
				}
				//연속으로 거래할 경우를 대비.
				break;
				
			case 2:
				System.out.println("==경험치는 레벨에 따라 요구하는 score양이 달라집니다.==");
				System.out.println("<1의 경험치를 얻기 위해서는 LEVEL당 100의score 필요>");
				int score_trade = sc.nextInt();
				
				
					if(score<(1*lv)) {
						System.out.println("거래가능한 score가 부족합니다.");
					}else {
							if((score_trade*lv*much_score)<score) {
								int beex =ex;
								int bescore =score;
								this.score =score-(score_trade*lv*much_score);
								this.ex = ex+score_trade;
								System.out.println("거래 후 경험치 : "+beex+"=>"+ this.ex);
								System.out.println("거래 후 스코어 :"+bescore+ "=>" +  this.score);	
							}
							else {
								System.out.println("가지고있는 score보다 거래를 위한 score가 많습니다.");
							}
					}
					if(this.ex>9) {
						this.lv=lv+(this.ex)/10;
						this.ex = this.ex%10;
						System.out.println(lv+"달성");
					}
					
					
				break;
				
				
				
			default:
				System.out.println("메인화면으로 이동합니다.");
				isRun =false;
				break;
			}
		
		
		
		}
	}

}
