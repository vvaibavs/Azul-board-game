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

    public boolean gameOver() {
        for(int i = 0; i < this.board.length; i++) {
            if(board[i][0] != null && board[i][1] != null && board[i][2] != null && board[i][3] != null && board[i][4] != null) {
                return true;
            }
        }
        return false;
    }

    public boolean gameWinner() {
        return false;
    }
}
 
