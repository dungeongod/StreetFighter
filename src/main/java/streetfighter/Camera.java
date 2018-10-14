package main.java;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Camera implements GameConstants {
    int x;
    int y;
    int h;
    int w;
    int speed;
    BufferedImage bi;

    public Camera(){
        speed = 5;
        try{
            bi = ImageIO.read(Camera.class.getResource(BACKGROUND));
        }
        catch(Exception e){
            System.out.println("Game Would n't Work Someone Delete the BackGround...");
            System.out.println("Thanks for Using");
            System.exit(0);
            //bi = ImageIO.read(main.java.Camera.class.getResource("bg2.jpg"));
            //JOptionPane.showMessageDialog(frame,"Game Would n't Work Someone Delete the BackGround...");
        }
    }

    public void left(){
        if(x>0){
            speed = -5;
        }
        else{
            speed = 0;
        }
    }

    public void right(){
        if(x<1280-GAME_WIDTH){
            speed = 5;
            //move();
        }

    }

    public void move(){
        x+=speed;
    }

    public void drawBG(Graphics g){
        BufferedImage subImage = bi.getSubimage(x, y, GAME_WIDTH, GAME_HEIGHT);
        System.out.println("X "+x+" Y "+y );
        g.drawImage(subImage,0,0,GAME_WIDTH,GAME_HEIGHT,null);
    }


}
