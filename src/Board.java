
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements GameConstants {
	Image bg;
	Player player;
	Enemy enemy;
	Camera camera = new Camera();
	boolean isCtrl = false;

	public Board() {
		setSize(GAME_WIDTH, GAME_HEIGHT);

		//bg = new ImageIcon(Board.class.getResource(BACKGROUND)).getImage();
		player = new Player();

		setFocusable(true);
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				/*if(e.getKeyCode()==KeyEvent.VK_G){
					isCtrl=true;
				}*/
				int h = player.h;
				if (e.getKeyCode() == KeyEvent.VK_F) {
					player.setFireAttack();

					//player.fire();
					isCtrl = false;
				}
				if(e.getKeyCode() == KeyEvent.VK_Z){
					enemy.setFireAttack();
					//enemy.fire();

				}
				if(e.getKeyCode() == KeyEvent.VK_G){
					player.setPunchMoves();
				}
				//player.h = h;
				//if(player.x<GAME_WIDTH-player.w){
					if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
						player.setWalkMoves();
						player.setSpeed(10);

						player.move();

						//camera.right();
						//camera.move();
					}
				//}
				if(player.x>0) {
					if (e.getKeyCode() == KeyEvent.VK_LEFT) {
						player.setWalkMoves();
						player.setSpeed(-10);
						player.move();
					/*enemy.setSpeed(-10);
					enemy.move();
					*///System.out.println("Left...");
						//player.setSpeed(-25);
						//player.move();
					}
				}
				if(e.getKeyCode() == KeyEvent.VK_D) {
					if (enemy == null) return;
					enemy.setSpeed(10);
					enemy.move();
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					player.setCrouch();

				}
				if(e.getKeyCode() == KeyEvent.VK_S){
					if (enemy == null) return;
					enemy.setCrouch();
				}


				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					player.jump();
					//enemy.jump();
				}

			}
		});

		gameLoop();


	}

	private void drawBullets(Graphics g) {
		for (Bullet bullet : player.bulletList) {
			if (bullet.isVisible) {
				bullet.drawBullet(g);
				bullet.move();
			}
		}
	}

	/*public boolean isCollision(Player player, Enemy enemy) {
		int xDistance = Math.abs(player.getX() - enemy.getX());
		int yDistance = Math.abs(player.getY() - enemy.getY());
		return xDistance <= (player.getW() - 30) && yDistance <= (player.getH() - 20);
	}*/

	boolean isGameOver = false;

	public void checkCollision() {

		//boolean result = isCollision(player, enemy);
		//if(result == true){
		/*if (isCollision(player, enemy)) {
			isGameOver = true;
			repaint();
			timer.stop();
		}*/
	}


	public void gameOver(Graphics g) {
		g.setColor(Color.RED);
		g.setFont(new Font("Arial", Font.BOLD, 40));
		g.drawString("Game Over", GAME_WIDTH / 2, GAME_HEIGHT / 2);
	}

	Timer timer;

	private void gameLoop() {
		timer = new Timer(DELAY, (e) -> {
			repaint();

			player.fall();
			//enemy.fall();
			checkCollision();
		});
		timer.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		camera.drawBG(g);
		//drawBackGround(g);
		if (isGameOver) {
			gameOver(g);
		}
		player.drawPlayer(g);
		try {

			enemy.drawEnemy(g);
		}
		catch (Exception e){
			System.out.println("Error");
		}
		drawBullets(g);

	}


}
//	private void drawBackGround(Graphics g){
//		g.drawImage(bg, 0, 0, GAME_WIDTH, GAME_HEIGHT, null);
//	}

