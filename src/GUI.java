import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JMenuItem openMenuItem;
    private JMenuItem saveMenuItem;

    private static Dimension preferredSize = new Dimension(500, 400);

    public GUI() {
        frame = new JFrame();
        openMenuItem = new JMenuItem("Open");
        saveMenuItem = new JMenuItem("Save");
        openMenuItem.setAccelerator(KeyStroke.getKeyStroke('O', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        saveMenuItem.setAccelerator(KeyStroke.getKeyStroke('S', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        fileMenu = new JMenu("File");
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        menuBar = new JMenuBar();
        menuBar.add(fileMenu);

        openMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                open();
            }
        });

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

    public void open() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Open");

        int userSelection = fileChooser.showOpenDialog(frame);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String content = "";
                String line;
                while ((line = reader.readLine()) != null) {
                    content += line + "\n";
                }
                reader.close();
                textArea.setText(content);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void save() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save as");

        int userSelection = fileChooser.showSaveDialog(frame);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            String content = textArea.getText();

            try {
                PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file.getAbsolutePath())));
                writer.print(content);
                writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}