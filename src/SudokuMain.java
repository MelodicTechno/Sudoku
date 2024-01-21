import java.awt.*;
import java.io.Serial;
import javax.swing.*;
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
        board.newGame(difficulty);
        StatePanel statePanel = new StatePanel(board);
        // SudokuState state = statePanel.getState();
        // state.newState(board);
        cp.add(statePanel, BorderLayout.NORTH);
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
        this.dispose();
    }
    public void reset() {
        GameDifficulty newDifficulty = getDifficulty();
        new SudokuMain(newDifficulty);
        this.dispose();
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                new SudokuMain();
            }
        });
    }
}