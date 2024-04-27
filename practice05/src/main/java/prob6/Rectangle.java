package prob6;

public class Rectangle extends Shape implements Resizable {
	public Rectangle(double width, double height) {
		super(width, height);
	}

	@Override
	public void resize(double s) {
		this.width = this.width * s;
		this.height = this.height * s;
		
	}

	@Override
	double getArea() {
		
		return width * height;
	}

	@Override
	double getPerimeter() {
		
		return 2* (width + height);
	}
	
	

}
