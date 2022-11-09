import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
public class PlayerPanel {
    public Player p1, p2, p3, p4;
    private BufferedImage board;
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
        } catch(Exception e) {

        }
    }
    public void drawBoard(Graphics g) {
        if(p1.pTurn) {
            g.drawImage(board, 0, 350, 500, 500, null);
        }
    }


}
