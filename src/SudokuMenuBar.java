import javax.swing.*;
import java.io.Serial;

public class SudokuMenuBar extends JMenuBar {
    @Serial
    private static final long serialVersionUID = 1L;
    // 设置菜单大小
    public static final int MENU_LENGTH = SudokuConstants.WINDOW_SIZE;
    private static final int MENU_WIDTH = 30;
    // 构造方法 用来加入菜单组件
    public SudokuMenuBar() {
        JMenu sudokuMenu = new JMenu("File");
        JMenuItem newGame = new JMenuItem("New Game");
        JMenuItem resetGame = new JMenuItem("Reset Game");
        JMenuItem exit = new JMenuItem("Exit");
        this.add(sudokuMenu);
        sudokuMenu.add(newGame);
        sudokuMenu.add(resetGame);
        sudokuMenu.add(exit);
        // setPreferredSize(new Dimension(MENU_LENGTH, MENU_WIDTH));
    }
}
