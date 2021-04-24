package render;
//Balíček pro render karet
import java.awt.*; //Přidání modulu awt
import javax.swing.*; //Přidání mudlu swing
import java.awt.event.*;
// import func.*;
//Hlavní třída
public class myRenderCards extends JPanel implements ActionListener{
    String cardBackFile = "D:/Github/Java-Learning/1/BlackJack/res/.cards/back1.png"; //Umístění textury zadní strany karty
    String cardDeckFile = "D:/Github/Java-Learning/1/BlackJack/res/.cards/cardStackBig-back1.png";

    myRenderUI ui = new myRenderUI();
    
    Image cardDeck = new ImageIcon(cardDeckFile).getImage(); //Vytvoření obrázku pro balíček karet
    Image cardBack = new ImageIcon(cardBackFile).getImage(); //Vytvoření obrázku pro zadní část karty

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //Zjištění velikosti okna
    
    final int[] cardDeckOffset = { //Hodnota odsazení od kraje
        128, //X-ová hodnota
        96 //Y-ová hodnota
    }; 

    //Konsturktor
    public myRenderCards() {
        this.setLayout(new FlowLayout());
        this.add(ui);
        ui.startButton.addActionListener(this);
        repaint();
    }
    //Funkce pro render
    @Override
    public void paint(Graphics g) {
        cardDeck = new ImageIcon(cardDeckFile).getImage(); //Vytvoření obrázku pro balíček karet
        cardBack = new ImageIcon(cardBackFile).getImage(); //Vytvoření obrázku pro zadní část karty

        int[] cardDeckPosSize = {
            (int)screenSize.getWidth()-cardDeckOffset[0]-getImageMult(cardDeck.getWidth(null), 2), //X Pozice
            cardDeckOffset[1], //Y Pozice
            getImageMult(cardDeck.getWidth(null), 2), //Velikost textury po ose X
            getImageMult(cardDeck.getHeight(null), 2), //Velikost textury po ose Y
        };

        super.paint(g);
        Graphics2D g2D = (Graphics2D) g; //Zadání rederu
        //Vykreslení balíčku karet
        g2D.drawImage(
            cardDeck, //Textura
            cardDeckPosSize[0], //X Pozice
            cardDeckPosSize[1], //Y Pozice
            cardDeckPosSize[2], //Velikost textury po ose X
            cardDeckPosSize[3], //Velikost textury po ose Y
            null //null
            );
    }
    //Funkce pro vypočítání výsledné velikosti textury
    int getImageMult(int baseLenght, int multipl) {
        int lenght = baseLenght*multipl; //Vypočítání velikosti
        return lenght; //Vrácení hodnoty
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Start")) {
            System.out.println("Clicked");
            cardDeckFile = "D:/Github/Java-Learning/1/BlackJack/res/.cards/cardStackSmall-back1.png";
            repaint();
        }
    }

}