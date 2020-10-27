package Pong;

import javax.swing.*;
import java.awt.*;
public class Ball extends JPanel
{
    private int velx;
    private int vely;
    public Ball()
    {
        velx = 5;
        vely = 5;
        //(int)getLocation().getX()
        
        setBounds(100, 100, 20, 20); 
        setBackground(Color.RED); 
        setVisible(false);
    }

    public void wechsleXRichtung(){
        velx = velx *(-1);
    }
    
    public void wechsleYRichtung(){
        vely = vely *(-1);
    }
    
    public void bewegen(){
        setLocation(getX() + velx, getY() + vely);
    }
}
