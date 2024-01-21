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
    public static final Font STATE_FONT = new Font("Arial", Font.PLAIN, 22);
    private int numOfToBeFilled;
    private int numOfWrongGuess;
    private GameBoardPanel board;
    public SudokuState(GameBoardPanel board) {
        // 设置位置和字体
        // setHorizontalAlignment(JTextField.NORTH);
        // setFont(FONT_NUMBERS);
        this.board = board;
        setFont(STATE_FONT);
        this.numOfToBeFilled = board.getNumOfToBeFilled();
        // System.out.println(numOfToBeFilled);
        paint();
    }
    // 更新状态
    public void newState(GameBoardPanel board) {
        // numOftoBeFilled = board.getNumOfToBeFilled();
        numOfToBeFilled = 0;
        Cell[][] cells = board.getCells();
        for (int row = 0; row < SudokuConstants.GRID_SIZE; row++) {
            for (int col = 0; col < SudokuConstants.GRID_SIZE; col++) {
                if (cells[row][col].status == CellStatus.WRONG_GUESS || cells[row][col].status == CellStatus.TO_GUESS) {
                    numOfToBeFilled++;
                }
            }
        }
        paint();
    }
    // 绘制状态
    public void paint() {
        // 显示剩余空格数
        setText("To be completed:" + numOfToBeFilled);
        setEditable(false);
        setBackground(BG_GIVEN);
    }
    public void setNumOftoBeFilled(int numOftoBeFilled) {
        this.numOfToBeFilled = numOftoBeFilled;
    }
}
