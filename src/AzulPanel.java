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
    public AzulPanel() {
        main = new MainAzul();
        start = new StartPanel();
        addMouseListener(this);
    }
    public void paint(Graphics g) {
        if(main.start) {
            start.drawMainMenu(g);
        }
    }
    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        main.mouseX = e.getX();
        main.mouseY = e.getY();
        System.out.println(main.mouseX + " " + main.mouseY);
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
