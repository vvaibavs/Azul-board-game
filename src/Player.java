import java.util.*;
public class Player {

    public boolean pTurn;
    public int points;
    public ArrayList<Token>[] patternLn;
    public Token[][] board;
    public ArrayList<Integer> extraPoints;
    public ArrayList<Token> temp;

    public Player() {
        pTurn = false;
    }

    public boolean moveTokens() {
        //check w arraylist on main
        return false;
    }

    public int calcPoints() {
        return points;
    }

    public boolean gameWinner() {
        return win;
    }
    public void winner(){
        win = true;
    }
}
 
