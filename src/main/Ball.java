package main;

import javax.swing.*;
import java.awt.*;

public class Ball extends JPanel implements Runnable {
    int velocity = 5 ,x,y;
    double i,j;
    Paddle p1,p2;
    public Ball(Paddle p1, Paddle p2){
        i = Math.max(0.5,Math.random());
        j = 1 - i;
        this.p1 = p1;
        this.p2 = p2;
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
            if (x <= 0){
                if (y >= p2.y && y<= p2.y + Paddle.paddleHeight){
                    i = -1*i;
                    velocity += 1;
                }
            } else if(x >= getWidth()){
                if (y >= p1.y && y<= p1.y + Paddle.paddleHeight){
                    i = -1*i;
                    velocity += 1;
                }
            } else if (y <= 0 || y >= getHeight()-10){
                j = -1*j;
            }
            repaint();
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
