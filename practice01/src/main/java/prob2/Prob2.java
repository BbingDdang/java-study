package prob2;

public class Prob2 {
	public static void main(String[] args) {
		/* 코드 작성 */
		int num;
		num = 1;
		for (int i = 1; i < 10; i++) {
			for (int j = i; j < 10+i; j ++) {
				System.out.print(j);
				System.out.print(" ");
			}
			System.out.println();
			
		}
		
	}
}
