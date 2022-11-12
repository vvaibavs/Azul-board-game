import javax.swing.*;

import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.awt.event.MouseListener; 
public class AzulPanel extends JPanel implements MouseListener{
    public MainAzul main;
    public StartPanel start;
    public PlayerPanel player;
    public FactoryPanel factory;
    private BufferedImage background;
    public AzulPanel() {
        main = new MainAzul();
        start = new StartPanel();
        player = new PlayerPanel();
        factory = new FactoryPanel();
        try {
            background = ImageIO.read(new File("assets/background.jpg"));
        } catch (Exception e) {
            System.out.println("failure");
        }
        player.height = getHeight();
        player.width = getWidth();

        addMouseListener(this);
    }
    public void paint(Graphics g) {
        Font font = new Font("Serif", Font.PLAIN, 52);
        g.setFont(font);
        if(MainAzul.start) {
            start.drawMainMenu(g);
        } else {
            g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
            factory.drawFactories(g);
            if(player.p1.pTurn) {
                player.drawBoard(g);
                g.drawImage(new LittleBoardPanel().bufimg, 0, 0, 200, 200, null);
                g.drawString("Current Player: 1", 5 , 330); 
            }
            if(player.p2.pTurn) {
                player.drawBoard(g); 
                g.drawString("Current Player: 2", 5 , 330); 
            }
            if(player.p3.pTurn) {
                player.drawBoard(g);
                g.drawString("Current Player: 3", 5 , 330); 
            }
            if(player.p4.pTurn) {
                player.drawBoard(g);
                g.drawString("Current Player: 4", 5 , 330); 
            }
        }
        factory.drawTokens(g);

    }
    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        MainAzul.mouseX = e.getX();
        MainAzul.mouseY = e.getY();
        System.out.println(MainAzul.mouseX + " " + MainAzul.mouseY);
        if(MainAzul.mouseX >= 629 && MainAzul.mouseY >= 636 && MainAzul.mouseX <= 974 && MainAzul.mouseY <= 735) {
            MainAzul.start = false;
        }
        repaint();
    }
    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
}
