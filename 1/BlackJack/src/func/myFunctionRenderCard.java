package func;
import java.awt.*; //Přidání modulu awt
import javax.swing.*; //Přidání mudlu swing
// import java.util.*;

public class myFunctionRenderCard {
    public Image cardDeck; public Image cardBack;
    public int[] cardDeckPosSize = new int[4]; public int[] cardBackPosSize = new int[4];
    
    public final int[] cardDeckOffset = { //Hodnota odsazení od kraje
        128, //X-ová hodnota
        96 //Y-ová hodnota
    };

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //Zjištění velikosti okna
    
    public myFunctionRenderCard() {
        cardDeck = new ImageIcon("D:/Github/Java-Learning/1/BlackJack/res/.cards/cardStackBig-back1.png").getImage(); //Vytvoření obrázku pro balíček karet
        cardBack = new ImageIcon("D:/Github/Java-Learning/1/BlackJack/res/.cards/back1.png").getImage(); //Vytvoření obrázku pro zadní část karty
        
        cardDeckPosSize[0] = (int)screenSize.getWidth()-cardDeckOffset[0]-getImageMult(cardDeck.getWidth(null), 2); //X Pozice
        cardDeckPosSize[1] = cardDeckOffset[1]; //Y Pozice
        cardDeckPosSize[2] = getImageMult(cardDeck.getWidth(null), 2); //Velikost textury po ose X
        cardDeckPosSize[3] = getImageMult(cardDeck.getHeight(null), 2); //Velikost textury po ose Y

        cardBackPosSize[0] = (int)screenSize.getWidth()-cardDeckOffset[0]-getImageMult(cardDeck.getWidth(null), 2); //X Pozice
        cardBackPosSize[1] = cardDeckOffset[1]; //Y Pozice
        cardBackPosSize[2] = getImageMult(cardBack.getWidth(null), 2); //Velikost textury po ose X
        cardBackPosSize[3] = getImageMult(cardBack.getHeight(null), 2); //Velikost textury po ose X


    }
    public void myFunctionCardReset() {
        cardBackPosSize[0] = (int)screenSize.getWidth()-cardDeckOffset[0]-getImageMult(cardDeck.getWidth(null), 2); //X Pozice
        cardBackPosSize[1] = cardDeckOffset[1]; //Y Pozice
        cardBackPosSize[2] = getImageMult(cardBack.getWidth(null), 2); //Velikost textury po ose X
        cardBackPosSize[3] = getImageMult(cardBack.getHeight(null), 2); //Velikost textury po ose X
    }
    //Funkce pro vypočítání výsledné velikosti textury
    int getImageMult(int baseLenght, int multipl) {
        int lenght = baseLenght*multipl; //Vypočítání velikosti
        return lenght; //Vrácení hodnoty
    }
}
