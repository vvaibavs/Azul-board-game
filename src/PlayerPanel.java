import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
public class PlayerPanel {
    public Player p1, p2, p3, p4;
    private BufferedImage board,red,yellow,white,black,blue,onetile,pointercounter,xtile,gg;
    public int width, height;
    public PlayerPanel() {
        p1 = new Player();
        p2 = new Player();
        p3 = new Player();
        p4 = new Player();
        width = 0;
        height = 0;
        p1.pTurn = true;
        try {
            gg = ImageIO.read(PlayerPanel.class.getResource("assets/Finalazulboard.jpg"));
            board = ImageIO.read(PlayerPanel.class.getResource("assets/Finalazulboard.jpg"));
            yellow = ImageIO.read(PlayerPanel.class.getResource("assets/yellow.jpg"));
            red = ImageIO.read(PlayerPanel.class.getResource("assets/red.jpg"));
            white = ImageIO.read(PlayerPanel.class.getResource("assets/white.jpg"));
            black = ImageIO.read(PlayerPanel.class.getResource("assets/black.jpg"));
            blue = ImageIO.read(PlayerPanel.class.getResource("assets/blue.jpg"));
            onetile = ImageIO.read(PlayerPanel.class.getResource("assets/1tile.jpg"));
            pointercounter = ImageIO.read(PlayerPanel.class.getResource("assets/pointercounter.jpg"));
            xtile = ImageIO.read(PlayerPanel.class.getResource("assets/x.png"));
        } catch(Exception e) {
            System.out.println("ur a failure");
        }
    }

    public void drawBoard(Graphics g) {
        Font font = new Font("Dialog", Font.PLAIN, 50);   
        g.setFont(font);
        g.drawString("7", 925,550);
        g.drawString("8", 925,415);
        g.drawString("9", 989,307);
        g.drawString("1", 1120,268);
        g.drawString("2", 1260,322);
        g.drawString("3", 1330,440);
        g.drawString("4", 1301,571);
        g.drawString("5", 1195,638);
        g.drawString("6", 1025 ,640);
        if(p1.pTurn) {
            g.drawImage(board, 0, 350, 500, 500, null);
        } else if(p2.pTurn) {
            g.drawImage(board, 0, 350, 500, 500, null);
        } else if(p3.pTurn) {
            g.drawImage(board, 0, 350, 500, 500, null);
        } else if(p4.pTurn) {
            g.drawImage(board, 0, 350, 500, 500, null);
        }
    }

    public void drawSmallBoard(Graphics g, int x) {
        if(p1.pTurn) {
            g.drawImage(board, x, 0, 250, 250, null);
        } else if(p2.pTurn) {
            g.drawImage(board, x, 0, 250, 250, null);
        } else if(p3.pTurn) {
            g.drawImage(board, x, 0, 250, 250, null);
        } else if(p4.pTurn) {
            g.drawImage(board, x, 0, 250, 250, null);
        }
    }

    public void drawTokens(Graphics g, Player p) {
        for(int i = 0; i < p.patternLn.length; i++) {
            for(int j = 0; j < p.patternLn[i].size(); j++) {
                if(p.patternLn[i].get(j).type.equals("black")) {
                    g.drawImage(black, boardColumn(j + 1), boardRow(i + 1), 38, 38, null);
                } else if(p.patternLn[i].get(j).type.equals("blue")) {
                    g.drawImage(blue, boardColumn(j + 1), boardRow(i + 1), 38, 38, null);
                } else if(p.patternLn[i].get(j).type.equals("red")) {
                    g.drawImage(red, boardColumn(j + 1), boardRow(i + 1), 38, 38, null);
                } else if(p.patternLn[i].get(j).type.equals("white")) {
                    g.drawImage(white, boardColumn(j + 1), boardRow(i + 1), 38, 38, null);
                } else if(p.patternLn[i].get(j).type.equals("yellow")) {
                    g.drawImage(yellow, boardColumn(j + 1), boardRow(i + 1), 38, 38, null);
                }
            }
        }
    }

