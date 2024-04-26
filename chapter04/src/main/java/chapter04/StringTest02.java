package chapter04;

public class StringTest02 {

	public static void main(String[] args) {
		// immutability 불변성 
		
		String s1 = "abc";
		String s2 = "def";
		String s3 = s2;
		
		s2 = s1.toUpperCase();
		String s4 = s2.concat("??");
		String s5 = "!".concat(s2).concat("@");;
			
		// 변수로 안넣어줘서 생겼다가 바로 사라짐
		"Hello World".toUpperCase();
	
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		System.out.println(s5);
		
		System.out.println(equalsHello("hello"));
	}
	
	private static boolean equalsHello(String s) {
		// return s.equals("hello"); 면 nullpointexception 발생. 비교 리터럴이 앞으로 가면 좋음.
		return "hello".equals(s);
	}

}
