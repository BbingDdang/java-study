package chapter03;

public class StudentTest02 {
	public static void main(String[] args ) {
		Student s1 = new Student();
		
		Person p1 = s1;				//다운케스팅?
		Student s2 = (Student)p1;	//업캐스팅?
	}
}
