package streetfighter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Bullet extends Sprite implements GameConstants {
    boolean isVisible;
    BufferedImage img;
    public Bullet(int x, int y){
        this.x = x +120 ;
        this.y = y-40;
        this.speed = 10;
        this.w = this.h= 50;
        this.isVisible = true;
        try {
            img = ImageIO.read(Bullet.class.getResource("ryunew.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block

            System.out.println("Error in streetfighter.Bullet");
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
