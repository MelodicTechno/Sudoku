import java.awt.*;
import java.io.Serial;
import javax.swing.*;

public class WelcomePanel extends JPanel {
    @Serial
    private static final long serialVersionUID = 1L;
    public static final int CELL_SIZE = 60;
    public static final int BOARD_WIDTH  = CELL_SIZE * SudokuConstants.GRID_SIZE;
    public static final int BOARD_HEIGHT = CELL_SIZE * SudokuConstants.GRID_SIZE;
    // 选择难度的按钮
    private DifficultyButton chooseDifficulty;
    private final DifficultyButton[] dificulties;
    private WelcomeListener listener;
    // 游戏的难度

    private Container cp;
    private GameBoardPanel board;
    private SudokuMain main;

    public WelcomePanel(Container cp, SudokuMain main) {
        this.main = main;
        this.cp = cp;
        listener = new WelcomeListener(this, cp, main);
        this.chooseDifficulty = new DifficultyButton("选择难度");
        this.dificulties = new DifficultyButton[]{new DifficultyButton("简单"), new DifficultyButton("中等"),
                new DifficultyButton("困难")};
        super.setLayout(new GridLayout(SudokuConstants.GRID_SIZE, SudokuConstants.GRID_SIZE));
        super.add(chooseDifficulty);
        // 添加选择难度的按钮
        for (int i = 0; i < 3; i++) {
            dificulties[i].addActionListener(listener);
            super.add(dificulties[i]);
            dificulties[i].setVisible(true);
        }
        super.setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
    }
}
