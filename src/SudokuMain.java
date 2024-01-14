import java.awt.*;
import javax.swing.*;
/**
 * 运行Sudoku游戏的程序
 */
public class SudokuMain extends JFrame {
    private static final long serialVersionUID = 1L;
    GameBoardPanel board = new GameBoardPanel();

    public SudokuMain() {
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(board, BorderLayout.CENTER);

        // 初始化一局游戏面板
        board.newGame();

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Sudoku");
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                new SudokuMain();
            }
        });
    }
}