    //first small tokens
    public void drawSmallTokens(Graphics g, Player p) {
        for(int i = 0; i < p.patternLn.length; i++) {
            for(int j = 0; j < p.patternLn[i].size(); j++) {
                if(p.patternLn[i].get(j).type.equals("black")) {
                    g.drawImage(black, smallBoardColumn(j + 1), smallBoardRow(i + 1) - 175, 19, 19, null);
                } else if(p.patternLn[i].get(j).type.equals("blue")) {
                    g.drawImage(blue, smallBoardColumn(j + 1), smallBoardRow(i + 1) - 175, 19, 19, null);
                } else if(p.patternLn[i].get(j).type.equals("red")) {
                    g.drawImage(red, smallBoardColumn(j + 1), smallBoardRow(i + 1) - 175, 19, 19, null);
                } else if(p.patternLn[i].get(j).type.equals("white")) {
                    g.drawImage(white, smallBoardColumn(j + 1), smallBoardRow(i + 1) - 175, 19, 19, null);
                } else if(p.patternLn[i].get(j).type.equals("yellow")) {
                    g.drawImage(yellow, smallBoardColumn(j + 1), smallBoardRow(i + 1) - 175, 19, 19, null);
                }
            }
        }
    }

    public void drawSmallTokens2(Graphics g, Player p) {
        for(int i = 0; i < p.patternLn.length; i++) {
            for(int j = 0; j < p.patternLn[i].size(); j++) {
                if(p.patternLn[i].get(j).type.equals("black")) {
                    g.drawImage(black, smallBoardColumn(j + 1) + 260, smallBoardRow(i + 1) - 175, 19, 19, null);
                } else if(p.patternLn[i].get(j).type.equals("blue")) {
                    g.drawImage(blue, smallBoardColumn(j + 1) + 260, smallBoardRow(i + 1) - 175, 19, 19, null);
                } else if(p.patternLn[i].get(j).type.equals("red")) {
                    g.drawImage(red, smallBoardColumn(j + 1) + 260, smallBoardRow(i + 1) - 175, 19, 19, null);
                } else if(p.patternLn[i].get(j).type.equals("white")) {
                    g.drawImage(white, smallBoardColumn(j + 1) + 260, smallBoardRow(i + 1) - 175, 19, 19, null);
                } else if(p.patternLn[i].get(j).type.equals("yellow")) {
                    g.drawImage(yellow, smallBoardColumn(j + 1) + 260, smallBoardRow(i + 1) - 175, 19, 19, null);
                }
            }
        }
    }

    public void drawSmallTokens3(Graphics g, Player p) {
        for(int i = 0; i < p.patternLn.length; i++) {
            for(int j = 0; j < p.patternLn[i].size(); j++) {
                if(p.patternLn[i].get(j).type.equals("black")) {
                    g.drawImage(black, smallBoardColumn(j + 1) + 520, smallBoardRow(i + 1) - 175, 19, 19, null);
                } else if(p.patternLn[i].get(j).type.equals("blue")) {
                    g.drawImage(blue, smallBoardColumn(j + 1) + 520, smallBoardRow(i + 1) - 175, 19, 19, null);
                } else if(p.patternLn[i].get(j).type.equals("red")) {
                    g.drawImage(red, smallBoardColumn(j + 1) + 520, smallBoardRow(i + 1) - 175, 19, 19, null);
                } else if(p.patternLn[i].get(j).type.equals("white")) {
                    g.drawImage(white, smallBoardColumn(j + 1) + 520, smallBoardRow(i + 1) - 175, 19, 19, null);
                } else if(p.patternLn[i].get(j).type.equals("yellow")) {
                    g.drawImage(yellow, smallBoardColumn(j + 1) + 520, smallBoardRow(i + 1) - 175, 19, 19, null);
                }
            }
        }
    }

    public void drawDeducted(Graphics g, Player p) {
        for(int y = 0; y < p.deducted.size(); y++) {
            if(p.deducted.get(y).type.equals("minus")) {
                g.drawImage(onetile, deductedColumn(y+1), 779, 40, 40, null);
            } else if(p.deducted.get(y).type.equals("black")) {
                g.drawImage(black, deductedColumn(y+1), 779, 40, 40, null);
            } else if(p.deducted.get(y).type.equals("blue")) {
                g.drawImage(blue, deductedColumn(y+1), 779, 40, 40, null);
            } else if(p.deducted.get(y).type.equals("red")) {
                g.drawImage(red, deductedColumn(y+1), 779, 40, 40, null);
            } else if(p.deducted.get(y).type.equals("white")) {
                g.drawImage(white, deductedColumn(y+1), 779, 40, 40, null);
            } else if(p.deducted.get(y).type.equals("yellow")) {
                g.drawImage(yellow, deductedColumn(y+1), 779, 40, 40, null);
            }
        }
    }

