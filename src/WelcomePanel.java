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
    private JLabel chooseDifficulty;
    private final DifficultyButton[] dificulties;
    private WelcomeListener listener;
    // 游戏的难度

    private Container cp;
    private GameBoardPanel board;
    private SudokuMain main;
    Font welcomFont = new Font("Times New Roman", Font.PLAIN, 24);

    public WelcomePanel(Container cp, SudokuMain main) {
        this.main = main;
        this.cp = cp;
        listener = new WelcomeListener(this, cp, main);
        this.chooseDifficulty = new JLabel("Difficulty:");
        chooseDifficulty.setFont(welcomFont);
        this.dificulties = new DifficultyButton[]{new DifficultyButton("Easy"), new DifficultyButton("Intermediate"),
                new DifficultyButton("Hard")};
        super.setLayout(new GridBagLayout());
        super.add(chooseDifficulty);
        // 添加选择难度的按钮
        for (int i = 0; i < 3; i++) {
            dificulties[i].addActionListener(listener);
            super.add(dificulties[i]);
            dificulties[i].setVisible(true);
            dificulties[i].setFont(welcomFont);
        }
        super.setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
    }
}
