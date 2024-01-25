import javax.swing.*;

public class DifficultyButton extends JButton {
    private GameDifficulty difficulty;

    public DifficultyButton(String difficulty) {
        super(difficulty);
        // 设置按钮对应的难度
        switch (difficulty) {
            case ("Easy") :
                this.difficulty = GameDifficulty.EASY;
                break;
            case ("Intermediate") :
                this.difficulty = GameDifficulty.INTERMEDIATE;
                break;
            case ("Hard") :
                this.difficulty = GameDifficulty.DIFFICULT;
                break;
        }
    }
    public GameDifficulty getDifficulty() {
        return difficulty;
    }
}
