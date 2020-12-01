package KW48.gui.v03;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ClockManager
{
    public static void main(String[] args)
    {
        JFrame f = new JFrame("Uhr");
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setLayout(new GridLayout(0, 1));
        JLabel label = new JLabel("", SwingConstants.RIGHT);
        f.add(label);
        JButton b1 = new JButton("Start");
        f.add(b1);
        JButton b2 = new JButton("Stopp");
        f.add(b2);
        JButton b3 = new JButton("Null");
        f.add(b3);
        JButton b4 = new JButton("Ende");
        f.add(b4);
        Clock clock = new Clock(label);
        EventHandler h = new EventHandler(clock);
        b1.addActionListener(h);
        b2.addActionListener(h);
        b3.addActionListener(h);
        b4.addActionListener(h);
        f.setLocation(300, 50);
        f.setSize(150, 200);
        f.setVisible(true);
    }
}