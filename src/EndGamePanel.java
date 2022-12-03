import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.TreeSet;
public class EndGamePanel {
    public static boolean end;
    public BufferedImage background;
    public EndGamePanel() {
        try {
            background = ImageIO.read(EndGamePanel.class.getResource("assets/endscreen.jpg"));
        } catch(Exception e) {
            System.out.println("ur a disappointment");
        }
        
        end = false;
    }

    public void endScreen(Graphics g, int p1, int p2, int p3, int p4) {
        g.drawImage(background, 0, 0, 1600, 900, null);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
        g.drawLine(311, 220, 1211, 220);
        g.drawLine(311, 300, 1211, 300);
        g.drawLine(311, 380, 1211, 380);
        g.drawLine(311, 460, 1211, 460);
        g.drawLine(311, 540, 1211, 540);

        ArrayList<Integer> pts = new ArrayList<>();

        pts.add(p1);
        pts.add(p2);
        pts.add(p3);
        pts.add(p4);

        Collections.sort(pts, Collections.reverseOrder());

        if(pts.get(0) == p1) {
            g.drawString("Player 1", 324, 264);
        } else if(pts.get(1) == p1) {
            g.drawString("Player 1", 324, 340);
        } else if(pts.get(2) == p1) {
            g.drawString("Player 1", 324, 423);
        } else if(pts.get(3) == p1) {
            g.drawString("Player 1", 324, 500);
        }

        if(pts.get(0) == p2) {
            g.drawString("Player 2", 324, 264);
        } else if(pts.get(1) == p2) {
            g.drawString("Player 2", 324, 340);
        } else if(pts.get(2) == p2) {
            g.drawString("Player 2", 324, 423);
        } else if(pts.get(3) == p2) {
            g.drawString("Player 2", 324, 500);
        }

        if(pts.get(0) == p3) {
            g.drawString("Player 3", 324, 264);
        } else if(pts.get(1) == p3) {
            g.drawString("Player 3", 324, 340);
        } else if(pts.get(2) == p3) {
            g.drawString("Player 3", 324, 423);
        } else if(pts.get(3) == p3) {
            g.drawString("Player 3", 324, 500);
        }

        if(pts.get(0) == p4) {
            g.drawString("Player 4", 324, 264);
        } else if(pts.get(1) == p4) {
            g.drawString("Player 4", 324, 340);
        } else if(pts.get(2) == p4) {
            g.drawString("Player 4", 324, 423);
        } else if(pts.get(3) == p4) {
            g.drawString("Player 4", 324, 500);
        }
    }
}
