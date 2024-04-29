package prob01;

public class Printer02 {
	
	// 이럴땐 Test.class에서 printer.<Integer>println(10); 이런식으로 사용해야하나 생략가능.
	public <T> void println(T a) {
		System.out.println(a);
	}
	
	public <T> void println(T... ts ) {
		for(T t : ts) {
			System.out.println(t);
		}
		
	}
//	public <T> T println(T a) {
//		return t;
//	}
	
	
//	public <T,S> void println (T t, S s) {
//		System.out.println(t);
//		System.out.println(s);
//	}
	public int sum(Integer... nums) {
		int s = 0;
		for (Integer n : nums) {
			s += n;
		}
		return s;
	}
	
}
