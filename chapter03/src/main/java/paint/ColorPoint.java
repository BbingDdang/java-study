package paint;

public class ColorPoint extends Point {
	private String color;
	
	public ColorPoint(int x, int y, String color) {
//		setX(x);
//		setY(y);
		//super() -> x , super(x,y) -> o
		super(x,y);
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
	public void show() {
		//부분 재구현
		//super.show();
		
		//완전 재구현 시 super.show() 없음
		System.out.println("점 (" + getX() + ", " + getY() + "," + color + ")을 그렸습니다.");
	}
}
