import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.util.ArrayList;
public class FactoryPanel {
    public BufferedImage factory, black, blue, red, white, yellow, firstT;
    public Factory f1, f2, f3, f4, f5, f6, f7, f8, f9, cent;
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
            firstT = ImageIO.read(new File("assets/1tile.jpg"));
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
        cent = new Factory(1100, 440);
        cent.center(center);
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
        Token t = new Token("black");
        center.add(t);
        center.add(t);
        center.add(t);
    }

    public void drawFactories(Graphics g){
        for(Factory i: facts){
            int x = i.getX();
            int y = i.getY();
            g.drawImage(factory, x, y, 220, 220, null);
        }
    }

    public void addCenter(Token t){
        center.add(t);
    }

    public void drawTokens(Graphics g){
        if(MainAzul.start == false){ 
            Font font = new Font("Times New Roman", Font.PLAIN, 25);
            for(Factory i: facts){
                int x = i.getX();
                int y = i.getY();
                Color bClr = new Color(0, 0, 0);
                Color wClr = new Color(255, 255, 255);
                ArrayList<Token> toks = i.getTokens();
                for(Token t: toks){
                    if(t.type().equals("black")){
                        g.drawImage(black, x+25, y+65, 50, 50, null);
                        g.setColor(wClr);
                        g.drawString(""+t.amount, x+35, y+110);
                        g.setColor(bClr);
                    }
                    if(t.type().equals("blue")){
                        g.drawImage(blue, x+90, y+25, 50, 50, null);
                        g.drawString(""+t.amount, x+100, y+70);
                    }
                    if(t.type().equals("red")){
                        g.drawImage(red, x+155, y+65, 50, 50, null);
                        g.drawString(""+t.amount, x+165, y+110);
                    }
                    if(t.type().equals("white")){
                        g.drawImage(white, x+55, y+135, 50, 50, null);
                        g.drawString(""+t.amount, x+65, y+180);
                    }
                    if(t.type().equals("yellow")){
                        g.drawImage(yellow, x+125, y+135, 50, 50, null);
                        g.drawString(""+t.amount, x+135, y+180);
                    }
                }
            }
        }
    }

    public void drawCenter(Graphics g){
        int ba = 0;
        int bu = 0;
        int r = 0;
        int w = 0; 
        int y = 0;
        boolean first = false;
        for(Token t: center){
            if(t.type().equals("black")){
                ba++;
            }
            if(t.type().equals("blue")){
                bu++;
            }
            if(t.type().equals("red")){
                r++;
            }
            if(t.type().equals("white")){
                w++;
            }
            if(t.type().equals("yellow")){
                y++;
            }
            if(t.type().equals("first")){
                first = true;
            }
        }
        g.drawImage(black, 1000, 400, 50, 50, null);
        Color whi = new Color(255, 255, 255);
        g.setColor(whi);
        g.drawString(""+ba, 1010, 440);
        Color bl = new Color(0, 0, 0);
        g.setColor(bl);
        g.drawImage(blue, 1050, 400, 50, 50, null);
        g.drawString(""+ba, 1060, 440);
        g.drawImage(red, 1100, 400, 50, 50, null);
        g.drawString(""+ba, 1110, 440);
        g.drawImage(white, 1150, 400, 50, 50, null);
        g.drawString(""+ba, 1160, 440);
        g.drawImage(yellow, 1200, 400, 50, 50, null);
        g.drawString(""+ba, 1210, 440);
        if(first){
            g.drawImage(firstT, 1100, 460, 50, 50, null);
        }
    }
}