import java.util.*;
import java.util.Random;
public class Factory {
    public ArrayList<Token> factTokens;
    public int posX, posY; // position of each factory;
    public MainAzul main;
    
    public Factory(int x, int y) {
        posX = x;
        posY = y;
        main = new MainAzul();
        factTokens = new ArrayList<>();
    }

    public void fills() {
        int blackAmt = 0;
        int blueAmt = 0;
        int redAmt = 0;
        int whiteAmt = 0;
        int yellowAmt = 0;
        for(int i = 0; i<4; i++){
            if(MainAzul.bag.get(i).type.equals("black")) {
                blackAmt += 1;
                MainAzul.bag.remove(i);
            } else if(MainAzul.bag.get(i).type.equals("blue")) {
                blueAmt += 1;
                MainAzul.bag.remove(i);
            } else if(MainAzul.bag.get(i).type.equals("red")) {
                redAmt += 1;
                MainAzul.bag.remove(i);
            } else if(MainAzul.bag.get(i).type.equals("white")) {
                whiteAmt += 1;
                MainAzul.bag.remove(i);
            } else if(MainAzul.bag.get(i).type.equals("yellow")) {
                yellowAmt += 1;
                MainAzul.bag.remove(i);
            }
            if(MainAzul.bag.size() == 0) {
                while(MainAzul.bag.size() <= 100) {
                    MainAzul.bag.add(MainAzul.discarded.get(MainAzul.discarded.size()-1));
                    MainAzul.discarded.remove(MainAzul.discarded.size()-1);
                }
            }
        }
        if(blackAmt > 0) {
            factTokens.add(new Token("black", blackAmt));
        }
        if(blueAmt > 0) {
            factTokens.add(new Token("blue", blueAmt));
        }
        if(redAmt > 0) {
            factTokens.add(new Token("red", redAmt));
        }
        if(whiteAmt > 0) {
            factTokens.add(new Token("white", whiteAmt));
        }
        if(yellowAmt > 0) {
            factTokens.add(new Token("yellow", yellowAmt));
        }
    }
    
    public void center(ArrayList<Token> a){
        factTokens.clear();
        int blackAmt = 0;
        int blueAmt = 0;
        int redAmt = 0;
        int whiteAmt = 0;
        int yellowAmt = 0;
        for(Token i:a){
            if(i.type.equals("black")) {
                blackAmt++;
            } else if(i.type.equals("blue")) {
                blueAmt++;
            } else if(i.type.equals("red")) {
                redAmt++;
            } else if(i.type.equals("white")) {
                whiteAmt++;
            } else if(i.type.equals("yellow")) {
                yellowAmt++;
            }
        }
        if(blackAmt > 0) {
            factTokens.add(new Token("black", blackAmt));
        }
        if(blueAmt > 0) {
            factTokens.add(new Token("blue", blueAmt));
        }
        if(redAmt > 0) {
            factTokens.add(new Token("red", redAmt));
        }
        if(whiteAmt > 0) {
            factTokens.add(new Token("white", whiteAmt));
        }
        if(yellowAmt > 0) {
            factTokens.add(new Token("yellow", yellowAmt));
        }
    }
    public ArrayList<Token> getTokens(){
        return factTokens;
    }
    public int getX(){
        return posX;
    }
    public int getY(){
        return posY;
    }
}
