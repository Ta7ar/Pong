package main;

import javax.swing.*;
import java.awt.*;

public class Paddle extends JPanel {
    public int score = 0;
    public int y;
    public static final int paddleWidth = 10;
    public static final int paddleHeight = 75;

    public void setInitCoord(){
        y = (getHeight() / 2) - (paddleHeight/2);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Shared.backgroundWhite);
        g2d.fillRect(0,0,getWidth(),getHeight());

        g2d.setColor(Shared.gameObjectGrey);
        g2d.fillRect(0,y, paddleWidth, paddleHeight);


    }

    public void move(int change){

        y += change;
        if (y <= 0){
            y = 0;
        }else if(y+ paddleHeight >= getHeight()){
            y = getHeight() - paddleHeight;
        }
        repaint();

    }


}
