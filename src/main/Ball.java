package main;

import javax.swing.*;
import java.awt.*;

public class Ball extends JPanel implements Runnable {
    int velocity = 5 ,x,y;
    double i,j;
    public Ball(){
        i = Math.random();
        j = 1 - i;
    }
    public void setInitCoord(){
        x = (getWidth()/2) - 5;
        y = (getHeight()/2) - 5;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Shared.backgroundWhite);
        g2d.fillRect(0,0,getWidth(),getHeight());
        g2d.setColor(new Color(200, 0, 0));
        g2d.fillOval(x,y,10,10);
    }

    @Override
    public void run() {
        while(true){
            x += i*velocity;
            y += j*velocity;
            repaint();
            //System.out.println("Ball thread running");
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
