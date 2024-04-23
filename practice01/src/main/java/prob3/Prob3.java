package prob3;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		/* 코드 작성 */
		int num;
		int answer;
		
		answer = 0;
		System.out.println("숫자를 입력하세요: ");
		num = scanner.nextInt();
		
		if (num % 2 == 0) {
			for (int i = 0; i <= num; i += 2) {
				answer += i;
			}
		}
		else {
			for (int j = 1; j <= num; j += 2) {
				answer += j;
			}
		}
		System.out.print("결과 값 : ");
		System.out.println(answer);
		scanner.close();
	}
}
