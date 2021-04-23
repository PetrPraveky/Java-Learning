package render;

import java.awt.*;
import javax.swing.*;

public class myRenderCards extends JPanel{
    public myRenderCards() {
        this.setPreferredSize(new Dimension(500,500));
    }

    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawLine(0, 0, 500, 500);
    }
}