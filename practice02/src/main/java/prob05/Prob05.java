package prob05;

import java.util.Random;
import java.util.Scanner;

public class Prob05 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in );
		
		while( true ) {
			
			/* 게임 작성 */
			int num = 0;
			int idx = 1;
			int low = 1;
			int high = 100;
			// 정답 램덤하게 만들기
			Random random = new Random();
			int correctNumber = random.nextInt( 100 ) + 1;
			System.out.println("수를 결정하였습니다. 맞추어 보세요");
			
			
			while (num != correctNumber) {
				System.out.println(low + "-" + high);
				System.out.print(idx + ">>");
				num = scanner.nextInt();
				if (num > correctNumber) {
					System.out.println("더 낮게");
					high = num;
					idx += 1;
				}
				else if (num < correctNumber) {
					System.out.println("더 높게");
					low = num;
					idx += 1;
				}
				else {
					System.out.println("맞았습니다.");
					break;
				}
			}
			
			//새 게임 여부 확인하기
			System.out.print( "다시 하겠습니까(y/n)>>" );
			String answer = scanner.next();
			if( "y".equals( answer ) == false ) {
				break;
			}
		}
		
		scanner.close();
	}

}