package prob4;

import java.util.Scanner;

public class Prob4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String answer = "";
		System.out.print("문자열을 입력하세요 : ");
		String text = scanner.nextLine();
		for (int i = 0; i < text.length(); i++) {
			answer += text.charAt(i);
			System.out.println(answer);
		}
		
		scanner.close();
	}

}
