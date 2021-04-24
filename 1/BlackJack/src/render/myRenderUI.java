package render;
//Balíček pro render UI
import java.awt.*; //Přidání modulu awt
import javax.swing.*; //Přidání mudlu swing
import java.awt.event.*;
//Hlavní třída
public class myRenderUI extends JPanel implements ActionListener{
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //Zjištění velikosti okna
    JButton startButton;
    
    public myRenderUI() {
        this.setPreferredSize(screenSize);

        this.setLayout(null);
        startButton = new JButton("Start") {
            {
                setBounds((int)screenSize.getWidth()/2-75, (int)screenSize.getHeight()-150, 150, 75);
            }
        };
        this.add(startButton);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Start")) {
            System.out.println("Clicked");
        }
    }
}
