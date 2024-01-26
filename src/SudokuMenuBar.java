import javax.swing.*;
import java.io.Serial;

public class SudokuMenuBar extends JMenuBar {
    @Serial
    private static final long serialVersionUID = 1L;
    // 设置菜单大小
    // public static final int MENU_LENGTH = SudokuConstants.WINDOW_SIZE;
    // private static final int MENU_WIDTH = 30;
    private JFrame frame;
    private MenuListener listener;
    // 构造方法 用来加入菜单组件
    private JMenuItem resetGame;
    public SudokuMenuBar(JFrame frame) {
        this.frame = frame;
        this.listener = new MenuListener(this);
        JMenu sudokuMenu = new JMenu("File");
        JMenuItem newGame = new SudokuMenuItem("New Game", SudokuConstants.NEW_GAME);
        resetGame = new SudokuMenuItem("Reset Game", SudokuConstants.RESET_GAME);
        JMenuItem exit = new SudokuMenuItem("Exit", SudokuConstants.EXIT);
        this.add(sudokuMenu);
        sudokuMenu.add(newGame);
        sudokuMenu.add(resetGame);
        sudokuMenu.add(exit);
        newGame.addActionListener(listener);
        resetGame.addActionListener(listener);
        exit.addActionListener(listener);
        // setPreferredSize(new Dimension(MENU_LENGTH, MENU_WIDTH));
    }
    public JFrame getFrame() {
        return frame;
    }
    public JMenuItem getResetGame() {
        return resetGame;
    }
}
