package render;

import java.awt.*;
import javax.swing.*;

public class myRenderCards extends JPanel{
    Image image;

    public myRenderCards() {
        image = new ImageIcon("D:/Github/Java-Learning/1/BlackJack/res/.cards/cardStackBig-back1.png").getImage();
        this.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
    }

    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(image, 0, 0, 128, 128, null);
    }
}