import javax.swing.*;

public class SudokuMenuItem extends JMenuItem {
    private String usage;
    // TODO
    // 增加属性 用来表示菜单项目是否可用
    // private boolean Enabled;
    public SudokuMenuItem(String text, String usage) {
        super(text);
        this.usage = usage;
        setEnabled(true);
    }
    public String getUsage() {
        return usage;
    }
}
