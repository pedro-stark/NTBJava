package Pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Spielfeld extends JPanel implements ActionListener
{
    private Ball ball;
    private Timer timer;
    private Schlaeger schlaeger;
    private boolean spielGestartet;
    public Spielfeld()
    {
        setPreferredSize(new Dimension(500,500));
        setLayout(null);
        setBackground(Color.YELLOW); 

        ball = new Ball();
        schlaeger = new Schlaeger(100);

        add(ball);
        add(schlaeger);

        timer = new Timer(20, this);
        // timer.setInitialDelay(5);
        // timer.start(); 
    }

    public void schlaegerBewegen(int keyCode){
        if (keyCode == 39 && schlaeger.getLocation().getX() <= 380){
            //Schläger nach rechts
            int xLoc = (int)schlaeger.getLocation().getX() + 20;
            Point location = new Point(xLoc, 400);
            schlaeger.setLocation(location);
        } else if (keyCode == 37 && schlaeger.getLocation().getX() >= 20){
            //Schläger nach links
            int xLoc = (int)schlaeger.getLocation().getX() - 20;
            Point location = new Point(xLoc, 400);
            schlaeger.setLocation(location);
        }
    }
    
        public void winMode(int keyCode){
        if (keyCode == 38){
            Point location = new Point(ball.getX(), 400);
            
            schlaeger.setLocation(location);
        }


    }

    public void actionPerformed(ActionEvent e){
        bewegeBall();
    }

    public void bewegeBall(){
        boolean links = ball.getX() <= 0;
        boolean rechts = ball.getX() >= getWidth() - ball.getWidth();
        boolean oben = ball.getY() <= 0;
        boolean unten = ball.getY() >= getHeight() - ball.getHeight();
        boolean amSchlaegerOben = (ball.getY() + ball.getHeight() >= schlaeger.getY()) && //Höhe korrekt oben
                              (schlaeger.getX() - ball.getWidth() <= ball.getX()) && //links korrekt
                              (ball.getX() + ball.getWidth() <= ball.getWidth() + schlaeger.getX() + schlaeger.getWidth()); //rechts korrekt
                              
        // boolean amSchlaegerSeitlich =                              
                              // (schlaeger.getX() - ball.getWidth() <= ball.getX()) && //links korrekt
                              // (ball.getX() + ball.getWidth() <= ball.getWidth() + schlaeger.getX() + schlaeger.getWidth()); //rechts korrekt

        if (links || rechts) {
            ball.wechsleXRichtung();
            ball.bewegen();
        }
        else if (oben || amSchlaegerOben){
            ball.wechsleYRichtung();
            ball.bewegen();
        }
        else if (unten){
             ball.wechsleYRichtung();
             ball.bewegen();
            
             spielStoppen();
        }else{
             ball.bewegen();
        }

    }

    public Ball getBall(){
        return ball;
    }

    public Schlaeger getSchlaeger(){
        return schlaeger;
    }

    public void initialisieren(){
        schlaeger.setVisible(true);
        ball.setVisible(true);
        spielGestartet = true;
        timer.start();

    }

    public void spielStoppen(){
                JOptionPane.showMessageDialog(null,
                                              "TRY HARDER",
                                              "YOU LOST",					      
					      JOptionPane.WARNING_MESSAGE);
 
                System.exit(0);
    }

}
