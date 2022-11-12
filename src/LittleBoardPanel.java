import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
public class LittleBoardPanel {
    public BufferedImage bufimg;
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
        new PlayerPanel().drawBoard(g);
    }
    
}
