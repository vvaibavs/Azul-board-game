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
    public static int choice;
    public static int patternLnChoice;

    public MainAzul() {
        discarded = new ArrayList<>();
        firstCenter = true;
        start = true;
        bag = new ArrayList<>();
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
        choice = 0;
        patternLnChoice = 0;
    }

    public void choicePull(Player p, String type) {
        for(int i = 0; i < tempFact.factTokens.size(); i++) {
            if(tempFact.factTokens.get(i).type.equals(type)) {
                for(int j = 0; j < tempFact.factTokens.get(i).amount; j++) {
                    p.temp.add(new Token(type));
                }
                tempFact.factTokens.remove(i);
            }
        }
        tempFact = null;
        mouseX = 0;
        mouseY = 0;
    }

    public void choicePlace(Player p, int line) {
        int j = line - p.patternLn[line-1].size();
        while(j > 0 && p.temp.size() > 0) {
            p.patternLn[line-1].add(p.temp.get(0));
            p.temp.remove(p.temp.size()-1);
            j--;
        }
        for(int x = 0; x < p.temp.size(); x++) {
            if(p.deducted.size() < 7) {
                p.deducted.add(p.temp.get(x));
            }
        }
        p.temp = new ArrayList<>();

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

    public void moveTokens(int i, Player p) {
        if(i == 1) {
            if(p.patternLn[i-1].get(0).type.equals("blue")) {
                p.board[i-1][0] = new Token("blue");
            } else if(p.patternLn[i-1].get(0).type.equals("yellow")) {
                p.board[i-1][1] = new Token("yellow");
            } else if(p.patternLn[i-1].get(0).type.equals("red")) {
                p.board[i-1][2] = new Token("red");
            } else if(p.patternLn[i-1].get(0).type.equals("black")) {
                p.board[i-1][3] = new Token("black");
            } else if(p.patternLn[i-1].get(0).type.equals("white")) {
                p.board[i-1][4] = new Token("white");
            }
        } else if(i == 2) {
            if(p.patternLn[i-1].get(0).type.equals("white")) {
                p.board[i-1][0] = new Token("white");
            } else if(p.patternLn[i-1].get(0).type.equals("blue")) {
                p.board[i-1][1] = new Token("blue");
            } else if(p.patternLn[i-1].get(0).type.equals("yellow")) {
                p.board[i-1][2] = new Token("yellow");
            } else if(p.patternLn[i-1].get(0).type.equals("red")) {
                p.board[i-1][3] = new Token("red");
            } else if(p.patternLn[i-1].get(0).type.equals("black")) {
                p.board[i-1][4] = new Token("black");
            }
        } else if(i == 3) {
            if(p.patternLn[i-1].get(0).type.equals("black")) {
                p.board[i-1][0] = new Token("black");
            } else if(p.patternLn[i-1].get(0).type.equals("white")) {
                p.board[i-1][1] = new Token("white");
            } else if(p.patternLn[i-1].get(0).type.equals("blue")) {
                p.board[i-1][2] = new Token("blue");
            } else if(p.patternLn[i-1].get(0).type.equals("yellow")) {
                p.board[i-1][3] = new Token("yellow");
            } else if(p.patternLn[i-1].get(0).type.equals("red")) {
                p.board[i-1][4] = new Token("red");
            }
        } else if(i == 4) {
            if(p.patternLn[i-1].get(0).type.equals("red")) {
                p.board[i-1][0] = new Token("red");
            } else if(p.patternLn[i-1].get(0).type.equals("black")) {
                p.board[i-1][1] = new Token("black");
            } else if(p.patternLn[i-1].get(0).type.equals("white")) {
                p.board[i-1][2] = new Token("white");
            } else if(p.patternLn[i-1].get(0).type.equals("blue")) {
                p.board[i-1][3] = new Token("blue");
            } else if(p.patternLn[i-1].get(0).type.equals("yellow")) {
                p.board[i-1][4] = new Token("yellow");
            }
        } else if(i == 5) {
            if(p.patternLn[i-1].get(0).type.equals("yellow")) {
                p.board[i-1][0] = new Token("yellow");
            } else if(p.patternLn[i-1].get(0).type.equals("red")) {
                p.board[i-1][1] = new Token("red");
            } else if(p.patternLn[i-1].get(0).type.equals("black")) {
                p.board[i-1][2] = new Token("black");
            } else if(p.patternLn[i-1].get(0).type.equals("white")) {
                p.board[i-1][3] = new Token("white");
            } else if(p.patternLn[i-1].get(0).type.equals("blue")) {
                p.board[i-1][4] = new Token("blue");
            }
        }
        p.patternLn[i-1] = new ArrayList<>();
    }

}