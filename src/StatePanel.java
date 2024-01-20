import javax.swing.*;
import java.awt.*;
import java.io.Serial;

public class StatePanel extends JPanel {
    @Serial
    private static final long serialVersionUID = 1L;
    private static final int WIDTH = SudokuConstants.WINDOW_SIZE;
    private SudokuState state;
    public StatePanel() {
        setLayout(new FlowLayout());

    }
}
