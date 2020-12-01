package KW48.gui.v05.ex3;

import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import java.util.*;
import javax.swing.*;



public class SwingWorkerDemo extends JFrame implements ActionListener
{
    private static final int RUNS = 10;
    private static final long MAX_SLEEP_TIME = 8000;
    
	public JProgressBar progressBar;
	public JLabel statusLabel;
	public JLabel progressLabel;
	public JLabel numberLabel;
	public JLabel timeLabel;
	public JButton b;    

	public SwingWorkerDemo()
    {
        super("Swing Worker Demo");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(0, 1));
        progressBar = new JProgressBar(0, 100);
        add(progressBar);
        statusLabel = new JLabel();
        add(statusLabel);
        progressLabel = new JLabel();
        add(progressLabel);
        numberLabel = new JLabel();
        add(numberLabel);
        timeLabel = new JLabel();
        add(timeLabel);
        b = new JButton("Execute");
        b.addActionListener(this);
        add(b);

        setLocation(30, 30);
        setSize(380, 250);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent evt) {
        progressBar.setValue(0);
        statusLabel.setText("");
        progressLabel.setText("");
        numberLabel.setText("");
        timeLabel.setText("");
        b.setEnabled(false);
        MySwingWorker worker = new MySwingWorker(MAX_SLEEP_TIME, RUNS, numberLabel, timeLabel, b);
        worker.addPropertyChangeListener(new MyPropsListener(progressBar, statusLabel, progressLabel));
        worker.execute();
    }
    
    public static void sysout(String message) {
        if(SwingUtilities.isEventDispatchThread()) {
            message += " (is EDT)";
        } else {
            message += " (is not EDT)";
        }
        System.out.println(message);
    }

    public static void main(String[] args) {
        new SwingWorkerDemo();
    }
}