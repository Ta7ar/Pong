package main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Game implements KeyListener {
	Paddle player = new Paddle();
	Paddle computer = new Paddle();
	JLabel scoreboard = new JLabel(computer.score + " - " + player.score,SwingConstants.CENTER);
	Ball ballPanel = new Ball(player,computer,scoreboard);
	Thread ballThread = new Thread(ballPanel);
	public Game(){
		scoreboard.setFont(new Font("Verdana",Font.BOLD,18));
		scoreboard.setBorder(BorderFactory.createLineBorder(Shared.gameObjectGrey));
	}

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
	    frame.getContentPane().add(BorderLayout.CENTER, ballPanel);
	    frame.getContentPane().add(BorderLayout.NORTH,scoreboard);
	    frame.addKeyListener(this);
	    frame.setResizable(false);
	    frame.setVisible(true);
    }
    public void startGame(){
		player.setInitCoord();
		computer.setInitCoord();
		ballPanel.setInitCoord();

		JLabel countdownLabel = new JLabel();
		countdownLabel.setHorizontalTextPosition(SwingConstants.HORIZONTAL);
		countdownLabel.setFont(new Font("Verdana",Font.BOLD,24));
		ballPanel.add(countdownLabel);
		for(int i = 3; i >= 0 ; i--){
			try {
				countdownLabel.setText(String.valueOf(i));
				Thread.sleep(750);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		countdownLabel.setText("");

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
