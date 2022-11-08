import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;

public class StartPanel{
    private BufferedImage menu;
    private BufferedImage start;
    public StartPanel() {
        try {
            menu = ImageIO.read(new File("Azul/Assets/main menu.jpg"));
            start = ImageIO.read(new File("Azul/Assets/start.png"));
        } catch (Exception e) {
            System.out.println("failure");
        }
    }
    public void drawMainMenu(Graphics g) {
         g.drawImage(menu, 0, 0, 1600, 900, null);
         g.drawImage(start, 621, 631, 358, 108, null);
    }
}
