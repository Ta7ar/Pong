package main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Game implements KeyListener {
	Paddle player = new Paddle(50);

	public static void main(String[] args) {
		new Game().run();
	}
	private void setupGUI(){

	}

    public void run() {
	    JFrame frame = new JFrame("Pong");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(Shared.windowWidth,Shared.windowHeight);
	    frame.getContentPane().setBackground(Shared.backgroundWhite);
	    frame.getContentPane().add(BorderLayout.EAST,player);
	    frame.addKeyListener(this);
	    frame.setResizable(false);
	    frame.setVisible(true);
    }

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP){
			player.move(-7);
		}else if (e.getKeyCode() == KeyEvent.VK_DOWN){
			player.move(7);
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}


}
