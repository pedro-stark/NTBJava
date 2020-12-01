package KW48.gui.v05.ex3;

import javax.swing.*;
import java.util.*;

class MySwingWorker extends SwingWorker<long[], NumberAndSleepTime> {
    private long maxSleepTime;
    private int runs;
    private JLabel numberLabel, timeLabel;
    private JButton b;
    
    public MySwingWorker(long maxSleepTime, int runs, JLabel numberLabel, JLabel timeLabel, JButton b) {
        this.maxSleepTime = maxSleepTime;
        this.runs = runs;
        this.numberLabel = numberLabel;
        this.timeLabel = timeLabel;
        this.b = b;
    }

    protected long[] doInBackground() throws Exception {
        SwingWorkerDemo.sysout("doInBackground called by " + Thread.currentThread().getName());
        long[]result = new long[runs];
        for(int number = 1; number <= runs; number++) {
            long time = (long)(Math.random() * maxSleepTime);
            publish(new NumberAndSleepTime(number, time));
            double progress = (double)(number * 100) / (double)runs;
            setProgress((int)progress);
            result[number-1] = time;
            Thread.sleep(time);
        }
        return result;
    }
    
    protected void process(List<NumberAndSleepTime> list) {
        SwingWorkerDemo.sysout("process called by " + Thread.currentThread().getName());
        NumberAndSleepTime nast = list.get(list.size()-1);
        numberLabel.setText("" + nast.getNumber());
        timeLabel.setText("" + nast.getSleepTime());
    }
    
    protected void done() {
        SwingWorkerDemo.sysout("done called by " + Thread.currentThread().getName());
        try {
            long[] result = get();
            String text = "";
            for(long l : result)
            {
                text += l + " ";
            }
            timeLabel.setText(text);
        } catch(Exception e) {
        }
        b.setEnabled(true);
    }
}

