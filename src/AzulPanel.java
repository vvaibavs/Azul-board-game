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
    private BufferedImage background, black, blue, red, white, yellow,outline,normal;
    public int patternLine;
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
            outline = ImageIO.read(new File("assets/factoryoutline.png"));
            normal = ImageIO.read(new File("assets/default.png"));
        } catch (Exception e) {
            System.out.println("failure");
        }
        player.height = getHeight();
        player.width = getWidth();
        patternLine = 0;
        main = new MainAzul();
        addMouseListener(this);
        addKeyListener(this);
    }
    public void paint(Graphics g) {
        Font fontsmall = new Font("Dialog", Font.PLAIN, 28);  
        g.setFont(fontsmall);
        if(MainAzul.start) {
            start.drawMainMenu(g);
        } else {
            g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
            factory.drawFactories(g);
            factory.drawCenter(g);
            if(player.p1.pTurn) {
                int x = 0;
                int y = 0;
                player.drawBoard(g);
                g.setColor(new Color(0, 168, 178));
                g.fillRect(506, 740, 380, 80);
                g.setColor(Color.BLACK);
                Graphics2D g2 = (Graphics2D) g;
                Stroke oldStroke = g2.getStroke();
                g2.setStroke(new BasicStroke(3));
                g.drawRect(506, 740, 380, 80);
                g.setFont(fontsmall);
                g.drawString("Current Player: 1", 5 , 330); 
                
                if(MainAzul.tempFact == null && player.p1.temp.size() == 0) {
                    g.setFont(fontsmall);
                    g.drawString("click on key corresponding to the number of the factory", 230,  330);
                    
                } else if(MainAzul.tempFact != null) {
                    g.setFont(fontsmall);
                    g.drawString("pick tokens in selected factory", 230,  330);
                    
                    x = MainAzul.tempFact.getX();
                    y = MainAzul.tempFact.getY();
                    g.drawImage(outline, x, y, 220, 220, null);   
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
                   //repaint();
                } else if(player.p1.temp.size() != 0){ 
                    g.setFont(fontsmall);
                    g.drawString("pattern line", 230,  330);
                    

                    if(patternLine != 0) {
                        main.choicePlace(player.p1, patternLine);
                        patternLine = 0;
                    }
                }
                player.drawTokens(g, player.p1);

                if(player.p1.temp.size() != 0) {
                    int posx = 520;
                    int posy = 750;
                    if(x != 0) {
                        g.drawImage(normal, x, y, 220, 220, null);   
                    }
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
                g.setFont(fontsmall);

                player.drawSmallBoard(g, 0);
                player.drawSmallTokens(g, player.p2);
                g.drawString("player 2", 70, 280);

                player.drawSmallBoard(g, 260);
                player.drawSmallTokens2(g, player.p3);
                g.drawString("player 3", 340, 280);

                player.drawSmallBoard(g, 520);
                player.drawSmallTokens3(g, player.p4);
                g.drawString("player 4", 600, 280);

                

            }
            if(player.p2.pTurn) {
                int x = 0;
                int y = 0;
                player.drawBoard(g); 
                g.setColor(new Color(0, 168, 178));
                g.fillRect(506, 740, 380, 80);
                g.setColor(Color.BLACK);
                Graphics2D g2 = (Graphics2D) g;
                g2.setStroke(new BasicStroke(3));
                g.drawRect(506, 740, 380, 80);
                g.setFont(fontsmall);
                g.drawString("Current Player: 2", 5 , 330); 
                if(MainAzul.tempFact == null && player.p2.temp.size() == 0) {
                    g.setFont(fontsmall);
                    g.drawString("click on key corresponding to the number of the factory", 230,  330);
                    
                } else if(MainAzul.tempFact != null) {
                    g.setFont(fontsmall);
                    g.drawString("pick tokens in selected factory", 230,  330);
                    
                    x = MainAzul.tempFact.getX();
                    y = MainAzul.tempFact.getY();
                    g.drawImage(outline, x, y, 220, 220, null);   
                    g.drawImage(outline, x, y, 220, 220, null);   
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
                } else if(player.p2.temp.size() != 0){ 
                    g.setFont(fontsmall);
                    g.drawString("pattern line", 230,  330);
                    

                    if(patternLine != 0) {
                        main.choicePlace(player.p2, patternLine);
                        patternLine = 0;
                    }
                }

                player.drawTokens(g, player.p2);

                if(player.p2.temp.size() != 0) {
                    int posx = 520;
                    int posy = 750;
                    if(x != 0) {
                        g.drawImage(normal, x, y, 220, 220, null);   
                    }
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

                g.setFont(fontsmall);

                player.drawSmallBoard(g, 0);
                player.drawSmallTokens(g, player.p1);
                g.drawString("player 1", 70, 280);

                player.drawSmallBoard(g, 260);
                player.drawSmallTokens2(g, player.p3);
                g.drawString("player 3", 340, 280);

                player.drawSmallBoard(g, 520);
                player.drawSmallTokens3(g, player.p4);
                g.drawString("player 4", 600, 280);

                

            }
            if(player.p3.pTurn) {
                int x = 0;
                int y = 0;
                player.drawBoard(g);
                g.setColor(new Color(0, 168, 178));
                g.fillRect(506, 740, 380, 80);
                g.setColor(Color.BLACK);
                Graphics2D g2 = (Graphics2D) g;
                g2.setStroke(new BasicStroke(3));
                g.drawRect(506, 740, 380, 80);
                g.setFont(fontsmall);
                g.drawString("Current Player: 3", 5 , 330); 
                if(MainAzul.tempFact == null && player.p3.temp.size() == 0) {
                    g.setFont(fontsmall);
                    g.drawString("click on key corresponding to the number of the factory", 230,  330);
                    
                } else if(MainAzul.tempFact != null) {
                    g.drawString("pick tokens in selected factory", 230,  330);
                    x = MainAzul.tempFact.getX();
                    y = MainAzul.tempFact.getY();
                    g.drawImage(outline, x, y, 220, 220, null);   
                    g.drawImage(outline, x, y, 220, 220, null);   
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
                    
                } else if(player.p3.temp.size() != 0){ 
                    g.setFont(fontsmall);
                    g.drawString("pattern line", 230,  330);
                    

                    if(patternLine != 0) {
                        main.choicePlace(player.p3, patternLine);
                        patternLine = 0;
                    }
                }

                player.drawTokens(g, player.p3);

                if(player.p3.temp.size() != 0) {
                    int posx = 520;
                    int posy = 750;
                    if(x != 0) {
                        g.drawImage(normal, x, y, 220, 220, null);   
                    }
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

                g.setFont(fontsmall);

                player.drawSmallBoard(g, 0);
                player.drawSmallTokens(g, player.p1);
                g.drawString("player 1", 70, 280);

                player.drawSmallBoard(g, 260);
                player.drawSmallTokens2(g, player.p2);
                g.drawString("player 2", 340, 280);

                player.drawSmallBoard(g, 520);
                player.drawSmallTokens3(g, player.p4);
                g.drawString("player 4", 600, 280);

                
            }
            if(player.p4.pTurn) {
                g.setFont(fontsmall);
                int x = 0;
                int y = 0;
                player.drawBoard(g);
                g.setColor(new Color(0, 168, 178));
                g.fillRect(506, 740, 380, 80);
                g.setColor(Color.BLACK);
                Graphics2D g2 = (Graphics2D) g;
                g2.setStroke(new BasicStroke(3));
                g.drawRect(506, 740, 380, 80);
                g.setFont(fontsmall);
                g.drawString("Current Player: 4", 5 , 330); 
                if(MainAzul.tempFact == null && player.p4.temp.size() == 0) {
                    g.setFont(fontsmall);
                    g.drawString("click on key corresponding to the number of the factory", 230,  330);
                    
                } else if(MainAzul.tempFact != null) {
                    g.drawString("pick tokens in selected factory", 230,  330);
                    x = MainAzul.tempFact.getX();
                    y = MainAzul.tempFact.getY();
                    g.drawImage(outline, x, y, 220, 220, null);   
                    g.drawImage(outline, x, y, 220, 220, null);  
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
                    
                } else if(player.p4.temp.size() != 0){ 
                    g.setFont(fontsmall);
                    g.drawString("pattern line", 230,  330);
                    

                    if(patternLine != 0) {
                        main.choicePlace(player.p4, patternLine);
                        patternLine = 0;
                    }
                }

                player.drawTokens(g, player.p4);

                if(player.p4.temp.size() != 0) {
                    int posx = 520;
                    int posy = 750;
                    if(x != 0) {
                        g.drawImage(normal, x, y, 220, 220, null);   
                    }
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

                g.setFont(fontsmall);

                player.drawSmallBoard(g, 0);
                player.drawSmallTokens(g, player.p1);
                g.drawString("player 1", 70, 280);

                player.drawSmallBoard(g, 260);
                player.drawSmallTokens2(g, player.p2);
                g.drawString("player 2", 340, 280);

                player.drawSmallBoard(g, 520);
                player.drawSmallTokens3(g, player.p3);
                g.drawString("player 3", 600, 280);

                

            }
        }
        factory.drawTokens(g);
        repaint();

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
        boolean temp = false;
        if(player.p1.pTurn && player.p1.temp.size() == 0) {
            temp = true;
        } else if(player.p2.pTurn && player.p2.temp.size() == 0) {
            temp = true;
        } else if(player.p3.pTurn && player.p3.temp.size() == 0) {
            temp = true;
        } else if(player.p4.pTurn && player.p4.temp.size() == 0) {
            temp = true;
        }
        if(temp) {
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
        } else if(!temp) {
            MainAzul.patternLnChoice = e.getKeyChar() - '0';
            if(MainAzul.patternLnChoice == 1) {
                patternLine = 1;
            } else if(MainAzul.patternLnChoice == 2) {
                patternLine = 2;
            } else if(MainAzul.patternLnChoice == 3) {
                patternLine = 3;
            } else if(MainAzul.patternLnChoice == 4) {
                patternLine = 4;
            } else if(MainAzul.patternLnChoice ==  5) {
                patternLine = 5;
            }
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
