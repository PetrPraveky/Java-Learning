package render;
//Balíček pro hlavní render
import java.awt.*; //Přidání modulu awt
import javax.swing.*; //Přidání modulu swing
//Hlavní třída
public class myRender extends JFrame{
    myRenderCards card; //Vyrenderování karet 
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //Zjištění velikosti okna
    //Konsturktor
    public myRender() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Funkce pro vypnutí okna
        this.setUndecorated(true); //Vypnutí horní lišty
        this.setBackground(new Color(0x141414)); //Nastavení pozadí
        
        loadPanels(); //Načtení panelů
        
        this.pack();
        this.setSize(1280, 720); //Nastanení základní velikosti okna
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); //Vytvoření fullscreenu
        
        // this.setLayout(null);
        
        this.setLocation(0, 0); //Nastavení lokace na monitoru na 0x 0y
        this.setVisible(true); //Zapnutí GUI
    }

    void loadPanels() {
        card = new myRenderCards();
        this.add(card);
        this.pack();
    }
}