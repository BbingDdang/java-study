package com.poscodx.paint.main;

import com.poscodx.paint.i.Drawable;
import com.poscodx.paint.point.ColorPoint;
import com.poscodx.paint.point.Point;
import com.poscodx.paint.shape.Circle;
import com.poscodx.paint.shape.Rectangle;
import com.poscodx.paint.shape.Shape;
import com.poscodx.paint.shape.Triangle;
import com.poscodx.paint.text.GraphicText;

public class Main {

	public static void main(String[] args) {
		Point point = new Point(10, 20);
//		point.setX(10);
//		point.setY(20);
		//drawPoint(point);
		draw(point);
		point.show(false);
		ColorPoint p1 = new ColorPoint(20, 20, "R");
		//drawPoint(p1);
		draw(p1);
		//drawTriangle(new Triangle());
		draw(new Triangle());
		draw(new Rectangle());
		draw(new Circle());
		draw(new GraphicText("Hello World!"));
		
		Circle c = new Circle();
		
		System.out.println(c instanceof Circle);
		System.out.println(c instanceof Shape);
		System.out.println(c instanceof Object);
		
		//error : 연산자 우측항이 클래스인 경우 레퍼런스 하고 있는 class 타입의 hierarchy상의 하위 사이 상위만 instanceof 연산자 사용 가능
		//System.out.println(c instanceof Point);
		Object o = new Circle();
		
		System.out.println(o instanceof String);
		//연산자의 우측항이 인터페이스 인 경우
		//하이어아키 상관없이 instanceof 연산자를 사용 
		//단순하게 기능 구현에 대한 확인.
		System.out.println(c instanceof Drawable);
		System.out.println(c instanceof Runnable);
	}
	
	
	private static void draw(Drawable drawable) {
		drawable.draw();
	}
//	private static void drawShape(Shape shape) {
//		shape.draw();
//	}
//	
//	private static void drawPoint(Point point) {
//		point.show();
//	}
//	
//	private static void drawTriangle(Triangle triangle) {
//		triangle.draw();
//	}
//	
//	private static void drawRectangle(Rectangle rectangle) {
//		rectangle.draw();
//	}
//		
}
