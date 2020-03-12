import javax.swing.*;
import java.awt.*;

/**
 * GUI
 * 2020-03-12
 * Marcus Billman
 */

public class GUI {
    private JPanel panel;
    private JTextArea textArea;

    private static Dimension preferredSize = new Dimension(500, 400);

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("GUI");
        frame.setTitle("NoTE18pad");
        frame.setPreferredSize(preferredSize);
        frame.setContentPane(new GUI().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
