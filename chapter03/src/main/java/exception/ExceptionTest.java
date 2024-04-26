package exception;

public class ExceptionTest {
	public static void main(String[] args) {
		int a = 10;
		int b = 10 - a;
		
		
		System.out.println(" Some Code1... ");
		
		try {
			System.out.println(" Some Code2... ");
			int result = (1 + 2 + 3) / b;
			System.out.println(" Some Code3... ");
		} catch(ArithmeticException ex) {
			//예외처리
			//적어도 이정돈 적어야함.
			//1. 로깅 -> 파일로 (spring => sfj?)
			System.out.println("error : " + ex);
			
			//2. 사과
			System.out.println("미안합니다..");
			
			//3. 정상종료
			// 0 -> 정상종료 1 -> 에러있을때 종료
			//System.exit(1);
			return;
			
			//ex.printStackTrace();
			
		} finally {
			//무조건 실행되는 구간
			System.out.println("자원 정리 : ex) close file, socket, db connection");
			
		}
		
		System.out.println(" Some Code4... ");
		
		//System.out.println(result);
	}
}
