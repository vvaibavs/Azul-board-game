import javax.swing.*;

public class AzulFrame extends JFrame {
    private static int HEIGHT = 900;
    private static int WIDTH = 1600;

    public AzulFrame(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH,HEIGHT);
        add(new AzulPanel());
        setResizable(false);
        setVisible(true);  
        
    }
}
