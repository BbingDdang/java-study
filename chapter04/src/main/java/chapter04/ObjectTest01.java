package chapter04;

public class ObjectTest01 {
	public static void main(String[] args) {
		Point point = new Point();
		
		Class klass = point.getClass(); //refrelection
		
		System.out.println(klass.toString());
		
		System.out.println(point.hashCode()); 	//adress ����� �ؽ̰�
												//address x
												//reference x
		
		
		
		System.out.println(point.toString()); //getClass().toString() + "@" + hashCode()
		System.out.println(point);
	}
}
