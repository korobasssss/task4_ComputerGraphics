package cs.vsu.ruKorobeynikova_A_V;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainFrame extends JFrame {

    private JPanel panelMain;
    private JButton buttonCompress;
    private JButton buttonSave;
    private JButton buttonOpen;
    private JPanel originalPanel;
    private JPanel changedPanel;

    private BufferedImage img;

    public MainFrame() {
        this.setTitle("Task4");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.pack();
        this.setSize(new Dimension(900, 600));

        buttonOpen.addActionListener(e -> {
            JFileChooser fileOpen = new JFileChooser();
            fileOpen.setCurrentDirectory(new File(System.getProperty("user.dir")));
            int ret = fileOpen.showOpenDialog(MainFrame.this);
            if (ret == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileOpen.getSelectedFile();
                ((ImagePanel) originalPanel).setFile(selectedFile);
                originalPanel.repaint();
            }
        });

        buttonCompress.addActionListener(e -> {

        });

        buttonSave.addActionListener(e -> {
            File outputFile = new File("image.jpg");
            try {
                ImageIO.write(img, "jpg", outputFile);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    private void createUIComponents() {
        originalPanel = new ImagePanel();
        changedPanel = new ImagePanel();
    }
}
