package prob6;

public class RectTriangle extends Shape {
	public RectTriangle(double width, double height) {
		super(width, height);
	}
	@Override
	double getArea() {
		
		return (width * height) / 2;
	}

	@Override
	double getPerimeter() {
		// TODO Auto-generated method stub
		return width + height + Math.sqrt(width * width + height * height);
	}

}
