package render;

import java.awt.*;
import javax.swing.*;

public class myRender extends JFrame {
    myRenderCards card;

    public myRender() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        this.setBackground(new Color(0x141414));

        card = new myRenderCards();
        this.add(card);
        this.pack();

        this.setLocation(0, 0);

        this.setVisible(true);
    }
}
