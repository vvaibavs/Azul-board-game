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
        factTokens = new ArrayList<Token>();
    }

    public void fills() {
        ArrayList<Token> mBag = main.getBag();
        for(int i = 0; i<4; i++){
            int r = (int)(Math.random()*mBag.size());
            factTokens.add(mBag.remove(r));
            main.setBag(r);
        }
    }
}
