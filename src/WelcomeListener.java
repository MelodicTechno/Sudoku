import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class WelcomeListener implements ActionListener {
    private final WelcomePanel welcomePage;
    private Container cp;
    private SudokuMain main;
    public WelcomeListener(WelcomePanel welcomePage) {
        if (welcomePage == null) {
            throw new IllegalArgumentException("Null pointer reference.");
        }
        this.welcomePage = welcomePage;
    }
    public  WelcomeListener(WelcomePanel welcomePage, Container cp, SudokuMain main) {
        this.main = main;
        this.cp = cp;
        this.welcomePage = welcomePage;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // 获取被按下的按键
        DifficultyButton button = (DifficultyButton) e.getSource();
        GameDifficulty difficulty = button.getDifficulty();
        // 设定难度
        main.setDifficulty(difficulty);
        // 关掉页面
        welcomePage.setVisible(false);
        cp.remove(welcomePage);
        GameBoardPanel board = new GameBoardPanel(difficulty);
        StatePanel statePanel = new StatePanel(board);
        board.setStatePanel(statePanel);
        cp.add(board, BorderLayout.CENTER);
        cp.add(statePanel, BorderLayout.NORTH);
        board.newGame(main.getDifficulty());
    }
}
