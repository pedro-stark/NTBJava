package KW48.gui.v05.ex3;

import java.beans.*;
import javax.swing.*;

class MyPropsListener implements PropertyChangeListener
{
	private JProgressBar progressBar;
	private JLabel statusLabel, progressLabel;

	public MyPropsListener(JProgressBar progressBar, JLabel statusLabel, JLabel progressLabel) {
		this.progressBar = progressBar;
		this.statusLabel = statusLabel;
		this.progressLabel = progressLabel;
	}

	public void propertyChange(PropertyChangeEvent evt)  {
		SwingWorkerDemo.sysout("propertyChange called by " + Thread.currentThread().getName());
		JLabel l = null;
		if(evt.getPropertyName().equals("state")) {
			l = statusLabel;
		}
		else if(evt.getPropertyName().equals("progress"))
		{
			l = progressLabel;
			progressBar.setValue((Integer)(evt.getNewValue()));
		}
		String message = evt.getPropertyName() + ": " + evt.getOldValue() + " => " + evt.getNewValue();
		if(l != null) {
			l.setText(message);
		} else {
			System.out.println(message);
		}
	}
}
