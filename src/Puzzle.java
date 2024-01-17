import java.util.Random;
/**
 * 定义Puzzle类型，用来表达和一局游戏相关的信息。
 */
public class Puzzle {
    //numbers数组存储一局游戏的数字分布
    int[][] numbers = new int[SudokuConstants.GRID_SIZE][SudokuConstants.GRID_SIZE];
    // isGiven数组用来存储一局游戏单元格的数字是否暴露的状态
    boolean[][] isGiven = new boolean[SudokuConstants.GRID_SIZE][SudokuConstants.GRID_SIZE];

    // 根据设定需要猜测的单元个数新生成一局数独
    // 可以利用猜测的单元个数的多少做为游戏难度级别的设定依据
    // 这个方法需要对numbers数组和isGiven数组进行更新
    public void newPuzzle(int cellsToGuess) {
        CellData cellData = new CellData();
        // hardcodedNumbers是预先设定的一局游戏的数字分布

//        int[][] hardcodedNumbers =
//                {{5, 3, 4, 6, 7, 8, 9, 1, 2},
//                        {6, 7, 2, 1, 9, 5, 3, 4, 8},
//                        {1, 9, 8, 3, 4, 2, 5, 6, 7},
//                        {8, 5, 9, 7, 6, 1, 4, 2, 3},
//                        {4, 2, 6, 8, 5, 3, 7, 9, 1},
//                        {7, 1, 3, 9, 2, 4, 8, 5, 6},
//                        {9, 6, 1, 5, 3, 7, 2, 8, 4},
//                        {2, 8, 7, 4, 1, 9, 6, 3, 5},
//                        {3, 4, 5, 2, 8, 6, 1, 7, 9}};

        int[][] hardcodedNumbers = cellData.getData();
        for (int row = 0; row < SudokuConstants.GRID_SIZE; ++row) {
            for (int col = 0; col < SudokuConstants.GRID_SIZE; ++col) {
                numbers[row][col] = hardcodedNumbers[row][col];
            }
        }

        // 可以使用cellsToGuess的值初始化isGiven数组中false的数量，即需要猜测的单元格数量
        // hardcodedIsGiven是预先设定的有哪些位置的单元格被暴露（在下面的数据中只指定暴露2个单元格）
        boolean[][] hardcodedIsGiven =
                {{true, true, true, true, true, false, true, true, true},
                        {true, true, true, true, true, true, true, true, false},
                        {true, true, true, true, true, true, true, true, true},
                        {true, true, true, true, true, true, true, true, true},
                        {true, true, true, true, true, true, true, true, true},
                        {true, true, true, true, true, true, true, true, true},
                        {true, true, true, true, true, true, true, true, true},
                        {true, true, true, true, true, true, true, true, true},
                        {true, true, true, true, true, true, true, true, true}};

        for (int row = 0; row < SudokuConstants.GRID_SIZE; ++row) {
            for (int col = 0; col < SudokuConstants.GRID_SIZE; ++col) {
                isGiven[row][col] = hardcodedIsGiven[row][col];
            }
        }
    }
}