import java.awt.*;
import java.io.Serial;
import javax.swing.*;
/**
 * 运行Sudoku游戏的程序
 */
public class SudokuMain extends JFrame {
    @Serial
    private static final long serialVersionUID = 1L;
    GameBoardPanel board = new GameBoardPanel();
    // 选择难度的界面
    WelcomePanel welcome = new WelcomePanel(board);
    public SudokuMain() {
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(board, BorderLayout.CENTER);
        // cp.add(welcome, BorderLayout.CENTER);

        // 初始化一局游戏面板
        // 默认难度为简单
        board.newGame(board.getDifficulty());

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Sudoku");
        setVisible(true);
    }
    public SudokuMain(GameDifficulty difficulty) {
        this();
        board.newGame(difficulty);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Sudoku");
        setVisible(true);
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