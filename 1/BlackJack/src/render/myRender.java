package render;
//Balíček pro hlavní render
import java.awt.*; //Přidání modulu awt
import java.io.FileReader;
import javax.swing.*; //Přidání modulu swing
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
//Hlavní třída
public class myRender extends JFrame{
    myRenderCards card; //Vyrenderování karet
    JSONParser parser = new JSONParser();
    // Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //Zjištění velikosti okna
    //Konsturktor
    public myRender() {
        try {
            Object obj = parser.parse(new FileReader("D:/Github/Java-Learning/1/BlackJack/src/render/DataRender.json"));
            JSONObject jsonObject = (JSONObject) obj;

            Long screenSizeX = (Long)jsonObject.get("screenSizeX");
            Long screenSizeY = (Long)jsonObject.get("screenSizeY");

            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Funkce pro vypnutí okna
            this.setUndecorated(false); //Vypnutí horní lišty
            this.setBackground(new Color(0x141414)); //Nastavení pozadí
            
            loadPanels(); //Načtení panelů
            
            this.pack();
            this.setSize(screenSizeX.intValue(), screenSizeY.intValue()); //Nastanení základní velikosti okna
            // this.setExtendedState(JFrame.MAXIMIZED_BOTH); //Vytvoření fullscreenu
            
            // this.setLayout(null);
            
            this.setLocation(0, 0); //Nastavení lokace na monitoru na 0x 0y
            this.setVisible(true); //Zapnutí GUI
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    void loadPanels() {
        card = new myRenderCards();
        this.add(card);
        this.pack();
    }
}