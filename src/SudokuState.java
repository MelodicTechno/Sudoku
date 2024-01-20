import javax.swing.*;
import java.awt.*;
import java.io.Serial;

public class SudokuState extends JTextField {
    @Serial
    private static final long serialVersionUID = 1L;
    // 设置颜色 字体
    public static final Color BG_GIVEN = new Color(240, 240, 240); // RGB
    public static final Color NOT_FILLED = new Color(0, 0, 0);
    public static final Color BG_WRONG_GUESS   = new Color(216, 0, 0);
    public static final Font FONT_NUMBERS = new Font("OCR A Extended", Font.PLAIN, 28);
    public static final Font STATE_FONT = new Font("Arial", Font.PLAIN, 28);
    private int numOftoBeFilled;
    private int numOfWrongGuess;
    public SudokuState() {
        // 设置位置和字体
        setHorizontalAlignment(JTextField.NORTH);
        // setFont(FONT_NUMBERS);
        setFont(STATE_FONT);
    }
    // 更新状态
    public void newState(GameBoardPanel board) {
        numOftoBeFilled = board.getNumOfToBeFilled();
        paint();
    }
    // 绘制状态
    public void paint() {
        // 显示剩余空格数
        setText("剩余数量:" + numOftoBeFilled);
        setEditable(false);
        setBackground(BG_GIVEN);
    }
}
