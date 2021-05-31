package main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Game implements KeyListener {
	Paddle player = new Paddle();
	Paddle computer = new Paddle();
	Ball ball = new Ball(player,computer);
	Thread ballThread = new Thread(ball);

	public static void main(String[] args) {
		Game game = new Game();
		game.setupGUI();
		game.startGame();
	}
	public void setupGUI() {
	    JFrame frame = new JFrame("Pong");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(Shared.windowWidth,Shared.windowHeight);
	    frame.getContentPane().setBackground(Shared.backgroundWhite);
	    frame.getContentPane().add(BorderLayout.EAST,player);
	    frame.getContentPane().add(BorderLayout.WEST,computer);
	    frame.getContentPane().add(BorderLayout.CENTER,ball);
	    frame.addKeyListener(this);
	    frame.setResizable(false);
	    frame.setVisible(true);

	    ball.setInitCoord();
	    player.setInitCoord();
	    computer.setInitCoord();


    }
    public void startGame(){
		ballThread.interrupt();
		ballThread.start();
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP){
			player.move(-10);
		}else if (e.getKeyCode() == KeyEvent.VK_DOWN){
			player.move(10);
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}


}
