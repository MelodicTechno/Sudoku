import javax.swing.*;

public class DifficultyButton extends JButton {
    private GameDifficulty difficulty;

    public DifficultyButton(String difficulty) {
        super(difficulty);
        // 设置按钮对应的难度
        switch (difficulty) {
            case ("简单") :
                this.difficulty = GameDifficulty.EASY;
                break;
            case ("中等") :
                this.difficulty = GameDifficulty.INTERMEDIATE;
                break;
            case ("困难") :
                this.difficulty = GameDifficulty.DIFFICULT;
                break;
        }
    }
    public GameDifficulty getDifficulty() {
        return difficulty;
    }
}
