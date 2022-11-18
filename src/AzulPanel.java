import javax.swing.*;

import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class AzulPanel extends JPanel implements MouseListener, KeyListener{
    public StartPanel start;
    public PlayerPanel player;
    public FactoryPanel factory;
    public MainAzul main;
    public LittleBoardPanel little1, little2, little3, little4;
    private BufferedImage background, black, blue, red, white, yellow;
    public AzulPanel() {

        start = new StartPanel();
        player = new PlayerPanel();
        factory = new FactoryPanel();
        try {
            background = ImageIO.read(new File("assets/background.jpg"));
            black = ImageIO.read(new File("assets/black.jpg"));
            blue = ImageIO.read(new File("assets/blue.jpg"));
            red = ImageIO.read(new File("assets/red.jpg"));
            white = ImageIO.read(new File("assets/white.jpg"));
            yellow = ImageIO.read(new File("assets/yellow.jpg"));
        } catch (Exception e) {
            System.out.println("failure");
        }
        player.height = getHeight();
        player.width = getWidth();
        main = new MainAzul();
        addMouseListener(this);
        addKeyListener(this);
    }
    public void paint(Graphics g) {
        Font fontbig = new Font("Serif", Font.PLAIN, 52);  
        Font fontsmall = new Font("Serif", Font.PLAIN, 32);  
        g.setFont(fontbig);
        if(MainAzul.start) {
            start.drawMainMenu(g);
        } else {
            g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
            factory.drawFactories(g);
            factory.drawCenter(g);
            if(player.p1.pTurn) {
                player.drawBoard(g);
                g.setColor(new Color(0, 168, 178));
                g.fillRect(506, 740, 380, 80);
                g.setColor(Color.BLACK);
                Graphics2D g2 = (Graphics2D) g;
                Stroke oldStroke = g2.getStroke();
                g2.setStroke(new BasicStroke(3));
                g.drawRect(506, 740, 380, 80);
                
                g.drawString("Current Player: 1", 5 , 330); 
                if(MainAzul.tempFact != null) {
                    g.drawString("pick tokens in selected factory", 0,  280);
                    int x = MainAzul.tempFact.getX();
                    int y = MainAzul.tempFact.getY();
                    if(MainAzul.mouseX >= x+25 && MainAzul.mouseY >= y+65 && MainAzul.mouseX <= x+75 && MainAzul.mouseY <= y+105) { // add the if statements from choice pull in here
                        main.choicePull(player.p1, "black");
                    } else if(MainAzul.mouseX >= x+90 && MainAzul.mouseY >= y+25 && MainAzul.mouseX <= x+140 && MainAzul.mouseY <= y+75) {
                        main.choicePull(player.p1, "blue");
                    } else if(MainAzul.mouseX >= x+155 && MainAzul.mouseY >= y+65 && MainAzul.mouseX <= x+205 && MainAzul.mouseY <= y+105) {
                        main.choicePull(player.p1, "red");
                    } else if(MainAzul.mouseX >= x+55 && MainAzul.mouseY >= y+135 && MainAzul.mouseX <= x+105 && MainAzul.mouseY <= y+185) {
                        main.choicePull(player.p1, "white");
                    } else if(MainAzul.mouseX >= x+135 && MainAzul.mouseY >= y+135 && MainAzul.mouseX <= x+185 && MainAzul.mouseY <= y+185) {
                        main.choicePull(player.p1, "yellow");
                    }
                   
                } else { 
                    g.setFont(fontsmall);
                    g.drawString("click on key corresponding to the number of the factory", 0,  280);
                    g.setFont(fontbig);
                }

                if(player.p1.temp.size() != 0) {
                    int posx = 520;
                    int posy = 750;

                    for(int i = 0; i < player.p1.temp.size(); i++) {
                        if(player.p1.temp.get(i).type.equals("black")) {
                            g.drawImage(black, posx, posy, 60, 60, null);
                            posx += 70;
                        } else if(player.p1.temp.get(i).type.equals("blue")) {
                            g.drawImage(blue, posx, posy, 60, 60, null);
                            posx += 70;
                        } else if(player.p1.temp.get(i).type.equals("red")) {
                            g.drawImage(red, posx, posy, 60, 60, null);
                            posx += 70;
                        } else if(player.p1.temp.get(i).type.equals("white")) {
                            g.drawImage(white, posx, posy, 60, 60, null);
                            posx += 70;
                        } else if(player.p1.temp.get(i).type.equals("yellow")) {
                            g.drawImage(yellow, posx, posy, 60, 60, null);
                            posx += 70;
                        }
                        
                    }
                }

            }
            if(player.p2.pTurn) {
                player.drawBoard(g); 
                g.setColor(new Color(0, 168, 178));
                g.fillRect(506, 740, 380, 80);
                g.setColor(Color.BLACK);
                Graphics2D g2 = (Graphics2D) g;
                g2.setStroke(new BasicStroke(3));
                g.drawRect(506, 740, 380, 80);

                g.drawString("Current Player: 2", 5 , 330); 
                if(MainAzul.tempFact != null) {
                    g.drawString("pick tokens in selected factory", 0,  280);
                    int x = MainAzul.tempFact.getX();
                    int y = MainAzul.tempFact.getY();
                    if(MainAzul.mouseX >= x+25 && MainAzul.mouseY >= y+65 && MainAzul.mouseX <= x+75 && MainAzul.mouseY <= y+105) { // add the if statements from choice pull in here
                        main.choicePull(player.p2, "black");
                    } else if(MainAzul.mouseX >= x+90 && MainAzul.mouseY >= y+25 && MainAzul.mouseX <= x+140 && MainAzul.mouseY <= y+75) {
                        main.choicePull(player.p2, "blue");
                    } else if(MainAzul.mouseX >= x+155 && MainAzul.mouseY >= y+65 && MainAzul.mouseX <= x+205 && MainAzul.mouseY <= y+105) {
                        main.choicePull(player.p2, "red");
                    } else if(MainAzul.mouseX >= x+55 && MainAzul.mouseY >= y+135 && MainAzul.mouseX <= x+105 && MainAzul.mouseY <= y+185) {
                        main.choicePull(player.p2, "white");
                    } else if(MainAzul.mouseX >= x+135 && MainAzul.mouseY >= y+135 && MainAzul.mouseX <= x+185 && MainAzul.mouseY <= y+185) {
                        main.choicePull(player.p2, "yellow");
                    }
                }else { 
                    g.setFont(fontsmall);
                    g.drawString("click on key corresponding to the number of the factory", 0,  280);
                    g.setFont(fontbig);
                }

                if(player.p2.temp.size() != 0) {
                    int posx = 520;
                    int posy = 750;

                    for(int i = 0; i < player.p2.temp.size(); i++) {
                        if(player.p2.temp.get(i).type.equals("black")) {
                            g.drawImage(black, posx, posy, 60, 60, null);
                            posx += 70;
                        } else if(player.p2.temp.get(i).type.equals("blue")) {
                            g.drawImage(blue, posx, posy, 60, 60, null);
                            posx += 70;
                        } else if(player.p2.temp.get(i).type.equals("red")) {
                            g.drawImage(red, posx, posy, 60, 60, null);
                            posx += 70;
                        } else if(player.p2.temp.get(i).type.equals("white")) {
                            g.drawImage(white, posx, posy, 60, 60, null);
                            posx += 70;
                        } else if(player.p2.temp.get(i).type.equals("yellow")) {
                            g.drawImage(yellow, posx, posy, 60, 60, null);
                            posx += 70;
                        }
                        
                    }
                }
            }
            if(player.p3.pTurn) {
                player.drawBoard(g);
                g.setColor(new Color(0, 168, 178));
                g.fillRect(506, 740, 380, 80);
                g.setColor(Color.BLACK);
                Graphics2D g2 = (Graphics2D) g;
                g2.setStroke(new BasicStroke(3));
                g.drawRect(506, 740, 380, 80);
                
                g.drawString("Current Player: 3", 5 , 330); 
                if(MainAzul.tempFact != null) {
                    g.drawString("pick tokens in selected factory", 0,  280);
                    int x = MainAzul.tempFact.getX();
                    int y = MainAzul.tempFact.getY();
                    if(MainAzul.mouseX >= x+25 && MainAzul.mouseY >= y+65 && MainAzul.mouseX <= x+75 && MainAzul.mouseY <= y+105) { // add the if statements from choice pull in here
                        main.choicePull(player.p3, "black");
                    } else if(MainAzul.mouseX >= x+90 && MainAzul.mouseY >= y+25 && MainAzul.mouseX <= x+140 && MainAzul.mouseY <= y+75) {
                        main.choicePull(player.p3, "blue");
                    } else if(MainAzul.mouseX >= x+155 && MainAzul.mouseY >= y+65 && MainAzul.mouseX <= x+205 && MainAzul.mouseY <= y+105) {
                        main.choicePull(player.p3, "red");
                    } else if(MainAzul.mouseX >= x+55 && MainAzul.mouseY >= y+135 && MainAzul.mouseX <= x+105 && MainAzul.mouseY <= y+185) {
                        main.choicePull(player.p3, "white");
                    } else if(MainAzul.mouseX >= x+135 && MainAzul.mouseY >= y+135 && MainAzul.mouseX <= x+185 && MainAzul.mouseY <= y+185) {
                        main.choicePull(player.p3, "yellow");
                    }
                    
                } else { 
                    g.setFont(fontsmall);
                    g.drawString("click on key corresponding to the number of the factory", 0,  280);
                    g.setFont(fontbig);
                }

                if(player.p3.temp.size() != 0) {
                    int posx = 520;
                    int posy = 750;

                    for(int i = 0; i < player.p3.temp.size(); i++) {
                        if(player.p3.temp.get(i).type.equals("black")) {
                            g.drawImage(black, posx, posy, 60, 60, null);
                            posx += 70;
                        } else if(player.p3.temp.get(i).type.equals("blue")) {
                            g.drawImage(blue, posx, posy, 60, 60, null);
                            posx += 70;
                        } else if(player.p3.temp.get(i).type.equals("red")) {
                            g.drawImage(red, posx, posy, 60, 60, null);
                            posx += 70;
                        } else if(player.p3.temp.get(i).type.equals("white")) {
                            g.drawImage(white, posx, posy, 60, 60, null);
                            posx += 70;
                        } else if(player.p3.temp.get(i).type.equals("yellow")) {
                            g.drawImage(yellow, posx, posy, 60, 60, null);
                            posx += 70;
                        }
                        
                    }
                }
            }
            if(player.p4.pTurn) {
                player.drawBoard(g);
                g.setColor(new Color(0, 168, 178));
                g.fillRect(506, 740, 380, 80);
                g.setColor(Color.BLACK);
                Graphics2D g2 = (Graphics2D) g;
                g2.setStroke(new BasicStroke(3));
                g.drawRect(506, 740, 380, 80);

                g.drawString("Current Player: 4", 5 , 330); 
                if(MainAzul.tempFact != null) {
                    g.drawString("pick tokens in selected factory", 0,  280);
                    int x = MainAzul.tempFact.getX();
                    int y = MainAzul.tempFact.getY();
                    if(MainAzul.mouseX >= x+25 && MainAzul.mouseY >= y+65 && MainAzul.mouseX <= x+75 && MainAzul.mouseY <= y+105) { // add the if statements from choice pull in here
                        main.choicePull(player.p4, "black");
                    } else if(MainAzul.mouseX >= x+90 && MainAzul.mouseY >= y+25 && MainAzul.mouseX <= x+140 && MainAzul.mouseY <= y+75) {
                        main.choicePull(player.p4, "blue");
                    } else if(MainAzul.mouseX >= x+155 && MainAzul.mouseY >= y+65 && MainAzul.mouseX <= x+205 && MainAzul.mouseY <= y+105) {
                        main.choicePull(player.p4, "red");
                    } else if(MainAzul.mouseX >= x+55 && MainAzul.mouseY >= y+135 && MainAzul.mouseX <= x+105 && MainAzul.mouseY <= y+185) {
                        main.choicePull(player.p4, "white");
                    } else if(MainAzul.mouseX >= x+135 && MainAzul.mouseY >= y+135 && MainAzul.mouseX <= x+185 && MainAzul.mouseY <= y+185) {
                        main.choicePull(player.p4, "yellow");
                    }
                    
                } else { 
                    g.setFont(fontsmall);
                    g.drawString("click on key corresponding to the number of the factory", 0,  280);
                    g.setFont(fontbig);
                }

                if(player.p4.temp.size() != 0) {
                    int posx = 520;
                    int posy = 750;

                    for(int i = 0; i < player.p4.temp.size(); i++) {
                        if(player.p4.temp.get(i).type.equals("black")) {
                            g.drawImage(black, posx, posy, 60, 60, null);
                            posx += 70;
                        } else if(player.p4.temp.get(i).type.equals("blue")) {
                            g.drawImage(blue, posx, posy, 60, 60, null);
                            posx += 70;
                        } else if(player.p4.temp.get(i).type.equals("red")) {
                            g.drawImage(red, posx, posy, 60, 60, null);
                            posx += 70;
                        } else if(player.p4.temp.get(i).type.equals("white")) {
                            g.drawImage(white, posx, posy, 60, 60, null);
                            posx += 70;
                        } else if(player.p4.temp.get(i).type.equals("yellow")) {
                            g.drawImage(yellow, posx, posy, 60, 60, null);
                            posx += 70;
                        }
                        
                    }
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
    @Override
    public void keyTyped(KeyEvent e) {
        MainAzul.choice = e.getKeyChar() - '0';
        if(MainAzul.choice == 1) {
            MainAzul.tempFact = factory.f1;
            System.out.println("f1");
        } else if(MainAzul.choice == 2) {
            System.out.println("f2");
            MainAzul.tempFact = factory.f2;
        } else if(MainAzul.choice == 3) {
            System.out.println("f3");
            MainAzul.tempFact = factory.f3;
        } else if(MainAzul.choice == 4) {
            System.out.println("f4");
            MainAzul.tempFact = factory.f4;
        } else if(MainAzul.choice == 5) {
            System.out.println("f5");
            MainAzul.tempFact = factory.f5;
        } else if(MainAzul.choice == 6) {
            System.out.println("f6");
            MainAzul.tempFact = factory.f6;
        } else if(MainAzul.choice == 7) {
            System.out.println("f7");
            MainAzul.tempFact = factory.f7;
        } else if(MainAzul.choice == 8) {
            System.out.println("f8");
            MainAzul.tempFact = factory.f8;
        } else if(MainAzul.choice == 9) {
            System.out.println("f9");
            MainAzul.tempFact = factory.f9;
        }
        repaint();
    }
    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    public void addNotify() {
        super.addNotify();
        requestFocus();
    }
}
