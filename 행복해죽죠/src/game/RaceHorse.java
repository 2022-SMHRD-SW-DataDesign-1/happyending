package game;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class RaceHorse {

	private int coin;
	private int score;
	public  RaceHorse(int coin, int score) {
		this.coin = coin;
		this.score = score;
	}
	public int getScore() {
		return score;
	}
	public int getcoin() {
		return coin;
	}
	public void setScore(int score) {
		this.score=score;
	}
	public void setcoin(int coin) {
		this.coin=coin;
	}
	static int strRank = 1;

	public static void Horse() {
		
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("말을 선택하세요 :) >>");
		int num = sc.nextInt();
		List<Horse> list = new ArrayList<>();
		int score = 1000;
		list.add(new Horse("1번마"));
		list.add(new Horse("2번마"));
		list.add(new Horse("3번마"));


		for (Horse horse : list) {
			horse.start();
		}

		for (Horse hs : list) {
			try {
				hs.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		Collections.sort(list);
		System.out.println("경기끝 ....");
		System.out.println("======================================================");
		System.out.println();
		System.out.println(" 경기 결과 ");
		

		for (Horse horse : list) {
			System.out.println(horse.getName1() + " " + horse.getRank() + "등");
		
		}
		

		
		if(list.get(0).getName1().equals(num+"번마")) {
			score=score*2;
			System.out.println("1등 축하합니다!!@!~!~!");
			System.out.println(score);
		}

		

		}
	}


class Horse extends Thread implements Comparable<Horse>{
   private String name1;
   int rank;

   public Horse(String name) {
      this.name1 = name;
   }

   public String getName1() {
      return name1;
   }

   public void setName1(String name) {
      this.name1 = name;
   }

   public int getRank() {
      return rank;
   }

   public void setRank(int rank) {
      this.rank = rank;
   }


	@Override
	public void run() {
		for (int i = 0; i < 40; i++) {
			System.out.println("\n" + name1 + " : ");
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			System.out.print("\"🐌\"");

			for (int j = 49; j > i; j--) {
				System.out.print(" ");
			}



			System.out.println();

			try {
				Thread.sleep((int) (Math.random() * 500));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		System.out.println(name1 + " 끝");

		setRank(RaceHorse.strRank);
		RaceHorse.strRank++;
	}

	@Override
	public int compareTo(Horse hor) {
		if (rank > hor.getRank()) {
			return 1;
		} else {
			return -1;
		}
	}
}