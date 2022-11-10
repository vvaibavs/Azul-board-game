import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
public class FactoryPanel {
    public BufferedImage factory, black, blue, red, white, yellow;
    public Factory f1, f2, f3, f4, f5, f6, f7, f8, f9;
    public ArrayList<Token> center;
    public Factory[] facts;
    public FactoryPanel(){
        try {
            factory = ImageIO.read(FactoryPanel.class.getResource("/Image/factory.png"));
            black = ImageIO.read(FactoryPanel.class.getResource("/Image/black.jpg"));
            blue = ImageIO.read(FactoryPanel.class.getResource("/Image/blue.jpg"));
            black = ImageIO.read(FactoryPanel.class.getResource("/Image/red.jpg"));
            black = ImageIO.read(FactoryPanel.class.getResource("/Image/white.jpg"));
            black = ImageIO.read(FactoryPanel.class.getResource("/yellow.jpg"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        center = new ArrayList<Token>();
        //playerboard size is 500x500, factory is 50 x 50
        f1 = new Factory(550, 450);
        f2 = new Factory(750, 350);
        f3 = new Factory(950, 250);
        f4 = new Factory(1150, 350);
        f5 = new Factory(1350, 450);

        f6 = new Factory(1550, 650);
        f7 = new Factory(1350, 750);
        f8 = new Factory(1150, 750);
        f9 = new Factory(950, 650);

        Factory[] fs = {f1, f2, f3, f4, f5, f6, f7, f8, f9};
        facts = fs;
    }

    public void drawFactories(Graphics g){
        for(Factory i: facts){
            int x = i.getX();
            int y = i.getY();
            g.drawImage(factory, x, y, x+100, y+100, null);
        }
    }


    public void drawTokens(Graphics g){
        for(Factory i: facts){
            ArrayList<Token> toks = i.getTokens();
        }
    }

    public void drawCenter(Graphics g){

    }
}