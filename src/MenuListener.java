import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuListener implements ActionListener {
    private SudokuMenuBar menuBar;
    public MenuListener(SudokuMenuBar menuBar) {
        if (menuBar == null) {
            throw new IllegalArgumentException("Null pointer reference.");
        }
        this.menuBar = menuBar;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // 提供菜单的功能
        SudokuMenuItem menuItem = (SudokuMenuItem) e.getSource();
        SudokuMain frame = (SudokuMain) menuBar.getFrame();
        switch (menuItem.getUsage()) {
            case (SudokuConstants.EXIT) :
                System.exit(0);
                break;
            case (SudokuConstants.NEW_GAME) :
                frame.newGame();
                break;
            case (SudokuConstants.RESET_GAME) :
                frame.reset();
                break;
        }
    }
}
