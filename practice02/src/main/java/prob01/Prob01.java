package prob01;

import java.util.Scanner;

public class Prob01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in  );

		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };
		
		/* 코드 작성 */
		int cnt[] = new int[10];
		
		int num;
		System.out.print("금액: ");
		num = scanner.nextInt();
		while (num > 0) {
			if (num >= MONEYS[0]) {
				cnt[0] += 1;
				num -= MONEYS[0];
			}
			else if (MONEYS[1] <= num && num < MONEYS[0]) {
				cnt[1] += 1;
				num -= MONEYS[1];
			}
			else if (MONEYS[2] <= num && num < MONEYS[1]) {
				cnt[2] += 1;
				num -= MONEYS[2];
			}
			else if (MONEYS[3] <= num && num < MONEYS[2]) {
				cnt[3] += 1;
				num -= MONEYS[3];
			}
			else if (MONEYS[4] <= num && num < MONEYS[3]) {
				cnt[4] += 1;
				num -= MONEYS[4];
			}
			else if (MONEYS[5] <= num && num < MONEYS[4]) {
				cnt[5] += 1;
				num -= MONEYS[5];
			}
			else if (MONEYS[6] <= num && num < MONEYS[5]) {
				cnt[6] += 1;
				num -= MONEYS[6];
			}
			else if (MONEYS[7] <= num && num < MONEYS[6]) {
				cnt[7] += 1;
				num -= MONEYS[7];
			}
			else if (MONEYS[8] <= num && num < MONEYS[7]) {
				cnt[8] += 1;
				num -= MONEYS[8];
			}
			else {
				cnt[9] += 1;
				num -= MONEYS[9];
			}
			
		}
		for (int i = 0; i < cnt.length; i ++) {
			System.out.print(MONEYS[i]);
			System.out.print("원 : ");
			System.out.print(cnt[i]);
			System.out.println("개");
		}
		
		scanner.close();
 	}
}