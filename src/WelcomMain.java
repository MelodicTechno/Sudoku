import javax.swing.*;
import java.awt.*;
import java.io.Serial;

public class WelcomMain extends JFrame {
    @Serial
    private static final long serialVersionUID = 1L;
    private WelcomePanel welcomePage;
    private GameBoardPanel board;
    public WelcomMain(GameBoardPanel board, WelcomePanel welcomePage) {
        this.board = board;
        this.welcomePage = welcomePage;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
    }
}
