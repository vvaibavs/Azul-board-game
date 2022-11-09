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
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            black = ImageIO.read(FactoryPanel.class.getResource("/Image/black.jpg"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            blue = ImageIO.read(FactoryPanel.class.getResource("/Image/blue.jpg"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            black = ImageIO.read(FactoryPanel.class.getResource("/Image/red.jpg"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            black = ImageIO.read(FactoryPanel.class.getResource("/Image/white.jpg"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            black = ImageIO.read(FactoryPanel.class.getResource("/yellow.jpg"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Factory[] facts = {f1, f2, f3, f4, f5, f6, f7, f8, f9};
        //playerboard size is 500x500
        int x = ;
        int y = ;
        for(int i = 0; i<facts.length; i++){
            facts[i] = new Factory();
        }



    }

    public void drawTokens(Graphics g){
        
    }

    public void drawFactories(Graphics g){

    }

    public void drawCenter(Graphics g){

    }
}
