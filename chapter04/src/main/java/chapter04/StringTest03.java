package chapter04;

public class StringTest03 {

	public static void main(String[] args) {
		//String s1 = "Hello " + "World" + " java " + 17;  <= �߸����� ū�ϳ����� ����.
		String s1 = new StringBuffer("Hello ")
						.append("World")
						.append(" java")
						.append(17)
						.toString();
		System.out.println(s1);
		
		String s2 = new StringBuilder("Hello ")
				.append("World")	
				.append("java")
				.append(17)
				.toString();
		System.out.println(s2);
		
		String s3 = "";
		
		for (int i = 0; i < 1000000; i++) {
			//s3 = s3 + "h";
			//s3 = new StringBuffer(s3).append("h").toString();
		}
		
//		StringBuffer sb = new StringBuffer("");
//		for (int i = 0; i < 1000000; i++) {
//			sb.append("h");
//			
//		}
//		String s4 = sb.toString();
		
		String s5 = "aBcABCabcAbc";
		System.out.println(s5.length());
		System.out.println(s5.charAt(2));
		System.out.println(s5.indexOf("abc"));
		System.out.println(s5.indexOf("abc", 7));
		System.out.println(s5.substring(3));
		System.out.println(s5.substring(3, 5));
		
		
		String s6 = "             ab       cd       ";
		String s7 = "efg,hij,klm,nop,qrs";
		String s8 = s6.concat(s7);
		System.out.println(s8);
		// space 없앰 (앞뒤만)
		System.out.println(s6.trim());
		System.out.println(s6.replaceAll(" ", ""));
		
		String[] tokens = s7.split(",");
		for(String s : tokens) {
			System.out.println(s);
			
		}
		
		String[] tokens2 = s7.split(" ");
		for (String s : tokens2) {
			System.out.println(s);
			
		}
		
	}

}
