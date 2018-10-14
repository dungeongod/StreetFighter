package streetfighter;

import javax.swing.JFrame;

public class GameFrame extends JFrame implements GameConstants {

	public GameFrame(){
		setSize(GAME_WIDTH,GAME_HEIGHT);
		Board board = new Board();
		add(board);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Dave Game - 2017");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		GameFrame obj = new GameFrame();

	}

}
