package Pong;

import javax.swing.*;
import java.awt.*;
public class Schlaeger extends JPanel
{
    public Schlaeger(int width)
    {
        setBackground(Color.BLACK); 
        setBounds((500-width)/2, (500-100), width, 20); 
        setVisible(false);
    }
}
