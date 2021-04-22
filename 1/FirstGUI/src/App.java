import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

//Program na vytvoření základního GUI
//https://www.youtube.com/watch?v=xk4_1vDrzzo

public class App {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame(); //Vytvoří rám
        JLabel label = new JLabel(); //Vytvoří label
        Border border = BorderFactory.createLineBorder(Color.green, 3); //Vytvoří rámeček

        label.setText("Hej, programuješ vůbec?"); //Nastaví text labelu
        label.setForeground(new Color(0xcecece)); //Dá barvu textu
        label.setFont(new Font("Arial",Font.PLAIN,20)); //Nastaví font
        label.setBackground(Color.black); // Nastaví pozadí labelu
        label.setOpaque(true); //Roztáhne pozadí lablu na celou plochu rámu
        label.setBorder(border); //Nastaví rámeček
        label.setVerticalAlignment(JLabel.CENTER); //Posune label do středu po ose Y
        label.setHorizontalAlignment(JLabel.CENTER); //Posune label do středu po ose X

        frame.setTitle("JFrame title goes brrrr"); //Nastaví titulek pro okno
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Funkce pro vypnutí aplikace
        frame.setResizable(false); //Zakázání změny velikosti okna
        frame.setSize(420,420); //nastaví x a y velikost
        
        frame.add(label);

        frame.setVisible(true); //Nastaní rám na vyditělný

        ImageIcon image = new ImageIcon(".//image//app.png"); //Vytvoření ikony programu
        frame.setIconImage(image.getImage()); //Nastavení ikony programu
        // frame.getContentPane().setBackground(new Color(0xcecece)); //změní barvičku
    }
}
