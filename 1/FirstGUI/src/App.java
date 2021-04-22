import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;

//Program na vytvoření základního GUI
//https://www.youtube.com/watch?v=xk4_1vDrzzo

public class App {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame(); //Vytvoří rám

        frame.setTitle("JFrame title goes brrrr"); //Nastaví titulek pro okno
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Funkce pro vypnutí aplikace
        frame.setResizable(false); //Zakázání změny velikosti okna
        frame.setSize(420,420); //nastaví x a y velikost

        ImageIcon image = new ImageIcon(".//image//app.png"); //Vytvoření ikony programu
        frame.setIconImage(image.getImage()); //Nastavení ikony programu
        frame.getContentPane().setBackground(new Color(0xcecece)); //změní barvičku

        frame.setVisible(true); //Nastaní rám na vyditělný
    }
}
