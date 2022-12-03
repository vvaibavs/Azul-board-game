import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;

public class GuidePanel {
    public BufferedImage screen1, screen2, screen3, screen4, screen5;
    public int cnt;

    public GuidePanel() {
        try {
            screen1 = ImageIO.read(new File("assets/screen1.jpg"));
            screen2 = ImageIO.read(new File("assets/screen2.jpg"));
            screen3 = ImageIO.read(new File("assets/screen3.jpg"));
            screen4 = ImageIO.read(new File("assets/screen4.jpg"));
            screen5 = ImageIO.read(new File("assets/screen5.jpg"));
        } catch(Exception e) {
            System.out.println("ur a failure");
        }
        cnt = 0;
    }

    public void drawScreens(Graphics g) {
        if(cnt == 0) {
            g.drawImage(screen1, 0, 0, 1600, 870, null);
        } else if(cnt == 1) {
            g.drawImage(screen2, 0, 0, 1600, 870, null);
        } else if(cnt == 2) {
            g.drawImage(screen3, 0, 0, 1600, 870, null);
        } else if(cnt == 3) {
            g.drawImage(screen4, 0, 0, 1600, 870, null);
        } else if(cnt == 4) {
            g.drawImage(screen5, 0, 0, 1600, 870, null);
        }
        
        if(MainAzul.mouseX >= 265 && MainAzul.mouseY >= 498 && MainAzul.mouseX <= 478 && MainAzul.mouseY <= 579 && cnt == 0) {
            cnt+=1;
            MainAzul.mouseX = 0;
            MainAzul.mouseY = 0;
        } else if(MainAzul.mouseX >= 912 && MainAzul.mouseY >= 412 && MainAzul.mouseX <= 1110 && MainAzul.mouseY <= 500 && cnt == 1) {
            cnt+=1;
            MainAzul.mouseX = 0;
            MainAzul.mouseY = 0;
        } else if(MainAzul.mouseX >= 602 && MainAzul.mouseY >= 389 && MainAzul.mouseX <= 812 && MainAzul.mouseY <= 479 && cnt == 2) {
            cnt+=1;
            MainAzul.mouseX = 0;
            MainAzul.mouseY = 0;
        } else if(MainAzul.mouseX >= 116 && MainAzul.mouseY >= 709 && MainAzul.mouseX <= 293 && MainAzul.mouseY <= 786 && cnt == 3) {
            cnt+=1;
            MainAzul.mouseX = 0;
            MainAzul.mouseY = 0;
        } else if(MainAzul.mouseX >= 329 && MainAzul.mouseY >= 447 && MainAzul.mouseX <= 544 && MainAzul.mouseY <= 543 && cnt == 4) {
            MainAzul.guide = false;
            MainAzul.start = true;
            cnt = 0;
        }

        if(MainAzul.mouseX >= 1508 && MainAzul.mouseY >= 72) {
            MainAzul.guide = false;
            MainAzul.start = true;
            MainAzul.mouseX = 0;
            MainAzul.mouseY = 0;
        }
    }
}
