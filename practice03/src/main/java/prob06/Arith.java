package prob06;

public abstract class Arith implements Calculatable {
	public int a;
	public int b;
	
	public void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	
	public abstract int calculate();
}