    public void drawSmallDeducted(Graphics g, Player p) {
        for(int y = 0; y < p.deducted.size(); y++) {
            if(p.deducted.get(y).type.equals("minus")) {
                g.drawImage(onetile, smallDeductedColumn(y+1), 214, 20, 20, null);
            } else if(p.deducted.get(y).type.equals("black")) {
                g.drawImage(black, smallDeductedColumn(y+1), 214, 20, 20, null);
            } else if(p.deducted.get(y).type.equals("blue")) {
                g.drawImage(blue, smallDeductedColumn(y+1), 214, 20, 20, null);
            } else if(p.deducted.get(y).type.equals("red")) {
                g.drawImage(red, smallDeductedColumn(y+1), 214, 20, 20, null);
            } else if(p.deducted.get(y).type.equals("white")) {
                g.drawImage(white, smallDeductedColumn(y+1), 214, 20, 20, null);
            } else if(p.deducted.get(y).type.equals("yellow")) {
                g.drawImage(yellow, smallDeductedColumn(y+1), 214, 20, 20, null);
            }
        }
    }

    public void drawSmallDeductedTwo(Graphics g, Player p) {
        for(int y = 0; y < p.deducted.size(); y++) {
            if(p.deducted.get(y).type.equals("minus")) {
                g.drawImage(onetile, smallDeductedColumn(y+1) + 260, 214, 20, 20, null);
            } else if(p.deducted.get(y).type.equals("black")) {
                g.drawImage(black, smallDeductedColumn(y+1) + 260, 214, 20, 20, null);
            } else if(p.deducted.get(y).type.equals("blue")) {
                g.drawImage(blue, smallDeductedColumn(y+1) + 260, 214, 20, 20, null);
            } else if(p.deducted.get(y).type.equals("red")) {
                g.drawImage(red, smallDeductedColumn(y+1) + 260, 214, 20, 20, null);
            } else if(p.deducted.get(y).type.equals("white")) {
                g.drawImage(white, smallDeductedColumn(y+1) + 260, 214, 20, 20, null);
            } else if(p.deducted.get(y).type.equals("yellow")) {
                g.drawImage(yellow, smallDeductedColumn(y+1) + 260, 214, 20, 20, null);
            }
        }
    }

    public void drawSmallDeductedThree(Graphics g, Player p) {
        for(int y = 0; y < p.deducted.size(); y++) {
            if(p.deducted.get(y).type.equals("minus")) {
                g.drawImage(onetile, smallDeductedColumn(y+1) + 520, 214, 20, 20, null);
            } else if(p.deducted.get(y).type.equals("black")) {
                g.drawImage(black, smallDeductedColumn(y+1) + 520, 214, 20, 20, null);
            } else if(p.deducted.get(y).type.equals("blue")) {
                g.drawImage(blue, smallDeductedColumn(y+1) + 520, 214, 20, 20, null);
            } else if(p.deducted.get(y).type.equals("red")) {
                g.drawImage(red, smallDeductedColumn(y+1) + 520, 214, 20, 20, null);
            } else if(p.deducted.get(y).type.equals("white")) {
                g.drawImage(white, smallDeductedColumn(y+1) + 520, 214, 20, 20, null);
            } else if(p.deducted.get(y).type.equals("yellow")) {
                g.drawImage(yellow, smallDeductedColumn(y+1) + 520, 214, 20, 20, null);
            }
        }
    }
    public int deductedColumn(int x) {
        return((x-1) * 48) + 25;
    }
    public int smallDeductedColumn(int x) {
        return((x-1) * 24) + 12;
    }

    public void drawColorBoard(Graphics g, Player p) {
        for(int i = 0; i < p.board.length; i++) {
            for(int j = 0; j < p.board[i].length; j++) {
                if(p.board[i][j] != null) {
                    g.drawImage(xtile, boardColorColumn(j+1), boardColorRow(i+1), 38, 38, null);
                }
            }
        }
    }

    public void drawSmallColor(Graphics g, Player p) {
        for(int i = 0; i < p.board.length; i++) {
            for(int j = 0; j < p.board[i].length; j++) {
                if(p.board[i][j] != null) {
                    g.drawImage(xtile, smallColorColumn(j+1), smallColorRow(i+1), 19, 19, null);
                }
            }
        }
    }

    public void drawSmallColor2(Graphics g, Player p) {
        for(int i = 0; i < p.board.length; i++) {
            for(int j = 0; j < p.board[i].length; j++) {
                if(p.board[i][j] != null) {
                    g.drawImage(xtile, smallColorColumn(j+1) + 260, smallColorRow(i+1), 19, 19, null);
                }
            }
        }
    }

