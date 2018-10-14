package main.java;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class EnemyBullet extends Sprite implements GameConstants {
    boolean isVisible;
    BufferedImage img;
    public EnemyBullet(int x, int y){
        this.x = x +120 ;
        this.y = y-40;
        this.speed = 10;
        this.w = this.h= 50;
        this.isVisible = true;
        try {
            img = ImageIO.read(Bullet.class.getResource("ryunew.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block

            System.out.println("Error in main.java.Bullet");
        }
    }
    public void outOfScreen(){
        if(x>=GAME_WIDTH){
            isVisible = false;
        }
    }
    public void move(){
        x+=speed;
        outOfScreen();
    }
    public void drawBullet(Graphics g){
		/*g.setColor(Color.BLACK);
		g.fillOval(x, y, w, h);*/
        BufferedImage n = img.getSubimage(337, 39, 30, 22);
        g.drawImage(n, x,y,w,h, null);
    }
}
