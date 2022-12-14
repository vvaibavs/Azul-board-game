import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.util.ArrayList;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class AzulPanel extends JPanel implements MouseListener, KeyListener{
    public StartPanel start;
    public PlayerPanel player;
    public FactoryPanel factory;
    public EndGamePanel end;
    public MainAzul main;
    private BufferedImage background, black, blue, red, white, yellow,outline,normal, next, reset;
    public int patternLine;
    public GuidePanel guide;
    public AzulPanel() {

        start = new StartPanel();
        player = new PlayerPanel();
        factory = new FactoryPanel();
        guide = new GuidePanel();
        end = new EndGamePanel();
        try {
            background = ImageIO.read(AzulPanel.class.getResource("assets/background.jpg"));
            black = ImageIO.read(AzulPanel.class.getResource("assets/black.jpg"));
            blue = ImageIO.read(AzulPanel.class.getResource("assets/blue.jpg"));
            red = ImageIO.read(AzulPanel.class.getResource("assets/red.jpg"));
            white = ImageIO.read(AzulPanel.class.getResource("assets/white.jpg"));
            yellow = ImageIO.read(AzulPanel.class.getResource("assets/yellow.jpg"));
            outline = ImageIO.read(AzulPanel.class.getResource("assets/factoryoutline.png"));
            normal = ImageIO.read(AzulPanel.class.getResource("assets/default.png"));
            next = ImageIO.read(AzulPanel.class.getResource("assets/Next-Button-Transparent-Image.png"));
            reset = ImageIO.read(AzulPanel.class.getResource("assets/reset.png"));
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
            if(MainAzul.mouseX >= 700 && MainAzul.mouseY >= 750 && MainAzul.mouseX <= 895 && MainAzul.mouseY <= 818) {
                MainAzul.start = false;
                MainAzul.guide = true;
            }
        } else if(MainAzul.guide) {
            guide.drawScreens(g);
            if(MainAzul.mouseX >= 1508 && MainAzul.mouseY >= 0 && MainAzul.mouseX <= 1600 && MainAzul.mouseY <= 72) {
                MainAzul.guide = false;
                MainAzul.start = true;
                MainAzul.mouseX = 0;
                MainAzul.mouseY = 0;
            }
        } else if(MainAzul.game){
            g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
            factory.drawFactories(g);
            factory.drawCenter(g);
            g.drawImage(next, 1430, 763, 200, 100, null);
            if(player.p1.pTurn) {
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
                g.drawString("Current Player: 1", 5 , 330); 
                
                if(MainAzul.tempFact == null && player.p1.temp.size() == 0) {
                    g.setFont(fontsmall);
                    g.drawString("use number keys to choose factories", 230,  330);
                    
                } else if(MainAzul.tempFact != null) {
                    g.setFont(fontsmall);
                    g.drawString("pick tokens with mouse in selected factory", 230,  330);
                    
                    x = MainAzul.tempFact.getX();
                    y = MainAzul.tempFact.getY();
                    g.drawImage(outline, x, y, 220, 220, null);   
                    if(MainAzul.mouseX >= x+25 && MainAzul.mouseY >= y+65 && MainAzul.mouseX <= x+75 && MainAzul.mouseY <= y+105) { // add the if statements from choice pull in here
                        main.choicePull(player.p1, "black");
                        MainAzul.player1 = false;
                        MainAzul.player2 = true;
                    } else if(MainAzul.mouseX >= x+90 && MainAzul.mouseY >= y+25 && MainAzul.mouseX <= x+140 && MainAzul.mouseY <= y+75) {
                        main.choicePull(player.p1, "blue");
                        MainAzul.player1 = false;
                        MainAzul.player2 = true;
                    } else if(MainAzul.mouseX >= x+155 && MainAzul.mouseY >= y+65 && MainAzul.mouseX <= x+205 && MainAzul.mouseY <= y+105) {
                        main.choicePull(player.p1, "red");
                        MainAzul.player1 = false;
                        MainAzul.player2 = true;
                    } else if(MainAzul.mouseX >= x+55 && MainAzul.mouseY >= y+135 && MainAzul.mouseX <= x+105 && MainAzul.mouseY <= y+185) {
                        main.choicePull(player.p1, "white");
                        MainAzul.player1 = false;
                        MainAzul.player2 = true;
                    } else if(MainAzul.mouseX >= x+135 && MainAzul.mouseY >= y+135 && MainAzul.mouseX <= x+185 && MainAzul.mouseY <= y+185) {
                        main.choicePull(player.p1, "yellow");
                        MainAzul.player1 = false;
                        MainAzul.player2 = true;
                    }
                    MainAzul.player1 = false;
                } else if(player.p1.temp.size() != 0){ 
                    g.setFont(fontsmall);
                    g.drawString("use number keys to select pattern line", 230,  330);
                    

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

                if(factory.factEmpty() && factory.center.size() == 0) {
                    g.drawImage(reset, 530, 380, 60, 60, null);
                    if(MainAzul.mouseX >= 530 && MainAzul.mouseY >= 380 && MainAzul.mouseX <= 590 && MainAzul.mouseY <= 440) {
                        if(player.p1.patternLn[0].size() == 1) {
                            main.moveTokens(1, player.p1);
                        }
                        if(player.p1.patternLn[1].size() == 2) {
                            main.moveTokens(2, player.p1);
                        }
                        if(player.p1.patternLn[2].size() == 3) {
                            main.moveTokens(3, player.p1);
                        }
                        if(player.p1.patternLn[3].size() == 4) {
                            main.moveTokens(4, player.p1);
                        }
                        if(player.p1.patternLn[4].size() == 5) {
                            main.moveTokens(5, player.p1);
                        }

                        if(player.p2.patternLn[0].size() == 1) {
                            main.moveTokens(1, player.p2);
                        }
                        if(player.p2.patternLn[1].size() == 2) {
                            main.moveTokens(2, player.p2);
                        }
                        if(player.p2.patternLn[2].size() == 3) {
                            main.moveTokens(3, player.p2);
                        }
                        if(player.p2.patternLn[3].size() == 4) {
                            main.moveTokens(4, player.p2);
                        }
                        if(player.p2.patternLn[4].size() == 5) {
                            main.moveTokens(5, player.p2);
                        }

                        if(player.p3.patternLn[0].size() == 1) {
                            main.moveTokens(1, player.p3);
                        }
                        if(player.p3.patternLn[1].size() == 2) {
                            main.moveTokens(2, player.p3);
                        }
                        if(player.p3.patternLn[2].size() == 3) {
                            main.moveTokens(3, player.p3);
                        }
                        if(player.p3.patternLn[3].size() == 4) {
                            main.moveTokens(4, player.p3);
                        }
                        if(player.p3.patternLn[4].size() == 5) {
                            main.moveTokens(5, player.p3);
                        }

                        if(player.p4.patternLn[0].size() == 1) {
                            main.moveTokens(1, player.p4);
                        }
                        if(player.p4.patternLn[1].size() == 2) {
                            main.moveTokens(2, player.p4);
                        }
                        if(player.p4.patternLn[2].size() == 3) {
                            main.moveTokens(3, player.p4);
                        }
                        if(player.p4.patternLn[3].size() == 4) {
                            main.moveTokens(4, player.p4);
                        }
                        if(player.p4.patternLn[4].size() == 5) {
                            main.moveTokens(5, player.p4);
                        }

                        System.out.println(player.p1.points);
                        System.out.println(player.p2.points);
                        System.out.println(player.p3.points);
                        System.out.println(player.p4.points);


                        if(player.p1.gameOver()) {
                            //show winner screen
                        } else {
                            reset();
                        }
                        
                        
                    }
                    
                }
                

                if(MainAzul.mouseX >= 1000 && MainAzul.mouseY >= 400 && MainAzul.mouseX <= 1050 && MainAzul.mouseY <= 450) {
                    main.pullCenter(player.p1, "black");
                    MainAzul.player1 = false;
                    MainAzul.player2 = true;
                }
                if(MainAzul.mouseX >= 1060 && MainAzul.mouseY >= 400 && MainAzul.mouseX <= 1110 && MainAzul.mouseY <= 450) {
                    main.pullCenter(player.p1, "blue");
                    MainAzul.player1 = false;
                    MainAzul.player2 = true;
                }
                if(MainAzul.mouseX >= 1120 && MainAzul.mouseY >= 400 && MainAzul.mouseX <= 1170 && MainAzul.mouseY <= 450) {
                    main.pullCenter(player.p1, "red");
                    MainAzul.player1 = false;
                    MainAzul.player2 = true;
                }
                if(MainAzul.mouseX >= 1180 && MainAzul.mouseY >= 400 && MainAzul.mouseX <= 1230 && MainAzul.mouseY <= 450) {
                    main.pullCenter(player.p1, "white");
                    MainAzul.player1 = false;
                    MainAzul.player2 = true;
                }
                if(MainAzul.mouseX >= 1240 && MainAzul.mouseY >= 400 && MainAzul.mouseX <= 1290 && MainAzul.mouseY <= 450) {
                    main.pullCenter(player.p1, "yellow");
                    MainAzul.player1 = false;
                    MainAzul.player2 = true;
                }


                g.setColor(Color.BLACK);
                g.setFont(fontsmall);

                player.drawSmallBoard(g, 0);
                player.drawSmallTokens(g, player.p2);
                player.drawSmallDeducted(g, player.p2);
                player.drawSmallColor(g, player.p2);
                g.drawString("player 2", 70, 280);

                player.drawSmallBoard(g, 260);
                player.drawSmallTokens2(g, player.p3);
                player.drawSmallColor2(g, player.p3);
                player.drawSmallDeductedTwo(g, player.p3);
                g.drawString("player 3", 340, 280);

                player.drawSmallBoard(g, 520);
                player.drawSmallTokens3(g, player.p4);
                player.drawSmallColor3(g, player.p4);
                player.drawSmallDeductedThree(g, player.p4);
                g.drawString("player 4", 600, 280);

                player.drawDeducted(g, player.p1);
                player.drawColorBoard(g, player.p1);

                
                player.drawPoints(g, player.p1);

                

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
                    g.drawString("use number keys to choose factories", 230,  330);
                    
                } else if(MainAzul.tempFact != null) {
                    g.setFont(fontsmall);
                    g.drawString("pick tokens with mouse in selected factory", 230,  330);
                    
                    x = MainAzul.tempFact.getX();
                    y = MainAzul.tempFact.getY();
                    g.drawImage(outline, x, y, 220, 220, null);   
                    g.drawImage(outline, x, y, 220, 220, null);   
                    if(MainAzul.mouseX >= x+25 && MainAzul.mouseY >= y+65 && MainAzul.mouseX <= x+75 && MainAzul.mouseY <= y+105) { // add the if statements from choice pull in here
                        main.choicePull(player.p2, "black");
                        MainAzul.player2 = false;
                        MainAzul.player3 = true;
                    } else if(MainAzul.mouseX >= x+90 && MainAzul.mouseY >= y+25 && MainAzul.mouseX <= x+140 && MainAzul.mouseY <= y+75) {
                        main.choicePull(player.p2, "blue");
                        MainAzul.player2 = false;
                        MainAzul.player3 = true;
                    } else if(MainAzul.mouseX >= x+155 && MainAzul.mouseY >= y+65 && MainAzul.mouseX <= x+205 && MainAzul.mouseY <= y+105) {
                        main.choicePull(player.p2, "red");
                        MainAzul.player2 = false;
                        MainAzul.player3 = true;
                    } else if(MainAzul.mouseX >= x+55 && MainAzul.mouseY >= y+135 && MainAzul.mouseX <= x+105 && MainAzul.mouseY <= y+185) {
                        main.choicePull(player.p2, "white");
                        MainAzul.player2 = false;
                        MainAzul.player3 = true;
                    } else if(MainAzul.mouseX >= x+135 && MainAzul.mouseY >= y+135 && MainAzul.mouseX <= x+185 && MainAzul.mouseY <= y+185) {
                        main.choicePull(player.p2, "yellow");
                        MainAzul.player2 = false;
                        MainAzul.player3 = true;
                    }
                    MainAzul.player2 = false;
                } else if(player.p2.temp.size() != 0){ 
                    g.setFont(fontsmall);
                    g.drawString("use number keys to select pattern line", 230,  330);
                    

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

                if(factory.factEmpty() && factory.center.size() == 0) {
                    g.drawImage(reset, 530, 380, 60, 60, null);
                    if(MainAzul.mouseX >= 530 && MainAzul.mouseY >= 380 && MainAzul.mouseX <= 590 && MainAzul.mouseY <= 440) {
                        if(player.p1.patternLn[0].size() == 1) {
                            main.moveTokens(1, player.p1);
                        }
                        if(player.p1.patternLn[1].size() == 2) {
                            main.moveTokens(2, player.p1);
                        }
                        if(player.p1.patternLn[2].size() == 3) {
                            main.moveTokens(3, player.p1);
                        }
                        if(player.p1.patternLn[3].size() == 4) {
                            main.moveTokens(4, player.p1);
                        }
                        if(player.p1.patternLn[4].size() == 5) {
                            main.moveTokens(5, player.p1);
                        }

                        if(player.p2.patternLn[0].size() == 1) {
                            main.moveTokens(1, player.p2);
                        }
                        if(player.p2.patternLn[1].size() == 2) {
                            main.moveTokens(2, player.p2);
                        }
                        if(player.p2.patternLn[2].size() == 3) {
                            main.moveTokens(3, player.p2);
                        }
                        if(player.p2.patternLn[3].size() == 4) {
                            main.moveTokens(4, player.p2);
                        }
                        if(player.p2.patternLn[4].size() == 5) {
                            main.moveTokens(5, player.p2);
                        }

                        if(player.p3.patternLn[0].size() == 1) {
                            main.moveTokens(1, player.p3);
                        }
                        if(player.p3.patternLn[1].size() == 2) {
                            main.moveTokens(2, player.p3);
                        }
                        if(player.p3.patternLn[2].size() == 3) {
                            main.moveTokens(3, player.p3);
                        }
                        if(player.p3.patternLn[3].size() == 4) {
                            main.moveTokens(4, player.p3);
                        }
                        if(player.p3.patternLn[4].size() == 5) {
                            main.moveTokens(5, player.p3);
                        }

                        if(player.p4.patternLn[0].size() == 1) {
                            main.moveTokens(1, player.p4);
                        }
                        if(player.p4.patternLn[1].size() == 2) {
                            main.moveTokens(2, player.p4);
                        }
                        if(player.p4.patternLn[2].size() == 3) {
                            main.moveTokens(3, player.p4);
                        }
                        if(player.p4.patternLn[3].size() == 4) {
                            main.moveTokens(4, player.p4);
                        }
                        if(player.p4.patternLn[4].size() == 5) {
                            main.moveTokens(5, player.p4);
                        }

                        if(player.p2.gameOver()) {
                            //show winner screen
                        } else {
                            reset();
                        }


                        
                    }
                    
                }

                if(MainAzul.mouseX >= 1000 && MainAzul.mouseY >= 400 && MainAzul.mouseX <= 1050 && MainAzul.mouseY <= 450) {
                    main.pullCenter(player.p2, "black");
                    MainAzul.player2 = false;
                    MainAzul.player3 = true;
                }
                if(MainAzul.mouseX >= 1060 && MainAzul.mouseY >= 400 && MainAzul.mouseX <= 1110 && MainAzul.mouseY <= 450) {
                    main.pullCenter(player.p2, "blue");
                    MainAzul.player2 = false;
                    MainAzul.player3 = true;
                }
                if(MainAzul.mouseX >= 1120 && MainAzul.mouseY >= 400 && MainAzul.mouseX <= 1170 && MainAzul.mouseY <= 450) {
                    main.pullCenter(player.p2, "red");
                    MainAzul.player2 = false;
                    MainAzul.player3 = true;
                }
                if(MainAzul.mouseX >= 1180 && MainAzul.mouseY >= 400 && MainAzul.mouseX <= 1230 && MainAzul.mouseY <= 450) {
                    main.pullCenter(player.p2, "white");
                    MainAzul.player2 = false;
                    MainAzul.player3 = true;
                }
                if(MainAzul.mouseX >= 1240 && MainAzul.mouseY >= 400 && MainAzul.mouseX <= 1290 && MainAzul.mouseY <= 450) {
                    main.pullCenter(player.p2, "yellow");
                    MainAzul.player2 = false;
                    MainAzul.player3 = true;
                }
                

                

                g.setFont(fontsmall);

                player.drawSmallBoard(g, 0);
                player.drawSmallTokens(g, player.p1);
                player.drawSmallColor(g, player.p1);
                player.drawSmallDeducted(g, player.p1);
                g.drawString("player 1", 70, 280);

                player.drawSmallBoard(g, 260);
                player.drawSmallTokens2(g, player.p3);
                player.drawSmallColor2(g, player.p3);
                player.drawSmallDeductedTwo(g, player.p3);
                g.drawString("player 3", 340, 280);

                player.drawSmallBoard(g, 520);
                player.drawSmallTokens3(g, player.p4);
                player.drawSmallColor3(g, player.p4);
                player.drawSmallDeductedThree(g, player.p4);
                g.drawString("player 4", 600, 280);

                player.drawDeducted(g, player.p2);
                player.drawColorBoard(g, player.p2);

                player.drawPoints(g, player.p2);

                

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
                    g.drawString("use number keys to choose factories", 230,  330);
                    
                } else if(MainAzul.tempFact != null) {
                    g.drawString("pick tokens with mouse in selected factory", 230,  330);
                    x = MainAzul.tempFact.getX();
                    y = MainAzul.tempFact.getY();
                    g.drawImage(outline, x, y, 220, 220, null);   
                    g.drawImage(outline, x, y, 220, 220, null);   
                    if(MainAzul.mouseX >= x+25 && MainAzul.mouseY >= y+65 && MainAzul.mouseX <= x+75 && MainAzul.mouseY <= y+105) { // add the if statements from choice pull in here
                        main.choicePull(player.p3, "black");
                        MainAzul.player3 = false;
                        MainAzul.player4 = true;
                    } else if(MainAzul.mouseX >= x+90 && MainAzul.mouseY >= y+25 && MainAzul.mouseX <= x+140 && MainAzul.mouseY <= y+75) {
                        main.choicePull(player.p3, "blue");
                        MainAzul.player3 = false;
                        MainAzul.player4 = true;
                    } else if(MainAzul.mouseX >= x+155 && MainAzul.mouseY >= y+65 && MainAzul.mouseX <= x+205 && MainAzul.mouseY <= y+105) {
                        main.choicePull(player.p3, "red");
                        MainAzul.player3 = false;
                        MainAzul.player4 = true;
                    } else if(MainAzul.mouseX >= x+55 && MainAzul.mouseY >= y+135 && MainAzul.mouseX <= x+105 && MainAzul.mouseY <= y+185) {
                        main.choicePull(player.p3, "white");
                        MainAzul.player3 = false;
                        MainAzul.player4 = true;
                    } else if(MainAzul.mouseX >= x+135 && MainAzul.mouseY >= y+135 && MainAzul.mouseX <= x+185 && MainAzul.mouseY <= y+185) {
                        main.choicePull(player.p3, "yellow");
                        MainAzul.player3 = false;
                        MainAzul.player4 = true;
                    }
                    
                } else if(player.p3.temp.size() != 0){ 
                    g.setFont(fontsmall);
                    g.drawString("use number keys to select pattern line", 230,  330);
                    
                    
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

                if(factory.factEmpty() && factory.center.size() == 0) {
                    g.drawImage(reset, 530, 380, 60, 60, null);
                    if(MainAzul.mouseX >= 530 && MainAzul.mouseY >= 380 && MainAzul.mouseX <= 590 && MainAzul.mouseY <= 440) {
                        if(player.p1.patternLn[0].size() == 1) {
                            main.moveTokens(1, player.p1);
                        }
                        if(player.p1.patternLn[1].size() == 2) {
                            main.moveTokens(2, player.p1);
                        }
                        if(player.p1.patternLn[2].size() == 3) {
                            main.moveTokens(3, player.p1);
                        }
                        if(player.p1.patternLn[3].size() == 4) {
                            main.moveTokens(4, player.p1);
                        }
                        if(player.p1.patternLn[4].size() == 5) {
                            main.moveTokens(5, player.p1);
                        }

                        if(player.p2.patternLn[0].size() == 1) {
                            main.moveTokens(1, player.p2);
                        }
                        if(player.p2.patternLn[1].size() == 2) {
                            main.moveTokens(2, player.p2);
                        }
                        if(player.p2.patternLn[2].size() == 3) {
                            main.moveTokens(3, player.p2);
                        }
                        if(player.p2.patternLn[3].size() == 4) {
                            main.moveTokens(4, player.p2);
                        }
                        if(player.p2.patternLn[4].size() == 5) {
                            main.moveTokens(5, player.p2);
                        }

                        if(player.p3.patternLn[0].size() == 1) {
                            main.moveTokens(1, player.p3);
                        }
                        if(player.p3.patternLn[1].size() == 2) {
                            main.moveTokens(2, player.p3);
                        }
                        if(player.p3.patternLn[2].size() == 3) {
                            main.moveTokens(3, player.p3);
                        }
                        if(player.p3.patternLn[3].size() == 4) {
                            main.moveTokens(4, player.p3);
                        }
                        if(player.p3.patternLn[4].size() == 5) {
                            main.moveTokens(5, player.p3);
                        }

                        if(player.p4.patternLn[0].size() == 1) {
                            main.moveTokens(1, player.p4);
                        }
                        if(player.p4.patternLn[1].size() == 2) {
                            main.moveTokens(2, player.p4);
                        }
                        if(player.p4.patternLn[2].size() == 3) {
                            main.moveTokens(3, player.p4);
                        }
                        if(player.p4.patternLn[3].size() == 4) {
                            main.moveTokens(4, player.p4);
                        }
                        if(player.p4.patternLn[4].size() == 5) {
                            main.moveTokens(5, player.p4);
                        }

                        if(player.p3.gameOver()) {
                            //show winner screen
                        } else {
                            reset();
                        }
                        
                    }
                    
                }

                if(MainAzul.mouseX >= 1000 && MainAzul.mouseY >= 400 && MainAzul.mouseX <= 1050 && MainAzul.mouseY <= 450) {
                    main.pullCenter(player.p3, "black");
                    MainAzul.player3 = false;
                    MainAzul.player4 = true;
                }
                if(MainAzul.mouseX >= 1060 && MainAzul.mouseY >= 400 && MainAzul.mouseX <= 1110 && MainAzul.mouseY <= 450) {
                    main.pullCenter(player.p3, "blue");
                    MainAzul.player3 = false;
                    MainAzul.player4 = true;
                }
                if(MainAzul.mouseX >= 1120 && MainAzul.mouseY >= 400 && MainAzul.mouseX <= 1170 && MainAzul.mouseY <= 450) {
                    main.pullCenter(player.p3, "red");
                    MainAzul.player3 = false;
                    MainAzul.player4 = true;
                }
                if(MainAzul.mouseX >= 1180 && MainAzul.mouseY >= 400 && MainAzul.mouseX <= 1230 && MainAzul.mouseY <= 450) {
                    main.pullCenter(player.p3, "white");
                    MainAzul.player3 = false;
                    MainAzul.player4 = true;
                }
                if(MainAzul.mouseX >= 1240 && MainAzul.mouseY >= 400 && MainAzul.mouseX <= 1290 && MainAzul.mouseY <= 450) {
                    main.pullCenter(player.p3, "yellow");
                    MainAzul.player3 = false;
                    MainAzul.player4 = true;
                }

                
                g.setFont(fontsmall);

                player.drawSmallBoard(g, 0);
                player.drawSmallTokens(g, player.p1);
                player.drawSmallColor(g, player.p1);
                player.drawSmallDeducted(g, player.p1);
                g.drawString("player 1", 70, 280);

                player.drawSmallBoard(g, 260);
                player.drawSmallTokens2(g, player.p2);
                player.drawSmallColor2(g, player.p2);
                player.drawSmallDeductedTwo(g, player.p2);
                g.drawString("player 2", 340, 280);

                player.drawSmallBoard(g, 520);
                player.drawSmallTokens3(g, player.p4);
                player.drawSmallColor3(g, player.p4);
                player.drawSmallDeductedThree(g, player.p4);
                g.drawString("player 4", 600, 280);

                player.drawDeducted(g, player.p3);
                player.drawColorBoard(g, player.p3);

                player.drawPoints(g, player.p3);


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
                    g.drawString("use number keys to choose factories", 230,  330);
                    
                } else if(MainAzul.tempFact != null) {
                    g.drawString("pick tokens with mouse in selected factory", 230,  330);
                    x = MainAzul.tempFact.getX();
                    y = MainAzul.tempFact.getY();
                    g.drawImage(outline, x, y, 220, 220, null);
                    g.drawImage(outline, x, y, 220, 220, null);
                    if(MainAzul.mouseX >= x+25 && MainAzul.mouseY >= y+65 && MainAzul.mouseX <= x+75 && MainAzul.mouseY <= y+105) { // add the if statements from choice pull in here
                        main.choicePull(player.p4, "black");
                        MainAzul.player4 = false;
                        MainAzul.player1 = true;
                    } else if(MainAzul.mouseX >= x+90 && MainAzul.mouseY >= y+25 && MainAzul.mouseX <= x+140 && MainAzul.mouseY <= y+75) {
                        main.choicePull(player.p4, "blue");
                        MainAzul.player4 = false;
                        MainAzul.player1 = true;
                    } else if(MainAzul.mouseX >= x+155 && MainAzul.mouseY >= y+65 && MainAzul.mouseX <= x+205 && MainAzul.mouseY <= y+105) {
                        main.choicePull(player.p4, "red");
                        MainAzul.player4 = false;
                        MainAzul.player1 = true;
                    } else if(MainAzul.mouseX >= x+55 && MainAzul.mouseY >= y+135 && MainAzul.mouseX <= x+105 && MainAzul.mouseY <= y+185) {
                        main.choicePull(player.p4, "white");
                        MainAzul.player4 = false;
                        MainAzul.player1 = true;
                    } else if(MainAzul.mouseX >= x+135 && MainAzul.mouseY >= y+135 && MainAzul.mouseX <= x+185 && MainAzul.mouseY <= y+185) {
                        main.choicePull(player.p4, "yellow");
                        MainAzul.player4 = false;
                        MainAzul.player1 = true;
                    }
                } else if(player.p4.temp.size() != 0){ 
                    g.setFont(fontsmall);
                    g.drawString("use number keys to select pattern line", 230,  330);
                    

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

                if(factory.factEmpty() && factory.center.size() == 0) {
                    g.drawImage(reset, 530, 380, 60, 60, null);
                    if(MainAzul.mouseX >= 530 && MainAzul.mouseY >= 380 && MainAzul.mouseX <= 590 && MainAzul.mouseY <= 440) {
                        if(player.p1.patternLn[0].size() == 1) {
                            main.moveTokens(1, player.p1);
                        }
                        if(player.p1.patternLn[1].size() == 2) {
                            main.moveTokens(2, player.p1);
                        }
                        if(player.p1.patternLn[2].size() == 3) {
                            main.moveTokens(3, player.p1);
                        }
                        if(player.p1.patternLn[3].size() == 4) {
                            main.moveTokens(4, player.p1);
                        }
                        if(player.p1.patternLn[4].size() == 5) {
                            main.moveTokens(5, player.p1);
                        }

                        if(player.p2.patternLn[0].size() == 1) {
                            main.moveTokens(1, player.p2);
                        }
                        if(player.p2.patternLn[1].size() == 2) {
                            main.moveTokens(2, player.p2);
                        }
                        if(player.p2.patternLn[2].size() == 3) {
                            main.moveTokens(3, player.p2);
                        }
                        if(player.p2.patternLn[3].size() == 4) {
                            main.moveTokens(4, player.p2);
                        }
                        if(player.p2.patternLn[4].size() == 5) {
                            main.moveTokens(5, player.p2);
                        }

                        if(player.p3.patternLn[0].size() == 1) {
                            main.moveTokens(1, player.p3);
                        }
                        if(player.p3.patternLn[1].size() == 2) {
                            main.moveTokens(2, player.p3);
                        }
                        if(player.p3.patternLn[2].size() == 3) {
                            main.moveTokens(3, player.p3);
                        }
                        if(player.p3.patternLn[3].size() == 4) {
                            main.moveTokens(4, player.p3);
                        }
                        if(player.p3.patternLn[4].size() == 5) {
                            main.moveTokens(5, player.p3);
                        }

                        if(player.p4.patternLn[0].size() == 1) {
                            main.moveTokens(1, player.p4);
                        }
                        if(player.p4.patternLn[1].size() == 2) {
                            main.moveTokens(2, player.p4);
                        }
                        if(player.p4.patternLn[2].size() == 3) {
                            main.moveTokens(3, player.p4);
                        }
                        if(player.p4.patternLn[3].size() == 4) {
                            main.moveTokens(4, player.p4);
                        }
                        if(player.p4.patternLn[4].size() == 5) {
                            main.moveTokens(5, player.p4);
                        }
                        if(player.p4.gameOver()) {
                            //show winner screen
                        } else {
                            reset();
                        }
                    }

                    
                    
                }

                if(MainAzul.mouseX >= 1000 && MainAzul.mouseY >= 400 && MainAzul.mouseX <= 1050 && MainAzul.mouseY <= 450) {
                    main.pullCenter(player.p4, "black");
                    MainAzul.player4 = false;
                    MainAzul.player1 = true;
                }
                if(MainAzul.mouseX >= 1060 && MainAzul.mouseY >= 400 && MainAzul.mouseX <= 1110 && MainAzul.mouseY <= 450) {
                    main.pullCenter(player.p4, "blue");
                    MainAzul.player4 = false;
                    MainAzul.player1 = true;
                }
                if(MainAzul.mouseX >= 1120 && MainAzul.mouseY >= 400 && MainAzul.mouseX <= 1170 && MainAzul.mouseY <= 450) {
                    main.pullCenter(player.p4, "red");
                    MainAzul.player4 = false;
                    MainAzul.player1 = true;
                }
                if(MainAzul.mouseX >= 1180 && MainAzul.mouseY >= 400 && MainAzul.mouseX <= 1230 && MainAzul.mouseY <= 450) {
                    main.pullCenter(player.p4, "white");
                    MainAzul.player4 = false;
                    MainAzul.player1 = true;
                }
                if(MainAzul.mouseX >= 1240 && MainAzul.mouseY >= 400 && MainAzul.mouseX <= 1290 && MainAzul.mouseY <= 450) {
                    main.pullCenter(player.p4, "yellow");
                    MainAzul.player4 = false;
                    MainAzul.player1 = true;
                }

                g.setFont(fontsmall);

                player.drawSmallBoard(g, 0);
                player.drawSmallTokens(g, player.p1);
                player.drawSmallColor(g, player.p1);
                player.drawSmallDeducted(g, player.p1);
                g.drawString("player 1", 70, 280);

                player.drawSmallBoard(g, 260);
                player.drawSmallTokens2(g, player.p2);
                player.drawSmallColor2(g, player.p2);
                player.drawSmallDeductedTwo(g, player.p2);
                g.drawString("player 2", 340, 280);

                player.drawSmallBoard(g, 520);
                player.drawSmallTokens3(g, player.p3);
                player.drawSmallColor3(g, player.p3);
                player.drawSmallDeductedThree(g, player.p3);
                g.drawString("player 3", 600, 280);

                player.drawDeducted(g, player.p4);
                player.drawColorBoard(g, player.p4);

                player.drawPoints(g, player.p4);


            }
            factory.drawTokens(g);

            if(main.gameWinner(player.p1, player.p2, player.p3, player.p4)) {
                EndGamePanel.end = true;
                MainAzul.game = false;
            }
        } else if(EndGamePanel.end) {
            player.calcFinal();
            end.endScreen(g, player.p1.points, player.p2.points, player.p3.points, player.p4.points);
        }
        
        repaint();

    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        MainAzul.mouseX = e.getX();
        MainAzul.mouseY = e.getY();
        System.out.println(MainAzul.mouseX + " " + MainAzul.mouseY);
        if(MainAzul.mouseX >= 629 && MainAzul.mouseY >= 636 && MainAzul.mouseX <= 974 && MainAzul.mouseY <= 735) {
            MainAzul.start = false;
            MainAzul.game = true;
        } else if(MainAzul.mouseX >= 1430 && MainAzul.mouseY >= 763 && MainAzul.mouseX <= 1600 && MainAzul.mouseY <= 900) {
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
        if(player.p1.pTurn && player.p1.temp.size() == 0 && MainAzul.player1) {
            temp = true;
        } else if(player.p2.pTurn && player.p2.temp.size() == 0 && MainAzul.player2) {
            temp = true;
        } else if(player.p3.pTurn && player.p3.temp.size() == 0 && MainAzul.player3) {
            temp = true;
        } else if(player.p4.pTurn && player.p4.temp.size() == 0 && MainAzul.player4) {
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
            MainAzul.choice = 0;
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
        MainAzul.choice = 0;
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

    public void reset() {
        for(int i = 0; i < player.p1.deducted.size(); i++) {
            if(player.p1.deducted.get(i).type != "minus") {
                MainAzul.discarded.add(player.p1.deducted.get(i));
            } else {
                player.p1.pTurn = true;
                player.p2.pTurn = false;
                player.p3.pTurn = false;
                player.p4.pTurn = false;
            }
        }
        for(int i = 0; i < player.p2.deducted.size(); i++) {
            if(player.p2.deducted.get(i).type != "minus") {
                MainAzul.discarded.add(player.p2.deducted.get(i));
            } else {
                player.p1.pTurn = false;
                player.p2.pTurn = true;
                player.p3.pTurn = false;
                player.p4.pTurn = false;
            }
        }
        for(int i = 0; i < player.p3.deducted.size(); i++) {
            if(player.p3.deducted.get(i).type != "minus") {
                MainAzul.discarded.add(player.p3.deducted.get(i));
            } else {
                player.p1.pTurn = false;
                player.p2.pTurn = false;
                player.p3.pTurn = true;
                player.p4.pTurn = false;
            }
        }
        for(int i = 0; i < player.p4.deducted.size(); i++) {
            if(player.p4.deducted.get(i).type != "minus") {
                MainAzul.discarded.add(player.p4.deducted.get(i));
            } else {
                player.p1.pTurn = false;
                player.p2.pTurn = false;
                player.p3.pTurn = false;
                player.p4.pTurn = true;
            }
        }
        player.p1.deducted = new ArrayList<>();
        player.p2.deducted = new ArrayList<>();
        player.p3.deducted = new ArrayList<>();
        player.p4.deducted = new ArrayList<>();

        factory.f1.fills();
        factory.f2.fills();
        factory.f3.fills();
        factory.f4.fills();
        factory.f5.fills();
        factory.f6.fills();
        factory.f7.fills();
        factory.f8.fills();
        factory.f9.fills();

        MainAzul.firstCenter = true;
    }
}
