package chapter03;

public class Student extends Person {
	public Student() {
		// 자식생성자에서 부모생성자를 명시적으로 호출하지 않으면 자동으로 부모의 기본 생성자를 호출함.
		//super(); // 굳이 명시하지않아도 알아서 호출됨
		
		System.out.println("Student() called");
		
	}
}
