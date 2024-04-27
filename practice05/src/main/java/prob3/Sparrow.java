package prob3;

public class Sparrow extends Bird {
	public Sparrow() {
		super.getName();
	}

	@Override
	public String toString() {
		return "참새의 이름은 " + this.name + " 입니다.";
	}

	@Override
	public void fly() {
		System.out.println("참새("+this.name+")가 날아다닙니다.");
		
	}

	@Override
	public void sing() {
		System.out.println("참새("+this.name+")가 소리내어 웁니다.");
		
	}

}
