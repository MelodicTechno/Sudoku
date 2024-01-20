/**
 * 为当前应用中很多类需要使用的常量完成定义
 * 将逻辑上相关联的一组类所需要的常量定义在一个类中是可以借鉴的，这样易于维护。
 */
public class SudokuConstants {
    /** 定义游戏面板的大小，针对当前游戏是指每一行的单元格数 */
    public static final int GRID_SIZE = 9;
    // 长度
    public static final int WINDOW_SIZE = 9 * 9;
    public static final String EXIT = "exit";
    public static final String RESET_GAME = "reset game";
    public static final String NEW_GAME = "new game";
    public static int difficultyToNumToGuess(GameDifficulty difficulty) {
        int numToGuess = 0;
        switch (difficulty) {
            case EASY:
                numToGuess = 10;
                break;
            case INTERMEDIATE:
                numToGuess = 20;
                break;
            case DIFFICULT:
                numToGuess = 40;
                break;
        }
        return numToGuess;
    }
}