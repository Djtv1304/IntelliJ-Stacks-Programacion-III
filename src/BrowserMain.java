import javax.swing.*;

public class BrowserMain {

    public static void main(String[] args) {
        SwingUtilities.invokeLater (new Runnable() {
            @Override
            public void run() {

                JFrame frame = new Browser();
                frame.setSize(300,300);
                frame.setLocationRelativeTo(null);
                frame.setTitle("Browser");
                frame.setVisible(true);

            }
        });
    }
}
