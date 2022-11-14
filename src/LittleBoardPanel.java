import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
public class LittleBoardPanel {
    public BufferedImage bufimg;
    public PlayerPanel player;
    public LittleBoardPanel() {
        try {
            bufimg = new BufferedImage(1600, 900,BufferedImage.TYPE_INT_RGB);
           this.drawBoard(bufimg.createGraphics());
           bufimg = bufimg.getSubimage(0, 350, 500, 500);
        } catch(Exception e) {
            System.out.println("failure");
        }
    }

    public void drawBoard(Graphics g) {
        player = new PlayerPanel();
        if(MainAzul.cnt % 4 == 1) {
            player.p1.pTurn = true;
            player.p4.pTurn = false;
            System.out.println("asdf");
            player.drawBoard(g);
        } else if(MainAzul.cnt % 4 == 2) {
            player.p2.pTurn = true;
            player.p1.pTurn = false;
            player.drawBoard(g);
            System.out.println("hi");
        } else if(MainAzul.cnt % 4 == 3) {
            player.p3.pTurn = true;
            player.p2.pTurn = false;
            System.out.println("hello");
            player.drawBoard(g);
        } else if(MainAzul.cnt % 4 == 0) {
            player.p4.pTurn = true;
            player.p3.pTurn = false;
            System.out.println("bonjour");
            player.drawBoard(g);
        }
        
    }
    
}
