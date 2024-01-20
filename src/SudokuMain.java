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
        // cp.add(menu, BorderLayout.NORTH);
        setJMenuBar(menu);
        cp.add(welcome, BorderLayout.CENTER);
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
    public void reset() {
        new SudokuMain();
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