    public void drawSmallColor3(Graphics g, Player p) {
        for(int i = 0; i < p.board.length; i++) {
            for(int j = 0; j < p.board[i].length; j++) {
                if(p.board[i][j] != null) {
                    g.drawImage(xtile, smallColorColumn(j+1) + 520, smallColorRow(i+1), 19, 19, null);
                }
            }
        }
    }

    public void drawPoints(Graphics g, Player p) {
        if(p.points > 0 && p.points <= 20) {
            g.drawImage(pointercounter, pointerColumn(p.points), 385, 20, 20, null);
        } else if(p.points > 20 && p.points <= 40) {
            g.drawImage(pointercounter, pointerColumn(p.points-20), 411, 20, 20, null);
        } else if(p.points > 40 && p.points <= 60) {
            g.drawImage(pointercounter, pointerColumn(p.points-40), 438, 20, 20, null);
        } else if(p.points > 60 && p.points <= 80) {
            g.drawImage(pointercounter, pointerColumn(p.points-60), 465, 20, 20, null);
        } else if(p.points > 80 && p.points <= 100) {
            g.drawImage(pointercounter, pointerColumn(p.points-80), 494, 20, 20, null);
        }

    }


    public int boardRow(int x) {
        return ((x - 1) * 44) + 531;
    }
    public int boardColumn(int x) {
        return 200 - ((x - 1) * 42);
    }

    public int smallBoardRow(int x) {
        return ((x-1) * 22) + 265;
    }

    public int smallBoardColumn(int x) {
        return 100 - ((x-1) * 21);
    }

    public int pointerRow(int x) {
        return ((x - 1) * 27) + 358;
    }

    public int boardColorColumn(int x) {
        return ((x - 1) * 43) + 263;
    }

    public int boardColorRow(int x) {
        return((x - 1) * 43) + 531;
    }

    public int smallColorColumn(int x) {
        return ((x - 1) * 22) + 130;
    }

    public int smallColorRow(int x) {
        return ((x - 1) * 22) + 90;
    }

    public int pointerColumn(int x) {
        if(x == 1) {
            return 30;
        }
        if(x >= 2 && x <= 5) {
            return 30 + ((x - 1) * 22);
        }
        if(x >= 6 && x <= 10) {
            return 31 + ((x - 1) * 22);
        }
        if(x >= 11 && x <= 15) {
            return 32 + ((x - 1) * 22);
        }
            return 33 + ((x - 1) * 22);
    }

    public void calcFinal() {
        if(MainAzul.pl1) {
            p1.points += 2;
            MainAzul.pl1 = false;
        }
        if(MainAzul.pl2) {
            p2.points += 2;
            MainAzul.pl2 = false;
        }
        if(MainAzul.pl3) {
            p3.points += 2;
            MainAzul.pl3 = false;
        }
        if(MainAzul.pl4) {
            p4.points += 2;
            MainAzul.pl4 = false;
        }

        p1.points += vertic(p1) * 7;
        p2.points += vertic(p2) * 7;
        p3.points += vertic(p3) * 7;
        p4.points += vertic(p4) * 7;

        if(diag(p1)) {
            p1.points += 10;
        }
        if(reverseDiag(p1)) {
            p1.points += 10;
        }

        if(diag(p2)) {
            p2.points += 10;
        }
        if(reverseDiag(p2)) {
            p2.points += 10;
        }

        if(diag(p3)) {
            p3.points += 10;
        }
        if(reverseDiag(p3)) {
            p3.points += 10;
        }

        if(diag(p4)) {
            p4.points += 10;
        }
        if(reverseDiag(p4)) {
            p4.points += 10;
        }
        
    }

    public int vertic(Player p) {
        boolean asdf;
        int cnt = 0;
        for(int i = 0; i < p.board[0].length; i++) {
            asdf = true;
            for(int j = 0; j < p.board.length; j++) {
                if(p.board[j][i] == null) {
                    asdf = false;
                }
            }
            if(asdf) {
                cnt++;
            }
        }
        return cnt;
    }

    public boolean diag(Player p) {
        for(int i = 0; i < p.board.length; i++) {
            if(p.board[i][i] == null) {
                return false;
            }
        }
        return true;
    }

    public boolean reverseDiag(Player p) {
        for(int i = 0; i < p.board.length; i++) {
            if(p.board[i][4-i] == null) {
                return false;
            }
        }
        return true;
    }

}
