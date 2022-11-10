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
    private BufferedImage background;
    public AzulPanel() {
        main = new MainAzul();
        start = new StartPanel();
        player = new PlayerPanel();
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
        if(main.start) {
            start.drawMainMenu(g);
        } else {
            g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
            if(player.p1.pTurn) {
                player.drawBoard(g);
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
    }
    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        main.mouseX = e.getX();
        main.mouseY = e.getY();
        System.out.println(main.mouseX + " " + main.mouseY);
        if(main.mouseX >= 629 && main.mouseY >= 636 && main.mouseX <= 974 && main.mouseY <= 735) {
            main.start = false;
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
