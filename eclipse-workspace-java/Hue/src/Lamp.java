
public class Lamp {

	int number;
	int bri;
	int hue;
	int sat;
	boolean on;
	boolean hellnachdunkel;
	boolean flash;

	public Lamp() {
		// Init
		number = 0;
		bri = 0;
		hue = 0;
		sat = 0;
		on = false;
		hellnachdunkel = false;
		flash = false;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getBri() {
		return bri;
	}

	public void setBri(int bri) {
		this.bri = bri;
	}

	public int getHue() {
		return hue;
	}

	public void setHue(int hue) {
		if (hue < 0 || hue > 65535) {
			this.hue = 0;
		} else {
			this.hue = hue;
		}
	}

	public int getSat() {
		return sat;
	}

	public void setSat(int sat) {
		if (sat > 255) {
			this.sat = 255;
		} else if (sat < 0) {
			this.sat = 0;
		}else {
			this.sat = sat;
		}
	}

	public boolean isOn() {
		return on;
	}

	public void setOn(boolean on) {
		this.on = on;
	}

}
