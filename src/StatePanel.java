import javax.swing.*;
import java.awt.*;
import java.io.Serial;

public class StatePanel extends JPanel {
    @Serial
    private static final long serialVersionUID = 1L;
    private static final int WIDTH = SudokuConstants.WINDOW_SIZE;
    private SudokuState state;
    private GameBoardPanel board;
    public StatePanel(GameBoardPanel board) {
        setLayout(new FlowLayout());
        state = board.getState();
        add(state);
    }
    public SudokuState getState() {
        return state;
    }
}
