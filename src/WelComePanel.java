import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.Serial;
import javax.swing.*;

public class WelComePanel extends JPanel {
    @Serial
    private static final long serialVersionUID = 1L;
    // 选择难度的按钮
    private JButton chooseDifficulty = new JButton("选择难度");
    private final JButton[] dificulties = {new JButton("简单"), new JButton("中等"), new JButton("困难")};
    public WelComePanel() {
        super.setLayout(new GridLayout(SudokuConstants.GRID_SIZE, SudokuConstants.GRID_SIZE));
        super.add(chooseDifficulty);
        // 添加选择难度的按钮
        for (int i = 0; i < 3; i++) {
            super.add(dificulties[i]);
        }
    }
}
