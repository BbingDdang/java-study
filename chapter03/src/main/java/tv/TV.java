package tv;

public class TV {
	private int volume; 	//0-10
	private int channel;	//1-255
	private boolean power;	// 0 - 1
	
	public TV(int channel, int volume, boolean power) {
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
			if (this.volume > 100) {
				this.volume = 100;
			}
		}
		else {
			this.volume--;
			if (this.volume < 0) {
				this.volume = 0;
			}
		}
	}
	
	public void volume(int volume) {
		this.volume = volume;
		if (this.volume > 100) {
			this.volume = 100;
		}
		else if (this.volume < 0) {
			this.volume = 0;
		}
	}
	
	public void channel(boolean channel) {
		if (channel) {
			this.channel++;
			if (this.channel > 255) {
				this.channel = 255;
			}
		}
		else {
			this.channel--;
			if (this.channel < 0) {
				this.channel = 0;
			}
		}
	}
	
	public void channel(int channel) {
		this.channel = channel;
		if (this.channel > 255) {
			this.channel = 255;
		}
		else if (this.channel < 1) {
			this.channel = 1;
		}
	}
}
