import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class WelcomeListener implements ActionListener {
    private WelcomePanel welcomePage;
    private GameBoardPanel board;
    public WelcomeListener(WelcomePanel welcomePage) {
        if (welcomePage == null) {
            throw new IllegalArgumentException("Null pointer reference.");
        }
        this.welcomePage =welcomePage;
    }
    public  WelcomeListener(GameBoardPanel board, WelcomePanel welcomePage) {
        if (board == null) {
            throw new IllegalArgumentException("Null pointer reference.");
        }
        this.welcomePage = welcomePage;
        this.board = board;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // 获取被按下的按键
        DifficultyButton button = (DifficultyButton) e.getSource();
        GameDifficulty difficulty = button.getDifficulty();
        // 设定难度
        board.setDifficulty(difficulty);
        // 看看能不能关掉页面
        welcomePage.setVisible(false);
        board.setVisible(true);
    }
}
