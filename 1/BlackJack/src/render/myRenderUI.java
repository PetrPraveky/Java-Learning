package render;
//Balíček pro render UI
import java.awt.*; //Přidání modulu awt
import javax.swing.*; //Přidání mudlu swing
import java.awt.event.*;
//Hlavní třída
public class myRenderUI extends JPanel{
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //Zjištění velikosti okna
    JButton startButton;
    
    public myRenderUI() {
        this.setPreferredSize(screenSize);
        this.setBackground(Color.black);

        this.setLayout(null);
        startButton = new JButton("Start") {
            {
                setBounds((int)screenSize.getWidth()/2-75, (int)screenSize.getHeight()-150, 150, 75);
            }
        };
        this.add(startButton);
        this.setOpaque(false);
        this.setVisible(true);
    }
}