import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
 * 创建所有单元格都可以使用的一个监听器类型
 */
public class CellInputListener implements ActionListener {
    private GameBoardPanel gameBoard;
    public CellInputListener(GameBoardPanel gameBoard){
        if (gameBoard == null)
            throw new IllegalArgumentException("Null pointer reference.");
        this.gameBoard = gameBoard;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // 获得是哪个单元格出发了回车事件（获得事件源）
        Cell sourceCell = (Cell)e.getSource();

        // 获得输入的数字
        int numberIn = Integer.parseInt(sourceCell.getText());

        /*
         * [TODO 2]
         * 检查发生回车敲击事件的单元格中存储的数字和用户输入的数字是否相等
         * 根据上面的判断结论更新单元格的状态为CellStatus.CORRECT_GUESS或者CellStatus.WRONG_GUESS
         * 一旦单元格的属性值（状态就是它的属性值之一）被更新，那么就应该调用sourceCell.paint()，触发重新绘制单元格的外观
         */
        if (e.equals(ActionEvent.)) {

        }
        /*
         * [TODO 3]
         * 一个单元格的状态变化了，那么就应该调用GameBoardPanel中的isSolved方法，用来判断游戏是否结束
         * 如果游戏成功解决，那么就可以弹出对话框显示结果。
         */
    }
}