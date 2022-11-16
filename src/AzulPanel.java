import javax.swing.*;

import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.awt.event.MouseListener; 
public class AzulPanel extends JPanel implements MouseListener{
    public StartPanel start;
    public PlayerPanel player;
    public FactoryPanel factory;
    public MainAzul main;
    public LittleBoardPanel little1, little2, little3, little4;
    private BufferedImage background;
    public AzulPanel() {

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
        main = new MainAzul();
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
            factory.drawCenter(g);
            if(player.p1.pTurn) {
                player.drawBoard(g);
                
                g.drawString("Current Player: 1", 5 , 330); 
                if(MainAzul.tempFact != null) {
                    g.drawString("pick tokens", 0,  280);
                    main.choicePull(player.p1);
                } else { 
                    g.drawString("pick factory", 0,  280);
                }

            }
            if(player.p2.pTurn) {
                player.drawBoard(g); 
                
                g.drawString("Current Player: 2", 5 , 330); 
                if(MainAzul.tempFact != null) {
                    g.drawString("pick tokens", 0,  280);
                    main.choicePull(player.p2);
                } else { 
                    g.drawString("pick factory", 0,  280);
                }
            }
            if(player.p3.pTurn) {
                player.drawBoard(g);
                
                g.drawString("Current Player: 3", 5 , 330); 
                if(MainAzul.tempFact != null) {
                    g.drawString("pick tokens", 0,  280);
                    main.choicePull(player.p3);
                } else { 
                    g.drawString("pick factory", 0,  280);
                }
            }
            if(player.p4.pTurn) {
                player.drawBoard(g);
                g.drawString("Current Player: 4", 5 , 330); 
                if(MainAzul.tempFact != null) {
                    g.drawString("pick tokens", 0,  280);
                    main.choicePull(player.p4);
                } else { 
                 g.drawString("pick factory", 0,  280);
                }
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
        } else if(MainAzul.mouseX >= 1477 && MainAzul.mouseY >= 763 && MainAzul.mouseX <= 1600 && MainAzul.mouseY <= 900) {
            MainAzul.nextPlayer(player.p1, player.p2, player.p3, player.p4);
        } else if(!MainAzul.start && MainAzul.tempFact == null && MainAzul.mouseX >= 1020 && MainAzul.mouseY >= 0 && MainAzul.mouseX <= 1240 && MainAzul.mouseY <= 220) {
            MainAzul.tempFact = factory.f1;
            System.out.println("f1");
        } else if(!MainAzul.start && MainAzul.tempFact == null && MainAzul.mouseX >= 1255 && MainAzul.mouseY >= 75 && MainAzul.mouseX <= 1475 && MainAzul.mouseY <= 295) {
            System.out.println("f2");
            MainAzul.tempFact = factory.f2;
        } else if(!MainAzul.start && MainAzul.tempFact == null && MainAzul.mouseX >= 1360 && MainAzul.mouseY >= 290 && MainAzul.mouseX <= 1360 + 220 && MainAzul.mouseY <= 510) {
            System.out.println("f3");
            MainAzul.tempFact = factory.f3;
        } else if(!MainAzul.start && MainAzul.tempFact == null && MainAzul.mouseX >= 1330 && MainAzul.mouseY >= 520 && MainAzul.mouseX <= 1330 + 220 && MainAzul.mouseY <= 520 + 220) {
            System.out.println("f4");
            MainAzul.tempFact = factory.f4;
        } else if(!MainAzul.start && MainAzul.tempFact == null && MainAzul.mouseX >= 1130 && MainAzul.mouseY >= 650 && MainAzul.mouseX <= 1130 + 220 && MainAzul.mouseY <= 650 + 220) {
            System.out.println("f5");
            MainAzul.tempFact = factory.f5;
        } else if(!MainAzul.start && MainAzul.tempFact == null && MainAzul.mouseX >= 900 && MainAzul.mouseY >= 650 && MainAzul.mouseX <= 900 + 220 && MainAzul.mouseY <= 650 + 220) {
            System.out.println("f6");
            MainAzul.tempFact = factory.f6;
        } else if(!MainAzul.start && MainAzul.tempFact == null && MainAzul.mouseX >= 710 && MainAzul.mouseY >= 520 && MainAzul.mouseX <= 710 + 220 && MainAzul.mouseY <= 520 + 220) {
            System.out.println("f7");
            MainAzul.tempFact = factory.f7;
        } else if(!MainAzul.start && MainAzul.tempFact == null && MainAzul.mouseX >= 690 && MainAzul.mouseY >= 290 && MainAzul.mouseX <= 690 + 220 && MainAzul.mouseY <= 290 + 220) {
            System.out.println("f8");
            MainAzul.tempFact = factory.f8;
        } else if(!MainAzul.start && MainAzul.tempFact == null && MainAzul.mouseX >= 785 && MainAzul.mouseY >= 75 && MainAzul.mouseX <= 785 + 220 && MainAzul.mouseY <= 75 + 220) {
            System.out.println("f9");
            MainAzul.tempFact = factory.f9;
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
