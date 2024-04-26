package prob03;

public class UnitTest {

	public static void main(String[] args) {
		Tank tnk = new Tank();
		Marine mr = new Marine();
		DropShip ds = new DropShip();
		
		
		tnk.move(1, 2);
		tnk.changeMode();
		mr.stop();
		mr.stimPack();
		ds.stop();
		ds.load();
		
	}

}
