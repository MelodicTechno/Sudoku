import javax.swing.*;

public class SudokuMenuItem extends JMenuItem {
    private String usage;
    // TODO
    // 增加属性 用来表示菜单项目是否可用
    public SudokuMenuItem(String text, String usage) {
        super(text);
        this.usage = usage;
    }
    public String getUsage() {
        return usage;
    }
}
