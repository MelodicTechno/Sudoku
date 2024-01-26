import javax.swing.*;
import java.awt.*;

public class SudokuDialog extends JDialog {
    public SudokuDialog(JFrame frame, String time) {
        super(frame, "You Won!", true);
        Container c = getContentPane();
        c.add(new JLabel("Finished in: " + time));
        setSize(new Dimension(100, 100));
    }
}
