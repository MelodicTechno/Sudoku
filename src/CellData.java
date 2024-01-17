import java.util.TreeSet;
import java.util.Random;

public class CellData {
    // 存储数独单元格数据的数组
    private int[][] data = new int[9][9];
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
                if (checkColumn(number, col) && checkRow(number, row) && checkNine(number, ROW_SIZE % row,
                        COL_SIZE % col)) {
                    data[row][col] = number;
                }
                number = (number + 1) % 9;
                data[row][col] = number;
            }
        }
    }
    public int[][] getData() {
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
        for (int row = nineRow; row < nineRow + 2; row++) {
            for (int col = nineCol; col < nineCol + 2; col++) {
                if (data[row][col] == number) {
                    return false;
                }
            }
        }
        return true;
    }

    // 打乱九宫格内的数字
    public void Shuffle() {
        Random random = new Random();
        // 打乱50次
        for (int i = 0; i < 50; i ++) {
            // 需要交换的九宫格
            int nineToSwap = random.nextInt(0, 6);
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
}
