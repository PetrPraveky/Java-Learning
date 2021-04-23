package render;
//Balíček pro render karet
import java.awt.*; //Přidání modulu awt
import javax.swing.*; //Přidání mudlu swing
// import func.*;
//Hlavní třída
public class myRenderCards extends JPanel{
    Image cardDeck; //Vytvoření obrázku pro balíček karet
    Image cardBack; //Vytvoření obrázku pro zadní část karty
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //Zjištění velikosti okna
    final int[] cardDeckOffset = { //Hodnota odsazení od kraje
        128, //X-ová hodnota
        96 //Y-ová hodnota
    }; 
    String cardDeckFile = "D:/Github/Java-Learning/1/BlackJack/res/.cards/cardStackBig-back1.png"; //Umístění textury balíčku karet
    String cardBackFIle = "D:/Github/Java-Learning/1/BlackJack/res/.cards/back1.png"; //Umístění textury zadní strany karty

    //Konsturktor
    public myRenderCards() {
        cardDeck = new ImageIcon(cardDeckFile).getImage(); //Přidání textury pro balíček karet
        cardBack = new ImageIcon(cardBackFIle).getImage(); //Přidání textury pro zadní část karty
        // this.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize())); //Vykreslení okna
    }
    //Funkce pro render
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g; //Zadání rederu
        //Vykreslení balíčku karet
        g2D.drawImage(
            cardDeck, //Textura
            (int)screenSize.getWidth()-cardDeckOffset[0]-getImageMult(cardDeck.getWidth(null), 2), //X Pozice
            cardDeckOffset[1], //Y Pozice
            getImageMult(cardDeck.getWidth(null), 2), //Velikost textury po ose X
            getImageMult(cardDeck.getHeight(null), 2), //Velikost textury po ose Y
            null //null
            );
    }
    //Funkce pro vypočítání výsledné velikosti textury
    int getImageMult(int baseLenght, int multipl) {
        int lenght = baseLenght*multipl; //Vypočítání velikosti
        return lenght; //Vrácení hodnoty
    }
    //Funkce časovače

}