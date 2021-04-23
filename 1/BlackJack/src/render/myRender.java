package render;

import java.awt.*;
import javax.swing.*;

public class myRender extends JFrame {
    myRenderCards card;

    public myRender() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLocationRelativeTo(null);

        card = new myRenderCards();
        this.add(card);
        this.pack();

        this.setVisible(true);
    }
}
