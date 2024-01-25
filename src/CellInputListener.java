import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/*
 * 创建所有单元格都可以使用的一个监听器类型
 */
public class CellInputListener implements ActionListener {
    private GameBoardPanel gameBoard;
    public CellInputListener(GameBoardPanel gameBoard) {
        if (gameBoard == null)
            throw new IllegalArgumentException("Null pointer reference.");
        this.gameBoard = gameBoard;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // 初始剩余数即为总数
        int numToBeFilled = gameBoard.getNumOfToBeFilled();
        // 获得是哪个单元格出发了回车事件（获得事件源）
        Cell sourceCell = (Cell)e.getSource();
        // 如果什么都没输
        String input = sourceCell.getText();
        // 如果输入的不是数字就直接返回 防止例外
        if (!processInput(input)) {
            return;
        }
        // 获得输入的数字
        int numberIn = Integer.parseInt(input);
        /*
         * 检查发生回车敲击事件的单元格中存储的数字和用户输入的数字是否相等
         * 根据上面的判断结论更新单元格的状态为CellStatus.CORRECT_GUESS或者CellStatus.WRONG_GUESS
         * 一旦单元格的属性值（状态就是它的属性值之一）被更新，那么就应该调用sourceCell.paint()，触发重新绘制单元格的外观
         */
        if (sourceCell.number == numberIn) {
            sourceCell.status = CellStatus.CORRECT_GUESS;
            sourceCell.setEditable(false);
        }
        else {
            sourceCell.status = CellStatus.WRONG_GUESS;
        }
        SudokuState state = gameBoard.getState();
        state.newState(gameBoard);
        sourceCell.paint();
        /*
         * 一个单元格的状态变化了，那么就应该调用GameBoardPanel中的isSolved方法，用来判断游戏是否结束
         * 如果游戏成功解决，那么就可以弹出对话框显示结果。
         */
        if (gameBoard.isSolved()) {
            // 让计时器暂停
            StatePanel statePanel = gameBoard.getStatePanel();
            SudokuTimer timer = statePanel.getTimer();
            timer.stop();
            String time = timer.getCurrentTime();
            JFrame main = gameBoard.getMain();
            // JFrame dialogFrame = new JFrame();
            SudokuDialog sudokuDialog = new SudokuDialog(main, time);
            sudokuDialog.setLocationRelativeTo(main);
            sudokuDialog.setVisible(true);
        }
    }
    // 对输入是数据进行处理 看看是不是输入数字
    public boolean processInput(String text) {
        return switch (text) {
            case "1", "2", "3", "4", "5", "6", "7", "8", "9" -> true;
            default -> false;
        };
    }
}