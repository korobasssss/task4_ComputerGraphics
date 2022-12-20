package cs.vsu.ruKorobeynikova_A_V;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ImagePanel extends JPanel {
    private BufferedImage bi;

    public ImagePanel() {
    }

    public void setFile(File selectedFile) {
        try {
            this.bi = ImageIO.read(selectedFile);
        } catch (IOException ex) {
            Logger.getLogger(ImagePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (bi != null) {
            Graphics g2 = g.create();
            int preferWidth = bi.getWidth();
            int preferHeight = bi.getHeight();
            g2.drawImage(bi, 0, 0, preferWidth, preferHeight, null);
            g2.dispose();
        }
    }

    public BufferedImage getImage() {
        return bi;
    }

    public void setImage(BufferedImage bi) {
        this.bi = bi;
    }
}
