import javax.swing.*;
import java.awt.*;

public class SudokuDialog extends JDialog {
    public SudokuDialog(JFrame frame) {
        super(frame, "Sudoku", true);
        Container c = getContentPane();
        c.add(new JLabel("你赢辣"));
        setBounds(400,300,100,100);
    }
}
