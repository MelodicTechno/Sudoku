import java.awt.Color;
import java.awt.Font;
import java.io.Serial;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 * Cell类型是用来表示游戏中的每一个单元格，它是Java API中JTextField类型的子类，之所以没有直接使用JTextField类型，就是要在其上进行扩展
 * Cell需要能够输入数字(所以采用JTextField类型作为其父类类型)
 * Cell还需要有其特有的业务数据（比如其在整个游戏面板中的位置，还有其状态）
 */
public class Cell extends JTextField {
    @Serial
    private static final long serialVersionUID = 1L;
    // 预先定义好在单元格不同状态下的颜色常量
    public static final Color BG_GIVEN = new Color(240, 240, 240); // RGB
    public static final Color FG_GIVEN = Color.BLACK;
    public static final Color FG_NOT_GIVEN = Color.GRAY;
    public static final Color BG_TO_GUESS  = new Color(253, 219, 145);
    public static final Color BG_CORRECT_GUESS = new Color(198, 245, 198);
    public static final Color BG_WRONG_GUESS = new Color(246, 164, 164);
    public static final Font FONT_NUMBERS = new Font("Arial", Font.PLAIN, 28);


    /** 该单元格在游戏面板中的位置 */
    int row, col;
    /** 该单元格中应该的数字*/
    int number;
    /** 该单元格的当前状态 */
    CellStatus status;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        // 调用JTextField中的方法，用来设置对齐属性以及字体
        super.setHorizontalAlignment(JTextField.CENTER);
        super.setFont(FONT_NUMBERS);
        super.setBorder(new LineBorder(Color.GRAY, 1));
        makeBorder();
    }

    /** 当重新一局游戏时，通过这个方法设定单元格中正确的数字和初始状态 */
    public void newGame(int number, boolean isGiven) {
        this.number = number;
        status = isGiven ? CellStatus.GIVEN : CellStatus.TO_GUESS;
        paint();    // 因为数字和状态变化了，所以需要重新绘制自己的外观
    }

    /** 单元格的外观取决于状态 */
    public void paint() {
        // 以下方法的调用都使用了super，其实是没有必要的，主要是让同学们了解这些方法都是JTextField类中定义的方法
        if (status == CellStatus.GIVEN) {
            super.setText(number + "");
            super.setEditable(false);
            super.setBackground(BG_GIVEN);
            super.setForeground(FG_GIVEN);
        } else if (status == CellStatus.TO_GUESS) {
            super.setText("");
            super.setEditable(true);
            super.setBackground(BG_TO_GUESS);
            super.setForeground(FG_NOT_GIVEN);
        } else if (status == CellStatus.CORRECT_GUESS) {
            super.setBackground(BG_CORRECT_GUESS);
        } else if (status == CellStatus.WRONG_GUESS) {
            super.setBackground(BG_WRONG_GUESS);
        }
    }
    public void makeBorder() {
        // Border oldBorder = super.getBorder();
        Border rightBorder = BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK);
        Border topBorder = BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK);
        Border bottomBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK);
        Border leftBorder = BorderFactory.createMatteBorder(0, 1, 0, 0, Color.BLACK);
        if (row % 3 == 0) {
            Border oldBorder = super.getBorder();
            Border newTopBorder = BorderFactory.createCompoundBorder(topBorder, oldBorder);
            super.setBorder(newTopBorder);
        }
        if (col % 3 == 0) {
            Border oldBorder = super.getBorder();
            Border newTopBorder = BorderFactory.createCompoundBorder(leftBorder, oldBorder);
            super.setBorder(newTopBorder);
        }
        if (col == 8) {
            Border oldBorder = super.getBorder();
            Border newRightBorder = BorderFactory.createCompoundBorder(rightBorder, oldBorder);
            super.setBorder(newRightBorder);
        }
        if (row == 8) {
            Border oldBorder = super.getBorder();
            Border newBottomBorder = BorderFactory.createCompoundBorder(bottomBorder, oldBorder);
            super.setBorder(newBottomBorder);
        }
    }
}