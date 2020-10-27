package Pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Pong extends JFrame implements KeyListener 
{
    private Spielfeld sf;
    private boolean spielGestartet;
    public Pong() 
    {
        super("PONG");

        erzeugeFenster();

    }

    public void erzeugeFenster(){
        Container c = getContentPane();
        JButton start = new JButton("Start");
        start.addActionListener(e ->{ 
                sf.initialisieren();
                start.setFocusable(false);
                spielGestartet = true;
            });

        c.setLayout(new BorderLayout());
        c.add(start, BorderLayout.NORTH);

        sf = new Spielfeld();
        c.add(sf, BorderLayout.CENTER);

        pack();
        setVisible(true);

        this.setFocusable(true);
        this.addKeyListener(this);
    }

    public void keyTyped(KeyEvent e) {
        System.out.println("KeyTyped: ");
        if(e.getKeyChar() == KeyEvent.CHAR_UNDEFINED){
            System.out.println("Kein Unicode-Character gedr\u00FCckt!");
        }else{
            System.out.println(e.getKeyChar() + " gedr\u00FCckt!");
        }
        System.out.println("---");
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 39 || e.getKeyCode() == 37 && spielGestartet){
            sf.schlaegerBewegen(e.getKeyCode());
        }

        if (e.getKeyCode() == 38){
            sf.winMode(e.getKeyCode());
        }

        System.out.println("Taste: " + e.getKeyChar() + ", Code: " + e.getKeyCode());
        System.out.println("Tastenposition: " + e.getKeyLocation());
        System.out.println("---");
    }

    public void keyReleased(KeyEvent e) {
        System.out.println("KeyReleased: ");
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            System.out.println("Programmabbruch!");
            System.exit(0);
        }    
        System.out.println("Taste: " + e.getKeyChar() + ", Code: " + e.getKeyCode());
        System.out.println("---");
    } 

    public static void main(){
        new Pong();
    }
}
