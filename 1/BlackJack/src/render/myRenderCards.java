package render;
//Balíček pro render karet
import java.awt.*; //Přidání modulu awt
import javax.swing.*; //Přidání mudlu swing
//Hlavní třída
public class myRenderCards extends JPanel{
    Image cardDeck; //Vytvoření obrázku pro balíček karet

    public myRenderCards() {
        cardDeck = new ImageIcon("D:/Github/Java-Learning/1/BlackJack/res/.cards/cardStackBig-back1.png").getImage(); //Přidání textury pro balíček karet
        this.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize())); //Vykreslení okna
    }
    //Funkce pro render
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g; //Zadání rederu
        //Vykreslení balíčku karet
        g2D.drawImage(
            cardDeck, //Textura
            0, //X Pozice
            0, //Y Pozice
            getImageMult(cardDeck.getWidth(null), 2), //Velikost textury po ose X
            getImageMult(cardDeck.getHeight(null), 2), //Velikost textury po ose Y
            null //null
            );
    }
    //Funkce pro vypočítání výsledné velikosti textury
    int getImageMult(int baseLenght, int multipl) {
        int Lenght = baseLenght*multipl; //Vypočítání velikosti
        return Lenght; //Vrácení hodnoty
    }
}