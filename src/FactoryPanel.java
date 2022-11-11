import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.util.ArrayList;
public class FactoryPanel {
    public BufferedImage factory, black, blue, red, white, yellow;
    public Factory f1, f2, f3, f4, f5, f6, f7, f8, f9;
    public ArrayList<Token> center;
    public Factory[] facts;
    public FactoryPanel(){
        try {
            factory = ImageIO.read(new File("assets/factory.png"));
            black = ImageIO.read(new File("assets/black.jpg"));
            blue = ImageIO.read(new File("assets/blue.jpg"));
            red = ImageIO.read(new File("assets/red.jpg"));
            white = ImageIO.read(new File("assets/white.jpg"));
            yellow = ImageIO.read(new File("assets/yellow.jpg"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        center = new ArrayList<Token>();
        //playerboard size is 500x500, factory is 50 x 50
        f1 = new Factory(1020, 0);
        f2 = new Factory(1255, 75);
        f3 = new Factory(1360, 290);
        f4 = new Factory(1330, 520);
        f5 = new Factory(1130, 650);

        f6 = new Factory(900, 650);
        f7 = new Factory(710, 520);
        f8 = new Factory(690, 290);
        f9 = new Factory(785, 75);

        f1.fills();
        f2.fills();
        f3.fills();
        f4.fills();
        f5.fills();
        f6.fills();
        f7.fills();
        f8.fills();
        f9.fills();

        Factory[] fs = {f1, f2, f3, f4, f5, f6, f7, f8, f9};
        facts = fs;
    }

    public void drawFactories(Graphics g){
        for(Factory i: facts){
            int x = i.getX();
            int y = i.getY();
            g.drawImage(factory, x, y, 220, 220, null);
        }
    }


    public void drawTokens(Graphics g){
        for(Factory i: facts){
            ArrayList<Token> toks = i.factTokens;
        }
    }

    public void drawCenter(Graphics g){

    }
}