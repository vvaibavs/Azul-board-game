import java.util.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener; 

public class MainAzul{

    public static ArrayList<Token> discarded;
    public static Factory tempFact;
    public static ArrayList<Token> bag;
    public static boolean firstCenter, start;
    public static int mouseX, mouseY;
    public static int cnt;

    MainAzul() {
        discarded = new ArrayList<>();
        firstCenter = true;
        start = true;
        bag = new ArrayList<>(); // double check this, needs to stay the same across all objects
        tempFact = null;
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
        cnt = 0;
    }

    public void choicePull(Player p) {
        int x = tempFact.getX();
        int y = tempFact.getY();
        int elms = 0;
        if(tempFact != null && (!start && mouseX >= x+25 && mouseY >= y+65 && mouseX <= x+75 && mouseY <= y+105 || (tempFact.factTokens.get(elms).type.equals("black")))) {
            if(tempFact.factTokens.get(elms).type.equals("black") && (mouseX >= x+25 && mouseY >= y+65 && mouseX <= x+75 && mouseY <= y+105)) {
                int blackAmt = tempFact.factTokens.get(0).amount;
                for(int i = 0; i < blackAmt; i++) {
                    p.temp.add(new Token("black"));
                    System.out.println("works");
                }                
                elms++;
                tempFact = null;
            } else if(tempFact.factTokens.get(elms).type.equals("black")) {
                elms++;
            }
            
        } 
         if(tempFact != null && (!start && mouseX >= x+90 && mouseY >= y+25 && mouseX <= x+140 && mouseY <= y+75 || (tempFact.factTokens.get(elms).type.equals("blue")))) {
            if(tempFact.factTokens.get(elms).type.equals("blue") && (mouseX >= x+90 && mouseY >= y+25 && mouseX <= x+140 && mouseY <= y+75)) {
                int blueAmt = tempFact.factTokens.get(elms).amount;
                for(int i = 0; i < blueAmt; i++) {
                    p.temp.add(new Token("blue"));
                    System.out.println("works");
                }                
                elms++;
                tempFact = null;
            } else if(tempFact.factTokens.get(elms).type.equals("blue")) {
                elms++;
            }

        } 
         if(tempFact != null && (!start && mouseX >= x+155 && mouseY >= y+65 && mouseX <= x+205 && mouseY <= y+105 || (tempFact.factTokens.get(elms).type.equals("red")))) {
            if((tempFact.factTokens.get(elms).type.equals("red")) && mouseX >= x+155 && mouseY >= y+65 && mouseX <= x+205 && mouseY <= y+105) {
                int redAmt = tempFact.factTokens.get(elms).amount;
                for(int i = 0; i < redAmt; i++) {
                    p.temp.add(new Token("red"));
                    System.out.println("works");
                }                
                elms++;
                tempFact = null;
            } else if(tempFact.factTokens.get(elms).type.equals("red")) {
                elms++;
            }

        } 
         if(tempFact != null && (!start && mouseX >= x+55 && mouseY >= y+135 && mouseX <= x+105 && mouseY <= y+185 || (tempFact.factTokens.get(elms).type.equals("white")))) {
            if((tempFact.factTokens.get(elms).type.equals("white")) && mouseX >= x+55 && mouseY >= y+135 && mouseX <= x+105 && mouseY <= y+185) {
                int whiteAmt = tempFact.factTokens.get(elms).amount;
                for(int i = 0; i < whiteAmt; i++) {
                    p.temp.add(new Token("white"));
                    System.out.println("works");
                }                
                elms++;
                tempFact = null;
            } else if(tempFact.factTokens.get(elms).type.equals("white")) {
                elms++;
            }
        } 
         if(!start && tempFact != null && mouseX >= x+135 && mouseY >= y+135 && mouseX <= x+185 && mouseY <= y+185) {
            int yellowAmt = tempFact.factTokens.get(tempFact.factTokens.size()-1).amount;
            for(int i = 0; i < yellowAmt; i++) {
                p.temp.add(new Token("yellow"));
                System.out.println("works");
            }
            tempFact = null;
        }
    }

    public void choicePlace(Player p) {

    }

    public int countTokenFact(Token t, Factory f) {
        return -1;
    }

    public ArrayList<Token> getBag(){
        return bag;
    }
    public static void nextPlayer(Player p1, Player p2, Player p3, Player p4) {
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