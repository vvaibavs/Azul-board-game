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

        Factory[] facts = {f1, f2, f3, f4, f5, f6, f7, f8, f9};
        //playerboard size is 500x500
        int x = 550;
        int y = 450;
        for(int i = 0; i<facts.length; i++){
            x = (int)(Math.random()*1050)+550;
            y = (int)(Math.random()*1150) + 450;
            facts[i] = new Factory(x, y);
        }

    }

    public void drawTokens(Graphics g){
        
    }

    public void drawFactories(Graphics g){

    }

    public void drawCenter(Graphics g){

    }
}
