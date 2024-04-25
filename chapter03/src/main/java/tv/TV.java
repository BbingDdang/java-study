package tv;

public class TV {
	private int volume; 	//0-10
	private int channel;	//1-255
	private boolean power;	// 0 - 1
	
	public TV(int volume, int channel, boolean power) {
		this.volume = volume;
		this.channel = channel;
		this.power = power;
	}
	
	public void status() {
		if (this.power) {
			System.out.println(
					"TV[power = " + "on" + 
					", channel = " + channel + 
					", volume = " + volume + " ]");
		}
		else {
			System.out.println(
					"TV[power = " + "off" + 
					", channel = " + channel + 
					", volume = " + volume + " ]");
		}
		
	}
	
	public void power(boolean power) {
		this.power = power;
	}
	
	public void volume(boolean volume) {
		if (volume) {
			this.volume++;
		}
		else {
			this.volume--;
		}
	}
	
	public void volume(int volume) {
		this.volume = volume;
	}
	
	public void channel(boolean channel) {
		if (channel) {
			this.channel++;
		}
		else {
			this.channel--;
		}
	}
	
	public void channel(int channel) {
		this.channel = channel;
	}
}
