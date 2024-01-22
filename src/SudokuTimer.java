import javax.swing.*;
import java.awt.*;
import java.io.Serial;

public class SudokuTimer extends JLabel {
    @Serial
    private static final long serialVersionUID = 1L;
    public static final Color BG_GIVEN = new Color(240, 240, 240); // RGB
    public static final Color FG_GIVEN = Color.BLACK;
    public static final Font STATE_FONT = new Font("Arial", Font.PLAIN, 22);
    // 当前时间
    // private long currentTime;
    private final long initialTime;
    private final CountingThread thread = new CountingThread();
    public SudokuTimer() {
        // 获取初始的时间
        // 开始时间
        initialTime = System.currentTimeMillis();
        // currentTime = initialTime;
        // 更新时间同时绘制
        setFont(STATE_FONT);
        setForeground(FG_GIVEN);
        setBackground(BG_GIVEN);
        thread.start();
        thread.stopped = false;
        setVisible(true);
    }
    private class CountingThread extends Thread {
        public boolean stopped = true;
        private CountingThread() {
            setDaemon(true);
        }

        @Override
        public void run() {
            while (true) {
                if (!stopped) {
                    long passedTime = System.currentTimeMillis() - initialTime;
                    setText(format(passedTime));
                }
                try {
                    sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }
        private String format(long passedTime) {
            int hour;
            int minute;
            int second;
            passedTime /= 1000;
            second = (int) (passedTime % 60);
            passedTime /= 60;
            minute = (int) (passedTime % 60);
            passedTime /= 60;
            hour = (int) (passedTime % 60);
            return String.format("%02d:%02d:%02d", hour, minute, second);
        }
    }
    public void stop() {
        thread.stopped = true;
    }
}
