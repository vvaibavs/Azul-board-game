import java.util.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener; 

public class MainAzul{

    public static ArrayList<Token> discarded;
    public Factory tempFact;
    public static ArrayList<Token> bag;
    public static boolean firstCenter, start;
    public static int mouseX, mouseY;

    public MainAzul() {
        discarded = new ArrayList<>();
        firstCenter = true;
        start = true;
        bag = new ArrayList<>(); // double check this, needs to stay the same across all objects

        mouseX = -1;
        mouseY = -1;
        for(int i = 0; i < 20; i++) {
            bag.add(new Token("black"));
        }
        for(int j = 0; j < 20; j++) {
            bag.add(new Token("blue"));
        }
        for(int k = 0; k < 20; k++) {
            bag.add(new Token("red"));
        }
        for(int x = 0; x < 20; x++) {
            bag.add(new Token("white"));
        }
        for(int y = 0; y < 20; y++) {
            bag.add(new Token("yellow"));
        }
        Collections.shuffle(bag);
    }

    public void choicePull(Player p) {

    }

    public void choicePlace(Player p) {

    }

    public int countTokenFact(Token t, Factory f) {
        return -1;
    }

    public ArrayList<Token> getBag(){
        return bag;
    }
    public void nextPlayer(Player p1, Player p2, Player p3, Player p4) {
        if(p1.pTurn) {
            p2.pTurn = true;
            p1.pTurn = false;
        } else if(p2.pTurn) {
            p3.pTurn = true;
            p2.pTurn = false;
        } else if(p3.pTurn) {
            p4.pTurn = true;
            p3.pTurn = false;
        } else if(p4.pTurn) {
            p1.pTurn = true;
            p4.pTurn = false;
        }
    }

    public void fillBag() {

    }

}