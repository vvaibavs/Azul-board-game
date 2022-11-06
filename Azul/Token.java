public class Token {
    public String type;
    public int amount;

    public Token(String type, int amount){
        this.type = type;
        this.amount = amount;
    } 

    public Token(String type) {
        this.type = type;
    }
}
