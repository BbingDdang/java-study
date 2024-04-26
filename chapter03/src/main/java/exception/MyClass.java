package exception;

import java.io.IOException;

public class MyClass {
	
	public void danger() throws IOException, MyException {
		System.out.println("Some 코드Code1...");
		System.out.println("Some Code2...");
		
		if (true) {
			throw new MyException();
		}
		
		if (true) { 
			throw new IOException();
		}
		
		System.out.println("Some 코드Code3...");
		System.out.println("Some Code4...");
		
	}
	
}
