package main.java;

import java.awt.image.BufferedImage;
    import java.io.IOException;

    import javax.imageio.ImageIO;

    public class PlayerLoader {
        BufferedImage img;
        BufferedImage pi;
        public void loadImage(){
            try {
                img = ImageIO.read(PlayerLoader.class.getResource("Ryu..png"));
               // pi = ImageIO.read(main.java.PlayerLoader.class.getResource("ryunew.png"));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                System.out.println("ERROR IN PLAYER");
            }
        }


        public BufferedImage[] fireAttack(){
            BufferedImage buf [] = new BufferedImage[7];

            buf[0] = img.getSubimage(126,1811,115,90);
            buf[1] = img.getSubimage(3,1812,115,90
            );
            buf[2] = img.getSubimage(254,1812,117,90 );
            buf[3] = img.getSubimage(385,1818,98,85);
            buf[4] = img.getSubimage(490,1817,144,85);
            buf[5] = img.getSubimage(470,1609,114,79);
            buf[6] = img.getSubimage(344,1611,114,77);
            /*buf[7] = img.getSubimage();
            buf[8] = img.getSubimage();
            buf[9] = img.getSubimage();*/
            return buf;

        }

        public BufferedImage[] crouchMoves(){
            BufferedImage buf[] = new BufferedImage[6];
            /*buf[0] = img.getSubimage(917, 527, 78, 106);
            buf[1] = img.getSubimage(814, 544, 86, 88);
            buf[2] = img.getSubimage(703, 559, 89, 77);
            /*buf[3] = img.getSubimage(606, 569, 86, 69);
            buf[4] = img.getSubimage(492, 571, 89, 71);
            buf[5] = img.getSubimage(381, 569, 88, 74);*/

            return buf;
        }

        public BufferedImage[] punchMoves(){
            BufferedImage buf[] = new BufferedImage[3];
            buf[0] = img.getSubimage(107,823,71,94);
            buf[1] = img.getSubimage(190,823,109,93);
            buf[2] = img.getSubimage(310,822,80,93);
            /*buf[3] = img.getSubimage(606, 569, 86, 69);
            buf[4] = img.getSubimage(492, 571, 89, 71);
            buf[5] = img.getSubimage(381, 569, 88, 74);*/

            return buf;
        }







        public BufferedImage[] walkingMoves(){
            BufferedImage buf [] = new BufferedImage[8];
            buf[0] = img.getSubimage(64,238,70,93);
            buf[1] = img.getSubimage(145,236,68,95);
            buf[2] = img.getSubimage(228,236,59,95);
            buf[3] = img.getSubimage(307,236,54,94);
            buf[4] = img.getSubimage(379,237,56,93);
            buf[5] = img.getSubimage(455,241,63,89);
            buf[6] = img.getSubimage(66,347,61,93);
            buf[7] = img.getSubimage(143,346,54,93);
           /* buf[8] = img.getSubimage(221,345,54,95);
            buf[9] = img.getSubimage(292,346,61,95);
            buf[10] = img.getSubimage(369,348,63,93);
            buf[11] = img.getSubimage(456,351,63,89);
            buf[12] = img.getSubimage(37,459,63,89);*/

            return buf;

        }


        public BufferedImage[] standingMoves(){
            BufferedImage buf [] = new BufferedImage[5];
            buf[0] = img.getSubimage(111,127,68,94);
            buf[1] = img.getSubimage(190,127,66,94);
            buf[2] = img.getSubimage(270,128,66,93);
            buf[3] = img.getSubimage(350,127,66,94);
            buf[4] = img.getSubimage(427,125,66,96);
           /* buf[5] = img.getSubimage(506,123,64,98);
            buf[6] = img.getSubimage(66,347,61,93);
            buf[7] = img.getSubimage(143,346,54,93);
            buf[8] = img.getSubimage(221,345,54,95);
            buf[9] = img.getSubimage(292,346,61,95);
            buf[9] = img.getSubimage(369,348,63,93);
            buf[9] = img.getSubimage(456,351,63,89);
            buf[9] = img.getSubimage(37,459,63,89);*/

            return buf;

        }



    }
