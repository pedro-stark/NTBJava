package KW48.gui.v03;

import javax.swing.JLabel;

class Clock {
	
	private JLabel label;
	private long startTime;

	public Clock(JLabel label)
	{
		this.label = label;
		reset();
	}

	public void update()
	{
		long elapsedTime = System.currentTimeMillis() - startTime;
		long seconds = elapsedTime / 1000;
		long milliSecs = elapsedTime % 1000;
		String prefix;
		if(milliSecs < 10)
		{
			prefix = "00";
		}
		else if(milliSecs < 100)
		{
			prefix = "0";
		}
		else
		{
			prefix = "";
		}
		label.setText(seconds + ":" + prefix + milliSecs);
		
	}

	public void reset()
	{
		startTime = System.currentTimeMillis();
		update();
	}
}

