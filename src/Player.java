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
        temp = new ArrayList<>();
    }

    public boolean moveTokens() {
        return false;
    }

    public int calcPoints() {
        return points;
    }

    public boolean gameWinner() {
        return false;
    }
}
 
