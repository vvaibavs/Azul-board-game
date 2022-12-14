import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;

public class StartPanel{
    private BufferedImage menu;
    private BufferedImage start;
    private BufferedImage guideButton;
    public StartPanel() {
        try {
            menu = ImageIO.read(StartPanel.class.getResource("assets/mainmenu.jpg"));
            start = ImageIO.read(StartPanel.class.getResource("assets/start.png"));
            guideButton = ImageIO.read(StartPanel.class.getResource("assets/guide.png"));
        } catch (Exception e) {
            System.out.println("failure");
        }
    }
    public void drawMainMenu(Graphics g) {
         g.drawImage(menu, 0, 0, 1600, 900, null);
         g.drawImage(start, 621, 631, 358, 108, null);
         g.drawImage(guideButton, 700, 750, 200, 75, null);
    }
}
