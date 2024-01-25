import java.awt.*;
import java.io.Serial;
import javax.swing.*;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;
/**
 * 运行Sudoku游戏的程序
 */
public class SudokuMain extends JFrame {
    @Serial
    private static final long serialVersionUID = 1L;
    // 选择难度的界面
    private GameDifficulty difficulty;

    public SudokuMain() {
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        WelcomePanel welcome = new WelcomePanel(cp, this);
        JMenuBar menu = new SudokuMenuBar(this);
        setJMenuBar(menu);
        cp.add(welcome, BorderLayout.CENTER);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Sudoku");
        setVisible(true);
    }
    public SudokuMain(GameDifficulty difficulty) {
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        JMenuBar menu = new SudokuMenuBar(this);
        setJMenuBar(menu);
        GameBoardPanel board = new GameBoardPanel(difficulty);
        cp.add(board, BorderLayout.CENTER);
        setDifficulty(difficulty);
        StatePanel statePanel = new StatePanel(board);
        board.setStatePanel(statePanel);
        cp.add(statePanel, BorderLayout.NORTH);
        board.newGame(difficulty);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Sudoku");
        setVisible(true);
    }
    // 在这里设定游戏的难度
    public void setDifficulty(GameDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    public GameDifficulty getDifficulty() {
        return difficulty;
    }
    // 重启游戏的方法
    public void newGame() {
        new SudokuMain();
        dispose();
    }
    public void reset() {
        GameDifficulty newDifficulty = getDifficulty();
        new SudokuMain(newDifficulty);
        dispose();
    }
    public static void main(String[] args) {
        // 更改界面风格
        try {
            UIManager.setLookAndFeel( new FlatLightLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize theme. Using fallback." );
        }
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                new SudokuMain();
            }
        });
    }
}