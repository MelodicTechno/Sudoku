import javax.swing.*;

public class SudokuMenuItem extends JMenuItem {
    private String usage;
    public SudokuMenuItem(String text, String usage) {
        super(text);
        this.usage = usage;
        setEnabled(true);
    }
    public String getUsage() {
        return usage;
    }
}
