package �ູ������;

import java.util.Random;
import java.util.Scanner;

public class ���Ըӽ� {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random rd = new Random();

		// ���� ����!
		int coin = 10; // ����
		int score = 0; // �� ���ھ�
		int bonus = 10; // easy ���ʽ� ����
		int bonus1 = 20; // normal ���ʽ� ����
		int bonus2 = 30; // hard ���ʽ� ����

		while (coin != 0) {

			int[] slotmc = new int[5];
			// �� �迭�� �����Լ� ����
			slotmc[0] = rd.nextInt(9) + 1;
			slotmc[1] = rd.nextInt(9) + 1;
			slotmc[2] = rd.nextInt(9) + 1;
			slotmc[3] = rd.nextInt(9) + 1;
			slotmc[4] = rd.nextInt(9) + 1;

			System.out.println("=============���Ըӽ�============");
			System.out.println("[1]easy [2] normal [3]hard");
			System.out.println();
			System.out.print("�����Է� :");

			int select = sc.nextInt();

			// ���ӽ���
			if (select == 1) { // easy
				System.out.println(slotmc[0] + " " + slotmc[1] + " " + slotmc[2]);
				if (slotmc[0] == slotmc[1] && slotmc[0] == slotmc[2]) {
					System.out.println("100 �� ȹ�� !! ");
					coin = coin + 2;
					score = score + 100;
					System.out.println("���� ���� :" + score);
				} else if (slotmc[0] == slotmc[1]) {
					System.out.println("10�� ȹ��");
					score = score + bonus;
					System.out.println("���� ���� :" + score);
				} else if (slotmc[0] == slotmc[2]) {
					System.out.println("10�� ȹ��");
					score = score + bonus;
					System.out.println("���� ���� :" + score);
				} else if (slotmc[1] == slotmc[2]) {
					System.out.println("10�� ȹ��");
					score = score + bonus;
					System.out.println("���� ���� :" + score);
				} else {
					System.out.println("���� ���� �Ф� ");
					coin--;
					System.out.println("�������μ� :" + coin);
					System.out.println("���� ���� :" + score);
				}

			}
			if (select == 2) { // normal
				System.out.println(slotmc[0] + " " + slotmc[1] + " " + slotmc[2] + " " + slotmc[3]);
				if (slotmc[0] == slotmc[1] && slotmc[0] == slotmc[2] && slotmc[0] == slotmc[3]) {
					System.out.println("100 �� ȹ�� !! ");
					coin = coin + 3;
					score = score + 200;
					System.out.println("���� ���� :" + score);
				} else if (slotmc[0] == slotmc[1] && slotmc[0] == slotmc[2]) {
					System.out.println("20�� ȹ��");
					score = score + bonus1;
					System.out.println("���� ���� :" + score);
				} else if (slotmc[0] == slotmc[1] && slotmc[0] == slotmc[3]) {
					System.out.println("20�� ȹ��");
					score = score + bonus1;
					System.out.println("���� ���� :" + score);
				} else if (slotmc[1] == slotmc[2] && slotmc[0] == slotmc[3]) {
					System.out.println("20�� ȹ��");
					score = score + bonus1;
					System.out.println("���� ���� :" + score);
				} else if (slotmc[1] == slotmc[2] && slotmc[3] == slotmc[0]) {
					System.out.println("20�� ȹ��");
					score = score + bonus1;
					System.out.println("���� ���� :" + score);
				} else {
					System.out.println("���� ���� �Ф� ");
					coin--;
					System.out.println("�������μ� :" + coin);
					System.out.println("���� ���� :" + score);
				}
			}
			if (select == 3) { // hard
				System.out.println(slotmc[0] + " " + slotmc[1] + " " + slotmc[2] + " " + slotmc[3] + " " + slotmc[4]);
				if (slotmc[0] == slotmc[1] && slotmc[0] == slotmc[2] && slotmc[0] == slotmc[3]
						&& slotmc[0] == slotmc[4]) {
					System.out.println("100 �� ȹ�� !! ");
					coin = coin + 5;
					score = score + 300;
					System.out.println("���� ���� :" + score);
				} else if (slotmc[1] == slotmc[2] && slotmc[1] == slotmc[3] && slotmc[1] == slotmc[4]) {
					System.out.println("30�� ȹ��");
					score = score + bonus2;
				} else if (slotmc[2] == slotmc[1] && slotmc[2] == slotmc[3] && slotmc[2] == slotmc[0]) {
					System.out.println("30�� ȹ��");
					score = score + bonus2;
				} else if (slotmc[3] == slotmc[4] && slotmc[3] == slotmc[1] && slotmc[3] == slotmc[0]) {
					System.out.println("30�� ȹ��");
					score = score + bonus2;
				} else if (slotmc[4] == slotmc[0] && slotmc[4] == slotmc[1] && slotmc[4] == slotmc[2]) {
					System.out.println("30�� ȹ��");
					score = score + bonus2;
				} else {
					System.out.println("���� ���� �Ф� ");
					coin--;
					System.out.println("�������μ� :" + coin);
					System.out.println("���� ���� :" + score);
				}
			}

		}

	}
}
