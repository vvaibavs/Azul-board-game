import java.util.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener; 

public class MainAzul{

    public static ArrayList<Token> discarded;
    public static Factory tempFact;
    public static ArrayList<Token> bag;
    public static boolean firstCenter, start;
    public static int mouseX, mouseY;
    public static int choice;
    public static int patternLnChoice;
    public static ArrayList<Token> center;

    public MainAzul() {
        discarded = new ArrayList<>();
        firstCenter = true;
        start = true;
        bag = new ArrayList<>();
        tempFact = null;
        center = new ArrayList<>();
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
        for(int j = 0; j < tempFact.factTokens.size(); j++) {
            for(int x = 0; x < tempFact.factTokens.get(j).amount; x++) {
                center.add(new Token(tempFact.factTokens.get(j).type));
            }
        }
        tempFact.factTokens = new ArrayList<>();
        tempFact = null;
        mouseX = 0;
        mouseY = 0;
    }

    public void pullCenter(Player p, String type) {
        for(int i = 0; i < center.size(); i++) {
            if(center.get(i).type.equals(type)) {
                p.temp.add(new Token(center.get(i).type));
            }
        }
        if(firstCenter) {
            p.deducted.add(new Token("minus"));
            firstCenter = false;
        }
        for(int i = center.size()-1; i > -1; i--) {
            if(center.get(i).type.equals(type)) {
                center.remove(i);
            }
        }
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
        for(int i = 0; i < discarded.size(); i++) {
            bag.add(discarded.get(i));
        }
        Collections.shuffle(bag);
    }

