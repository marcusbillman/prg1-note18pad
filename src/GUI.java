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
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem saveMenuItem;

    private static Dimension preferredSize = new Dimension(500, 400);

    public GUI() {
        saveMenuItem = new JMenuItem("Save");
        fileMenu = new JMenu("File");
        fileMenu.add(saveMenuItem);
        menuBar = new JMenuBar();
        menuBar.add(fileMenu);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        GUI gui = new GUI();

        JFrame frame = new JFrame("GUI");
        frame.setTitle("NoTE18pad");
        frame.setPreferredSize(preferredSize);
        frame.setContentPane(gui.panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(gui.menuBar);
        frame.pack();
        frame.setVisible(true);
    }
}
