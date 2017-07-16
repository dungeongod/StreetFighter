
import com.sun.media.jfxmedia.events.PlayerStateEvent;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Player extends Sprite implements GameConstants,PlayerState {
    ArrayList<Bullet> bulletList = new ArrayList<>();
    private boolean isJump ;
    private int acc;
    PlayerLoader sl = new PlayerLoader();
    BufferedImage moves[];
    BufferedImage fireAttack[];
    BufferedImage crouchMoves[];
    BufferedImage walkMoves[];
    BufferedImage punchmoves[];
    int currentState ;

    public void drawPlayer(Graphics g){
        if(currentState==PlayerState.MOVE){
            drawStandingMoves(g);
        }
        else
        if(currentState == PlayerState.FIRE_ATTACK){
            drawFireAttack(g);
        }
        else
        if(currentState == PlayerState.CROUCH){
            drawCrouchMoves(g);
        }
        else
            if(currentState ==PlayerState.WALK){
            drawWalkMoves(g);
            }
            else
                if(currentState == PlayerState.PUNCH){
                drawPunchMoves(g);
                }
    }

    public Player(){
        currentState = PlayerState.MOVE;
        sl.loadImage();
        moves  = sl.standingMoves();
        fireAttack = sl.fireAttack();
        crouchMoves = sl.crouchMoves();
        walkMoves = sl.walkingMoves();
        punchmoves = sl.punchMoves();
        x = 122;
        w = 100;
        h = 180;
        y = FLOOR - (h-10);

       // img = new ImageIcon(Player.class.getResource(PLAYER_IMG)).getImage();
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
       // int p=h-50;
        g.drawImage(fireAttack[fireCount], x, y+20, w+100,
                h-20, null);


        fireCount++;
        //move();
        if(fireCount>=7){
            fireCount=0;
            //speed = 0;

            fire();
            currentState = MOVE;
        }
    }

    int moveCount;
    public void drawStandingMoves(Graphics g){
        currentState = PlayerState.MOVE;
        fireCount = 0;
        //crouchCount = 0;
        g.drawImage(moves[moveCount], x, y, w, h, null);

        moveCount++;
        if(moveCount>=5){
            moveCount=0;
        }
    }

    public void setCrouch(){
        currentState = PlayerState.CROUCH;
        moveCount = 0;
        crouchCount = 0;
        fireCount = 0;

    }

    int crouchCount;
    public void drawCrouchMoves(Graphics g){
        currentState = PlayerState.CROUCH;
        moveCount = 0;
        try{
            g.drawImage(crouchMoves[crouchCount], x, y+20, w,h-20,null);
        }
        catch(Exception e){
            System.out.println("Error in Crouch");
        }
        crouchCount++;
        if(crouchCount>=3){
            crouchCount = 0;
            currentState = MOVE;
        }
    }

    public void setWalkMoves(){
        currentState = PlayerState.WALK;
        moveCount = 0;
        crouchCount = 0;
        fireCount = 0;
        walkCount = 0;
    }

    int walkCount;
    public void drawWalkMoves(Graphics g){
        currentState = WALK;
        moveCount = 0;
        fireCount = 0;
        crouchCount = 0;
        try{

            g.drawImage(walkMoves[walkCount], x, y,w,h,null);
        }
        catch(Exception e){
            System.out.println("Error in Crouch");
        }
        walkCount++;
        if(walkCount>=8){
            walkCount = 0;
            currentState = MOVE;
        }
    }

    public void setPunchMoves(){
        currentState = PUNCH;
        moveCount =0;
        fireCount = 0;
        crouchCount = 0;
    }

    int punchCount;
    public void drawPunchMoves(Graphics g){
     currentState = PUNCH;
        moveCount = 0;
        fireCount = 0;
        crouchCount = 0;

        g.drawImage(punchmoves[punchCount], x,y, w+70,h, null);


        punchCount++;
        //move();
        if(punchCount>=3){
            punchCount=0;
            currentState = MOVE;
        }
    }




    public void fire(){

        Bullet bullet = new Bullet(x + w/2, y + h /2);
        bulletList.add(bullet);
    }

    //	public void drawPlayer(Graphics g){
//		g.drawImage(img, x, y, w, h, null);
//	}
    public void move()
    {
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
