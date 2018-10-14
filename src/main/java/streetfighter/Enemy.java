package main.java;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Enemy extends Sprite implements GameConstants,EnemyState {
    ArrayList<Bullet> enemyBulletList = new ArrayList<>();
    private boolean isJump ;
    private int acc;
    EnemyLoader el = new EnemyLoader();
    BufferedImage moves[];
    BufferedImage fireAttack[];
    BufferedImage crouchMoves[];
    int currentState ;

    public void drawEnemy(Graphics g) {
        if(currentState==EnemyState.MOVE){
        drawStandingMoves(g);
    }
        else
        if(currentState == EnemyState.FIRE_ATTACK){
            drawFireAttack(g);
        }
        else
        if(currentState == EnemyState.CROUCH){
           drawCrouchMoves(g);
        }
    }

    public Enemy(){
        currentState = EnemyState.MOVE;
        el.loadImage();
        moves  = el.standingMoves();
        fireAttack = el.fireAttack();
        crouchMoves = el.crouchMoves();

        x = 500;
        w = 100;
        h = 150;
        y = FLOOR - (h-10);

        // img = new ImageIcon(main.java.Player.class.getResource(PLAYER_IMG)).getImage();
    }


    public void setFireAttack(){
        currentState = FIRE_ATTACK;
        moveCount =0;
        fireCount = 0;
        crouchCount = 0;
    }
    int fireCount;
    public void drawFireAttack(Graphics g){
        speed = 10;
        int p=h-50;
        g.drawImage(fireAttack[fireCount], x, y, w, h, null);


        fireCount++;
        //move();
        if(fireCount>=7){
            fireCount=0;
            //speed = 0;
            currentState = MOVE;
        }
    }

    int moveCount;
    public void drawStandingMoves(Graphics g){
        BufferedImage i = null;
        currentState = EnemyState.MOVE;
        fireCount = 0;
        //crouchCount = 0;
        try {
            i = ImageIO.read(Enemy.class.getResource("Ryurev.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(i, x, y, w, h, null);

        moveCount++;
        if(moveCount>=6){
            moveCount=0;
        }
    }
    public void setCrouch(){
        currentState = EnemyState.CROUCH;
        moveCount = 0;
        crouchCount = 0;
        fireCount = 0;

    }

    int crouchCount;
    public void drawCrouchMoves(Graphics g){
        currentState = Player.CROUCH;
        moveCount = 0;
        try{

            g.drawImage(crouchMoves[crouchCount], x, y+20, w,h-20,null);
        }
        catch(Exception e){
            System.out.println("Error in Crouch");
        }
        crouchCount++;
        if(crouchCount>=6){
            crouchCount = 0;
            currentState = MOVE;
        }
    }

   /* public void fire(){
        main.java.EnemyBullet bullet = new main.java.EnemyBullet(x + w/2, y + h /2);
        enemyBulletList.add(bullet);
    }
*/
    //	public void drawPlayer(Graphics g){
//		g.drawImage(img, x, y, w, h, null);
//	}
    public void move(){
        x += speed;
    }

    public void jump(){
        if(!isJump){
            acc = -20;
            y = y + acc;
            isJump = true;
        }
    }
    public void fall(){
        if(y<(FLOOR - (h-22))){
            acc = acc + GRAVITY;
            y = y + acc;
        }
        if(y>=(FLOOR - (h-22))){
            isJump = false;
        }
    }
}