    public void moveTokens(int i, Player p) {
        if(i == 1) {
            if(p.patternLn[i-1].get(0).type.equals("blue")) {
                p.board[i-1][0] = new Token("blue");
                p.points++;
                int x = 1;
                int y = i-1;
                Token temp = p.board[y][x];
                while(temp != null && x < 5) {
                    p.points+=1;
                    x++;
                    if(x < 5) {
                        temp = p.board[y][x];
                    }
                    
                }

                y = i;
                temp = p.board[y][0];
                while(temp != null && y < 5) {
                    p.points++;
                    y++;
                    if(y < 5) {
                        temp = p.board[y][0];
                    }
                    
                }

            } else if(p.patternLn[i-1].get(0).type.equals("yellow")) {
                p.board[i-1][1] = new Token("yellow");
                p.points++;
                int x = 2;
                int y = i-1;
                Token temp = p.board[y][x];
                while(temp != null && x < 5) {
                    p.points+=1;
                    x++;
                    if(x < 5) {
                        temp = p.board[y][x];
                    }
                   
                }

                x=0;
                temp = p.board[y][x];
                while(temp != null && x >=0 ) {
                    p.points+=1;
                    x--;
                    if(x >= 0) {
                        temp = p.board[y][x];
                    }
                    
                }

                y = i;
                temp = p.board[y][1];
                while(temp != null && y < 5) {
                    p.points++;
                    y++;
                    if(y < 5) {
                        temp = p.board[y][1];
                    }
                    
                }

            } else if(p.patternLn[i-1].get(0).type.equals("red")) {
                p.board[i-1][2] = new Token("red");
                p.points++;

                int x = 3;
                int y = i-1;
                Token temp = p.board[y][x];
                while(temp != null && x < 5) {
                    p.points+=1;
                    x++;

                    if(x < 5) {
                        temp = p.board[y][x];
                    }
                    
                }

                x=1;
                temp = p.board[y][x];
                while(temp != null && x >=0 ) {
                    p.points+=1;
                    x--;
                    if(x >= 0) {
                        temp = p.board[y][x];
                    }
                    
                }

                y = i;
                temp = p.board[y][2];
                while(temp != null && y < 5) {
                    p.points++;
                    y++;
                    if(y < 5) {
                        temp = p.board[y][2];
                    }
                    
                }
            } else if(p.patternLn[i-1].get(0).type.equals("black")) {
                p.board[i-1][3] = new Token("black");
                p.points++;

                int x = 4;
                int y = i-1;
                Token temp = p.board[y][x];
                while(temp != null && x < 5) {
                    p.points+=1;
                    x++;

                    if(x < 5) {
                        temp = p.board[y][x];
                    }
                    
                }

                x = 2;
                temp = p.board[y][x];
                while(temp != null && x >=0 ) {
                    p.points+=1;
                    x--;

                    if(x >= 0) {
                        temp = p.board[y][x];
                    }
                    
                }
                y = i;
                temp = p.board[y][3];
                while(temp != null && y < 5) {
                    p.points++;
                    y++;
                    if(y < 5) {
                        temp = p.board[y][3];
                    }
                    
                }
            } else if(p.patternLn[i-1].get(0).type.equals("white")) {
                p.board[i-1][4] = new Token("white");
                p.points++;

                int x = 3;
                int y = i-1;

                Token temp = p.board[y][x];
                while(temp != null && x >=0 ) {
                    p.points+=1;
                    x--;
                    if(x >= 0) {
                        temp = p.board[y][x];
                    }
                    
                }

                y = i;
                temp = p.board[y][4];
                while(temp != null && y < 5) {
                    p.points++;
                    y++;
                    if( y < 5 ) {
                        temp = p.board[y][4];
                    }
                    
                }
            }
        } else if(i == 2) {
            if(p.patternLn[i-1].get(0).type.equals("white")) {
                p.board[i-1][0] = new Token("white");
                p.points++;

                int x = 1;
                int y = i-1;
                Token temp = p.board[y][x];
                while(temp != null && x < 5) {
                    p.points+=1;
                    x++;
                    if( x < 5) {
                        temp = p.board[y][x];
                    }
                    
                }

                y = i;
                temp = p.board[y][0];
                while(temp != null && y < 5) {
                    p.points++;
                    y++;
                    if(y < 5) {
                        temp = p.board[y][0];
                    }
                    
                }

                y = 0;
                temp = p.board[y][0];
                while(temp != null && y >= 0) {
                    p.points++;
                    y--;

                    if(y >= 0) {
                        temp = p.board[y][0];
                    }
                    
                }



                discarded.add(new Token("white"));
           
            } else if(p.patternLn[i-1].get(0).type.equals("blue")) {
                p.board[i-1][1] = new Token("blue");
                p.points++;

                int x = 2;
                int y = i-1;
                Token temp = p.board[y][x];
                while(temp != null && x < 5) {
                    p.points+=1;
                    x++;
                    if(x < 5) {
                        temp = p.board[y][x];
                    }
                    
                }

                x = 0;
                temp = p.board[y][x];
                while(temp != null && x >= 0) {
                    p.points += 1;
                    x--;
                    if(x >= 0) {
                        temp = p.board[y][x];
                    }
                }

                y = i;
                temp = p.board[y][1];
                while(temp != null && y < 5) {
                    p.points++;
                    y++;
                    if(y < 5) {
                        temp = p.board[y][1];
                    }
                    
                }

                y = 0;
                temp = p.board[y][1];
                while(temp != null && y >= 0) {
                    p.points++;
                    y--;

                    if(y >= 0) {
                        temp = p.board[y][1];
                    }
                    
                }


                discarded.add(new Token("blue"));
            
            } else if(p.patternLn[i-1].get(0).type.equals("yellow")) {
               
                p.board[i-1][2] = new Token("yellow");
                p.points++;

                int x = 3;
                int y = i-1;
                Token temp = p.board[y][x];
                while(temp != null && x < 5) {
                    p.points+=1;
                    x++;
                    if(x < 5) {
                        temp = p.board[y][x];
                    }
                    
                }

                x = 1;
                temp = p.board[y][x];
                while(temp != null && x >= 0) {
                    p.points += 1;
                    x--;
                    if(x >= 0) {
                        temp = p.board[y][x];
                    }
                }

                y = i;
                temp = p.board[y][2];
                while(temp != null && y < 5) {
                    p.points++;
                    y++;
                    if(y < 5) {
                        temp = p.board[y][2];
                    }
                    
                }

                y = 0;
                temp = p.board[y][2];
                while(temp != null && y >= 0) {
                    p.points++;
                    y--;

                    if(y >= 0) {
                        temp = p.board[y][2];
                    }
                    
                }

                discarded.add(new Token("yellow"));
            } else if(p.patternLn[i-1].get(0).type.equals("red")) {
                p.board[i-1][3] = new Token("red");
                p.points++;

                int x = 4;
                int y = i-1;
                Token temp = p.board[y][x];
                while(temp != null && x < 5) {
                    p.points+=1;
                    x++;
                    if(x < 5) {
                        temp = p.board[y][x];
                    }
                    
                }

                x = 2;
                temp = p.board[y][x];
                while(temp != null && x >= 0) {
                    p.points += 1;
                    x--;
                    if(x >= 0) {
                        temp = p.board[y][x];
                    }
                }

                y = i;
                temp = p.board[y][1];
                while(temp != null && y < 5) {
                    p.points++;
                    y++;
                    if(y < 5) {
                        temp = p.board[y][3];
                    }
                    
                }

                y = 0;
                temp = p.board[y][1];
                while(temp != null && y >= 0) {
                    p.points++;
                    y--;

                    if(y >= 0) {
                        temp = p.board[y][3];
                    }
                    
                }

                discarded.add(new Token("red"));
            } else if(p.patternLn[i-1].get(0).type.equals("black")) {
                p.board[i-1][4] = new Token("black");
                p.points++;

                int y = i-1;
                int x = 3;
                Token temp = p.board[y][x];
                while(temp != null && x >= 0) {
                    p.points += 1;
                    x--;
                    if(x >= 0) {
                        temp = p.board[y][x];
                    }
                }

                y = i;
                temp = p.board[y][4];
                while(temp != null && y < 5) {
                    p.points++;
                    y++;
                    if(y < 5) {
                        temp = p.board[y][4];
                    }
                    
                }

                y = 0;
                temp = p.board[y][4];
                while(temp != null && y >= 0) {
                    p.points++;
                    y--;

                    if(y >= 0) {
                        temp = p.board[y][4];
                    }
                    
                }

                discarded.add(new Token("black"));
            }
        } else if(i == 3) {
            if(p.patternLn[i-1].get(0).type.equals("black")) {
                p.board[i-1][0] = new Token("black");
                p.points++;

                int x = 1;
                int y = i-1;
                Token temp = p.board[y][x];
                while(temp != null && x < 5) {
                    p.points+=1;
                    x++;
                    if(x < 5) {
                        temp = p.board[y][x];
                    }
                    
                }

                y = i;
                temp = p.board[y][0];
                while(temp != null && y < 5) {
                    p.points++;
                    y++;
                    if(y < 5) {
                        temp = p.board[y][0];
                    }
                    
                }

                y = 1;
                temp = p.board[y][0];
                while(temp != null && y >= 0) {
                    p.points++;
                    y--;

                    if(y >= 0) {
                        temp = p.board[y][0];
                    }
                    
                }



                for(int z = 0; i < 2; i++) {
                    discarded.add(new Token("black"));
                }
            } else if(p.patternLn[i-1].get(0).type.equals("white")) {
                p.board[i-1][1] = new Token("white");
                p.points++;

                int x = 2;
                int y = i-1;
                Token temp = p.board[y][x];
                while(temp != null && x < 5) {
                    p.points+=1;
                    x++;
                    if(x < 5) {
                        temp = p.board[y][x];
                    }
                    
                }

                x = 0;
                temp = p.board[y][x];
                while(temp != null && x >= 0) {
                    p.points += 1;
                    x--;
                    if(x >= 0) {
                        temp = p.board[y][x];
                    }
                }

                y = i;
                temp = p.board[y][1];
                while(temp != null && y < 5) {
                    p.points++;
                    y++;
                    if(y < 5) {
                        temp = p.board[y][1];
                    }
                    
                }

                y = 1;
                temp = p.board[y][1];
                while(temp != null && y >= 0) {
                    p.points++;
                    y--;

                    if(y >= 0) {
                        temp = p.board[y][1];
                    }
                    
                }

                for(int z = 0; i < 2; i++) {
                    discarded.add(new Token("white"));
                }
            } else if(p.patternLn[i-1].get(0).type.equals("blue")) {
                p.board[i-1][2] = new Token("blue");
                p.points++;

                int x = 3;
                int y = i-1;
                Token temp = p.board[y][x];
                while(temp != null && x < 5) {
                    p.points+=1;
                    x++;
                    if(x < 5) {
                        temp = p.board[y][x];
                    }
                    
                }

                x = 1;
                temp = p.board[y][x];
                while(temp != null && x >= 0) {
                    p.points += 1;
                    x--;
                    if(x >= 0) {
                        temp = p.board[y][x];
                    }
                }

                y = i;
                temp = p.board[y][2];
                while(temp != null && y < 5) {
                    p.points++;
                    y++;
                    if(y < 5) {
                        temp = p.board[y][2];
                    }
                    
                }

                y = 1;
                temp = p.board[y][2];
                while(temp != null && y >= 0) {
                    p.points++;
                    y--;

                    if(y >= 0) {
                        temp = p.board[y][2];
                    }
                    
                }


                for(int z = 0; i < 2; i++) {
                    discarded.add(new Token("blue"));
                }
            } else if(p.patternLn[i-1].get(0).type.equals("yellow")) {
                p.board[i-1][3] = new Token("yellow");
                p.points++;

                int x = 4;
                int y = i-1;
                Token temp = p.board[y][x];
                while(temp != null && x < 5) {
                    p.points+=1;
                    x++;
                    if(x < 5) {
                        temp = p.board[y][x];
                    }
                    
                }

                x = 2;
                temp = p.board[y][x];
                while(temp != null && x >= 0) {
                    p.points += 1;
                    x--;
                    if(x >= 0) {
                        temp = p.board[y][x];
                    }
                }

                y = i;
                temp = p.board[y][3];
                while(temp != null && y < 5) {
                    p.points++;
                    y++;
                    if(y < 5) {
                        temp = p.board[y][3];
                    }
                    
                }

                y = 1;
                temp = p.board[y][3];
                while(temp != null && y >= 0) {
                    p.points++;
                    y--;

                    if(y >= 0) {
                        temp = p.board[y][3];
                    }
                    
                }

                for(int z = 0; i < 2; i++) {
                    discarded.add(new Token("yellow"));
                }
            } else if(p.patternLn[i-1].get(0).type.equals("red")) {
                p.board[i-1][4] = new Token("red");
                p.points++;


                int y = i-1;
                int x = 3;
                Token temp = p.board[y][x];
                while(temp != null && x >= 0) {
                    p.points += 1;
                    x--;
                    if(x >= 0) {
                        temp = p.board[y][x];
                    }
                }

                y = i;
                temp = p.board[y][4];
                while(temp != null && y < 5) {
                    p.points++;
                    y++;
                    if(y < 5) {
                        temp = p.board[y][4];
                    }
                    
                }

                y = 1;
                temp = p.board[y][4];
                while(temp != null && y >= 0) {
                    p.points++;
                    y--;

                    if(y >= 0) {
                        temp = p.board[y][4];
                    }
                    
                }


                for(int z = 0; i < 2; i++) {
                    discarded.add(new Token("red"));
                }
            }
        } else if(i == 4) {
            if(p.patternLn[i-1].get(0).type.equals("red")) {
                p.board[i-1][0] = new Token("red");
                p.points++;

                int x = 0;
                int y = i-1;
                Token temp = p.board[y][x];
                while(temp != null && x < 5) {
                    p.points+=1;
                    x++;
                    if(x < 5) {
                        temp = p.board[y][x];
                    }
                    
                }

                y = i;
                temp = p.board[y][0];
                while(temp != null && y < 5) {
                    p.points++;
                    y++;
                    if(y < 5) {
                        temp = p.board[y][0];
                    }
                    
                }

                y = 2;
                temp = p.board[y][0];
                while(temp != null && y >= 0) {
                    p.points++;
                    y--;

                    if(y >= 0) {
                        temp = p.board[y][0];
                    }
                    
                }


                for(int z = 0; i < 3; i++) {
                    discarded.add(new Token("red"));
                }
            } else if(p.patternLn[i-1].get(0).type.equals("black")) {
                p.board[i-1][1] = new Token("black");
                p.points++;

                int x = 2;
                int y = i-1;
                Token temp = p.board[y][x];
                while(temp != null && x < 5) {
                    p.points+=1;
                    x++;
                    if(x < 5) {
                        temp = p.board[y][x];
                    }
                    
                }

                x = 0;
                temp = p.board[y][x];
                while(temp != null && x >= 0) {
                    p.points += 1;
                    x--;
                    if(x >= 0) {
                        temp = p.board[y][x];
                    }
                }

                y = i;
                temp = p.board[y][1];
                while(temp != null && y < 5) {
                    p.points++;
                    y++;
                    if(y < 5) {
                        temp = p.board[y][1];
                    }
                    
                }

                y = 2;
                temp = p.board[y][1];
                while(temp != null && y >= 0) {
                    p.points++;
                    y--;

                    if(y >= 0) {
                        temp = p.board[y][1];
                    }
                    
                }


                for(int z = 0; i < 3; i++) {
                    discarded.add(new Token("black"));
                }
            } else if(p.patternLn[i-1].get(0).type.equals("white")) {
                p.board[i-1][2] = new Token("white");
                p.points++;

                int x = 3;
                int y = i-1;
                Token temp = p.board[y][x];
                while(temp != null && x < 5) {
                    p.points+=1;
                    x++;
                    if(x < 5) {
                        temp = p.board[y][x];
                    }
                    
                }

                x = 1;
                temp = p.board[y][x];
                while(temp != null && x >= 0) {
                    p.points += 1;
                    x--;
                    if(x >= 0) {
                        temp = p.board[y][x];
                    }
                }

                y = i;
                temp = p.board[y][2];
                while(temp != null && y < 5) {
                    p.points++;
                    y++;
                    if(y < 5) {
                        temp = p.board[y][2];
                    }
                    
                }

                y = 2;
                temp = p.board[y][2];
                while(temp != null && y >= 0) {
                    p.points++;
                    y--;

                    if(y >= 0) {
                        temp = p.board[y][2];
                    }
                    
                }


                for(int z = 0; i < 3; i++) {
                    discarded.add(new Token("white"));
                }
            } else if(p.patternLn[i-1].get(0).type.equals("blue")) {
                p.board[i-1][3] = new Token("blue");
                p.points++;

                int x = 4;
                int y = i-1;
                Token temp = p.board[y][x];
                while(temp != null && x < 5) {
                    p.points+=1;
                    x++;
                    if(x < 5) {
                        temp = p.board[y][x];
                    }
                    
                }

                x = 2;
                temp = p.board[y][x];
                while(temp != null && x >= 0) {
                    p.points += 1;
                    x--;
                    if(x >= 0) {
                        temp = p.board[y][x];
                    }
                }

                y = i;
                temp = p.board[y][3];
                while(temp != null && y < 5) {
                    p.points++;
                    y++;
                    if(y < 5) {
                        temp = p.board[y][3];
                    }
                    
                }

                y = 2;
                temp = p.board[y][3];
                while(temp != null && y >= 0) {
                    p.points++;
                    y--;

                    if(y >= 0) {
                        temp = p.board[y][3];
                    }
                    
                }


                for(int z = 0; i < 3; i++) {
                    discarded.add(new Token("blue"));
                }
            } else if(p.patternLn[i-1].get(0).type.equals("yellow")) {
                p.board[i-1][4] = new Token("yellow");
                p.points++;

                int y = i-1;
                int x = 3;
                Token temp = p.board[y][x];
                while(temp != null && x >= 0) {
                    p.points += 1;
                    x--;
                    if(x >= 0) {
                        temp = p.board[y][x];
                    }
                }

                y = i;
                temp = p.board[y][4];
                while(temp != null && y < 5) {
                    p.points++;
                    y++;
                    if(y < 5) {
                        temp = p.board[y][4];
                    }
                    
                }

                y = 2;
                temp = p.board[y][4];
                while(temp != null && y >= 0) {
                    p.points++;
                    y--;

                    if(y >= 0) {
                        temp = p.board[y][4];
                    }
                    
                }


                for(int z = 0; i < 3; i++) {
                    discarded.add(new Token("yellow"));
                }
            }
            
        } else if(i == 5) {
            if(p.patternLn[i-1].get(0).type.equals("yellow")) {
                p.board[i-1][0] = new Token("yellow");
                p.points++;

                int x = 0;
                int y = i-1;
                Token temp = p.board[y][x];
                while(temp != null && x < 5) {
                    p.points+=1;
                    x++;
                    if(x < 5) {
                        temp = p.board[y][x];
                    }
                    
                }

                y = 3;
                temp = p.board[y][0];
                while(temp != null && y >= 0) {
                    p.points++;
                    y--;

                    if(y >= 0) {
                        temp = p.board[y][0];
                    }
                    
                }


                for(int z = 0; i < 4; i++) {
                    discarded.add(new Token("yellow"));
                }
            } else if(p.patternLn[i-1].get(0).type.equals("red")) {
                p.board[i-1][1] = new Token("red");
                p.points++;

                int x = 2;
                int y = i-1;
                Token temp = p.board[y][x];
                while(temp != null && x < 5) {
                    p.points+=1;
                    x++;
                    if(x < 5) {
                        temp = p.board[y][x];
                    }
                    
                }

                x = 0;
                temp = p.board[y][x];
                while(temp != null && x >= 0) {
                    p.points += 1;
                    x--;
                    if(x >= 0) {
                        temp = p.board[y][x];
                    }
                }

                y = 3;
                temp = p.board[y][1];
                while(temp != null && y >= 0) {
                    p.points++;
                    y--;

                    if(y >= 0) {
                        temp = p.board[y][1];
                    }
                    
                }


                for(int z = 0; i < 4; i++) {
                    discarded.add(new Token("red"));
                }
            } else if(p.patternLn[i-1].get(0).type.equals("black")) {
                p.board[i-1][2] = new Token("black");
                p.points++;

                int x = 3;
                int y = i-1;
                Token temp = p.board[y][x];
                while(temp != null && x < 5) {
                    p.points+=1;
                    x++;
                    if(x < 5) {
                        temp = p.board[y][x];
                    }
                    
                }

                x = 1;
                temp = p.board[y][x];
                while(temp != null && x >= 0) {
                    p.points += 1;
                    x--;
                    if(x >= 0) {
                        temp = p.board[y][x];
                    }
                }

                y = 3;
                temp = p.board[y][2];
                while(temp != null && y >= 0) {
                    p.points++;
                    y--;

                    if(y >= 0) {
                        temp = p.board[y][2];
                    }
                    
                }


                for(int z = 0; i < 4; i++) {
                    discarded.add(new Token("black"));
                }
            } else if(p.patternLn[i-1].get(0).type.equals("white")) {
                p.board[i-1][3] = new Token("white");
                p.points++;

                int x = 4;
                int y = i-1;
                Token temp = p.board[y][x];
                while(temp != null && x < 5) {
                    p.points+=1;
                    x++;
                    if(x < 5) {
                        temp = p.board[y][x];
                    }
                    
                }

                x = 2;
                temp = p.board[y][x];
                while(temp != null && x >= 0) {
                    p.points += 1;
                    x--;
                    if(x >= 0) {
                        temp = p.board[y][x];
                    }
                }

                y = 3;
                temp = p.board[y][3];
                while(temp != null && y >= 0) {
                    p.points++;
                    y--;

                    if(y >= 0) {
                        temp = p.board[y][3];
                    }
                    
                }


                for(int z = 0; i < 4; i++) {
                    discarded.add(new Token("white"));
                }
            } else if(p.patternLn[i-1].get(0).type.equals("blue")) {
                p.board[i-1][4] = new Token("blue");
                p.points++;

                int x = 3;
                int y = i-1;
                Token temp = p.board[y][x];
                while(temp != null && x >= 0) {
                    p.points += 1;
                    x--;
                    if(x >= 0) {
                        temp = p.board[y][x];
                    }
                }

                y = 3;
                temp = p.board[y][3];
                while(temp != null && y >= 0) {
                    p.points++;
                    y--;

                    if(y >= 0) {
                        temp = p.board[y][1];
                    }
                    
                }


                for(int z = 0; i < 4; i++) {
                    discarded.add(new Token("blue"));
                }
            }
        }
        p.patternLn[i-1] = new ArrayList<>();
    }

}