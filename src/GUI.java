import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.*;

/**
 * GUI
 * 2020-03-12
 * Marcus Billman
 */

public class GUI {
    private JFrame frame;
    private JPanel panel;
    private JTextArea textArea;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem saveMenuItem;

    private static Dimension preferredSize = new Dimension(500, 400);

    public GUI() {
        frame = new JFrame();
        saveMenuItem = new JMenuItem("Save");
        fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        fileMenu.add(saveMenuItem);
        menuBar = new JMenuBar();
        menuBar.add(fileMenu);

        saveMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }
        });
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

    public void save() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");

        int userSelection = fileChooser.showSaveDialog(frame);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            String content = textArea.getText();

            try {
                PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(fileToSave.getAbsolutePath())));
                output.print(content);
                output.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}