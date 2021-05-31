package main;

import javax.swing.*;
import java.awt.*;

public class Ball extends JPanel {
    int velocity,x,y;
    double i,j;
    Paddle p1,p2;
    JLabel scoreboard;
    Game game;
    public Ball(Paddle p1, Paddle p2, JLabel scoreboard,Game game){
        this.p1 = p1;
        this.p2 = p2;
        this.scoreboard = scoreboard;
        this.game = game;
    }
    public void setInitCoord(){
        velocity = 5;
        i = Math.max(0.5,Math.random());
        j = 1 - i;
        x = (getWidth()/2) - 5;
        y = (getHeight()/2) - 5;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Shared.backgroundWhite);
        g2d.fillRect(0,0,getWidth(),getHeight());
        g2d.setColor(new Color(200, 0, 0));
        g2d.fillOval(x,y,10,10);
    }

    public void run() {
        while(true){
            x += i*velocity;
            y += j*velocity;
            if (x <= 0){
                if (y >= p2.y && y<= p2.y + Paddle.paddleHeight){
                    i = -1*i;
                    velocity += 1;
                }else{
                    p1.score += 1;
                    scoreboard.setText(p2.score + " - " + p1.score);
                    game.startGame();
                    return;
                }
            } else if(x >= getWidth()-10){
                if (y >= p1.y && y<= p1.y + Paddle.paddleHeight){
                    i = -1*i;
                    velocity += 1;
                }else{
                    p2.score += 1;
                    scoreboard.setText(p2.score + " - " + p1.score);
                    game.startGame();
                    return;
                }
            } else if (y <= 0 || y >= getHeight()-10){
                j = -1*j;
            }

            repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
