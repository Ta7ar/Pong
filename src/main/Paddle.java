package main;

import javax.swing.*;
import java.awt.*;

public class Paddle extends JPanel {
    private int YPos;
    private static final int paddleWidth = 10;
    private static final int paddleHeight = 75;

    public Paddle(int initialYPos){
        YPos = initialYPos;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Shared.backgroundWhite);
        g2d.fillRect(0,0,getWidth(),getHeight());

        g2d.setColor(Shared.gameObjectGrey);
        g2d.fillRect(0,YPos, paddleWidth, paddleHeight);


    }

    public void move(int change){

        YPos += change;
        if (YPos <= 0){
            YPos = 0;
        }else if(YPos+ paddleHeight >= getHeight()){
            YPos = getHeight() - paddleHeight;
        }
        repaint();

    }

}
