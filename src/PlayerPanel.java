import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
public class PlayerPanel {
    public Player p1, p2, p3, p4;
    private BufferedImage board,red,yellow,white,black,blue,onetile,pointercounter,xtile,next;
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
            board = ImageIO.read(new File("assets/Final azul board.jpg"));
            yellow = ImageIO.read(new File("assets/yellow.jpg"));
            red = ImageIO.read(new File("assets/red.jpg"));
            white = ImageIO.read(new File("assets/white.jpg"));
            black = ImageIO.read(new File("assets/black.jpg"));
            blue = ImageIO.read(new File("assets/blue.jpg"));
            onetile = ImageIO.read(new File("assets/1tile.jpg"));
            pointercounter = ImageIO.read(new File("assets/pointer counter.jpg"));
            xtile = ImageIO.read(new File("assets/x.png"));
            next = ImageIO.read(new File("assets/next.png"));
        } catch(Exception e) {

        }
        MainAzul.cnt+=1;
    }

    public void drawBoard(Graphics g) {
        g.drawImage(next, 1483, 760, 100, 100, null);
        if(p1.pTurn) {
           g.drawImage(board, 0, 350, 500, 500, null);
           g.drawImage(pointercounter, pointerColumn(10), pointerRow(6), 21, 21, null);
           g.drawImage(xtile, boardcolorColumn(3), boardRow(4), 40, 40, null);
           g.drawImage(yellow, boardColumn(4), boardRow(5), 38, 38, null);
            
        } else if(p2.pTurn) {
            g.drawImage(board, 0, 350, 500, 500, null);
            g.drawImage(blue, boardColumn(4), boardRow(5), 38, 38, null);
        } else if(p3.pTurn) {
            g.drawImage(board, 0, 350, 500, 500, null);
            g.drawImage(black, boardColumn(4), boardRow(5), 38, 38, null);
        } else if(p4.pTurn) {
            g.drawImage(board, 0, 350, 500, 500, null);
            g.drawImage(red, boardColumn(4), boardRow(5), 38, 38, null);
        }
    }

    public void drawTokens() {
        
    }

    

    public int boardRow(int x) {
        if(x == 1) {
            return 531;
        } 
        return ((x - 1) * 43) + 531;
    }
    public int boardColumn(int x) {
        if(x == 1) {
            return 200;
        } 
        return 200 - ((x - 1) * 43);
    }

    public int pointerRow(int x) {
        if(x == 1) {
            return 358;
        } 
        return ((x - 1) * 27) + 358;
    }
    public int boardcolorColumn(int x) {
        if(x == 1) {
            return 263;
        } 
        return ((x - 1) * 43) + 263;
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
}
