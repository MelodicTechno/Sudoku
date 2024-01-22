import javax.swing.*;
import java.awt.*;
import java.io.Serial;

public class StatePanel extends JPanel {
    @Serial
    private static final long serialVersionUID = 1L;
    private static final int WIDTH = SudokuConstants.WINDOW_SIZE;
    private final SudokuState state;
    private GameBoardPanel board;
    private SudokuTimer timer;
    public StatePanel(GameBoardPanel board) {
        setLayout(new BorderLayout());
        state = board.getState();
        timer = new SudokuTimer();
        add(state, BorderLayout.WEST);
        add(timer, BorderLayout.EAST);
    }
    public SudokuState getState() {
        return state;
    }
    public SudokuTimer getTimer() {
        return timer;
    }
}
