import java.util.TreeSet;
import java.util.Random;

public class CellData {
    // 存储数独单元格数据的数组
    private int[][] data = new int[9][9];
    private boolean[][] isGivenMatrix = new boolean[9][9];
    private final int COL_SIZE = 9;
    private final int ROW_SIZE = 9;
    // 构造函数
    public CellData() {

    }
    public void generateInitialData() {
        Random randomInt = new Random();
        int number = randomInt.nextInt(1, 10);
        for (int row = 0; row < COL_SIZE; row++) {
            for (int col = 0; col < ROW_SIZE; col++) {
                for (int k = 0; k < 9; k++) {
                    if (checkColumn(number, col) && checkRow(number, row) && checkNine(number, row / 3,
                            col / 3)) {
                        data[row][col] = number;
                        break;
                    }
                    else {
                        number = number % 9 + 1;
                    }
                }
            }
            number = number % 9 + 1;
        }
    }
    public int[][] getData() {
        generateInitialData();
        shuffle();
        return data;
    }
    // 检查列是否有重复元素
    public boolean checkColumn(int number, int column) {
        for (int row = 0; row < ROW_SIZE; row++) {
            if (data[row][column] == number) {
                return false;
            }
        }
        return true;
    }
    // 检查行是否有重复元素
    public boolean checkRow (int number, int row) {
        for (int col = 0; col < COL_SIZE; col++) {
            if (data[row][col] == number) {
                return false;
            }
        }
        return true;
    }
    // 检查每个九宫格是否有重复元素
    public boolean checkNine(int number, int nineRow, int nineCol) {
        nineRow *= 3;
        nineCol *= 3;
        for (int row = nineRow; row < nineRow + 3; row++) {
            for (int col = nineCol; col < nineCol + 3; col++) {
                if (data[row][col] == number) {
                    return false;
                }
            }
        }
        return true;
    }

    // 打乱九宫格内的数字
    public void shuffle() {
        Random random = new Random();
        // 打乱50次
        for (int i = 0; i < 50; i ++) {
            // 需要交换的九宫格
            int nineToSwap = random.nextInt(0, 3) * 3;
            // 每个九宫格内只有三列三行所以是3
            int rowToSwap = nineToSwap + random.nextInt(0, 3);
            int rowBeSwapped = nineToSwap + random.nextInt(0, 3);
            int colToSwap = nineToSwap + random.nextInt(0, 3);
            int colBeSwapped = nineToSwap + random.nextInt(0, 3);
            // 先交换行 顺序当然无所谓
            for (int col = 0; col < COL_SIZE; col++) {
                // 对每两个数字进行交换
                int swap = data[rowToSwap][col];
                data[rowToSwap][col] = data[rowBeSwapped][col];
                data[rowBeSwapped][col] = swap;
            }
            // 列也是一样
            for (int row = 0; row < ROW_SIZE; row++) {
                int swap = data[row][colToSwap];
                data[row][colToSwap] = data[row][colBeSwapped];
                data[row][colBeSwapped] = swap;
            }
        }
    }
    public boolean[][] getIsGiven(GameDifficulty difficulty) {
        int numOfNotGiven = 0;
        Random maskPosition = new Random();
        switch (difficulty) {
            case EASY :
                numOfNotGiven = 10;
                break;
            case INTERMEDIATE:
                numOfNotGiven = 20;
                break;
            case DIFFICULT:
                numOfNotGiven = 40;
        }
        for (int row = 0; row < ROW_SIZE; row++) {
            for (int col = 0; col < COL_SIZE; col++) {
                isGivenMatrix[row][col] = true;
            }
        }
        // 难度多高就循环多少次
        int times = 0;
        while (times < numOfNotGiven) {
            int rowToBeMasked = maskPosition.nextInt(0, 9);
            int colToBeMasked = maskPosition.nextInt(0, 9);
            if (isGivenMatrix[rowToBeMasked][colToBeMasked]) {
                isGivenMatrix[rowToBeMasked][colToBeMasked] = false;
                times++;
            }
        }
        return isGivenMatrix;
    }
    public boolean[][] getIsGiven(int cellsToGuess) {
        Random maskPosition = new Random();
        for (int row = 0; row < ROW_SIZE; row++) {
            for (int col = 0; col < COL_SIZE; col++) {
                isGivenMatrix[row][col] = true;
            }
        }
        // 难度多高就循环多少次
        for (int i = 0; i < cellsToGuess; i++) {
            int rowToBeMasked = maskPosition.nextInt(0, 9);
            int colToBeMasked = maskPosition.nextInt(0, 9);
            isGivenMatrix[rowToBeMasked][colToBeMasked] = false;
        }
        return isGivenMatrix;
    }
}
