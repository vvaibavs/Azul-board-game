import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;

public class StartPanel{
    private BufferedImage menu;
    public StartPanel() {
        try {
            menu = ImageIO.read(AzulPanel.class.getResource("/Azul/Assets/main menu.jpg"));
        } catch (Exception e) {
            System.out.println("failure");
        }
    }
    public void drawMainMenu(Graphics g) {
        // g.drawImage(menu, 0, 0, 1600, 900, null);
    }
}
