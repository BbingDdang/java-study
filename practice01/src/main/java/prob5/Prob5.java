package prob5;

public class Prob5 {

	public static void main(String[] args) {
		for (int i = 1; i < 100; i++) {
			int clap = 0;
			String tmp = Integer.toString(i);
			for (int j = 0; j < tmp.length(); j++) {
				if (tmp.charAt(j) == '3' || tmp.charAt(j) == '6' ||  tmp.charAt(j) == '9') {
					clap += 1;
				}
			}
			if (clap == 1) {
				System.out.print(i);
				System.out.println(" 짝");
			}
			else if (clap == 2) {
				System.out.print(i);
				System.out.println(" 짝짝");
			}
		}
		
	}
}
