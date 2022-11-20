import java.util.*;
public class Player {

    public boolean pTurn;
    public int points;
    public ArrayList<Token>[] patternLn;
    public Token[][] board;
    public ArrayList<Token> deducted;
    public ArrayList<Integer> extraPoints;
    public ArrayList<Token> temp;

    public Player() {
        pTurn = false;
        temp = new ArrayList<>();
        patternLn = new ArrayList[5];
        deducted = new ArrayList<>();
        for(int i = 0; i < patternLn.length; i++) {
            patternLn[i] = new ArrayList<>();
        }

        board = new Token[5][5];
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
 
