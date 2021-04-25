package render;
//Balíček pro render karet
import java.awt.*; //Přidání modulu awt
import javax.swing.*; //Přidání mudlu swing
import java.awt.event.*;
// import java.util.concurrent.*;
import func.*;
//Hlavní třída
public class myRenderCards extends JPanel implements ActionListener{
    myRenderUI ui = new myRenderUI();
    myFunctionRenderCard funcRenderCard = new myFunctionRenderCard();
    Image cardDeck; Image cardBack;

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //Zjištění velikosti okna

    Timer timer;

    //Konsturktor
    public myRenderCards() {
        this.setLayout(new FlowLayout());

        this.add(ui);
        ui.startButton.addActionListener(this);

        this.setBackground(Color.black);
        repaint();
    }
    //Funkce pro render
    @Override
    public void paint(Graphics g) {
        // funcRenderCard.myFunctionCardReset();

        cardDeck = funcRenderCard.cardDeck; //Vytvoření obrázku pro balíček karet
        cardBack = funcRenderCard.cardBack; //Vytvoření obrázku pro zadní část karty

        super.paint(g);
        Graphics2D g2D = (Graphics2D) g; //Zadání rederu
        //Vykreslení balíčku karet
        g2D.drawImage(
            cardDeck, //Textura
            funcRenderCard.cardDeckPosSize[0], //X Pozice
            funcRenderCard.cardDeckPosSize[1], //Y Pozice
            funcRenderCard.cardDeckPosSize[2], //Velikost textury po ose X
            funcRenderCard.cardDeckPosSize[3], //Velikost textury po ose Y
            null //null
            );
        g2D.drawImage(
            cardBack,
            funcRenderCard.cardBackPosSize[0], //X Pozice
            funcRenderCard.cardBackPosSize[1], //Y Pozice
            funcRenderCard.cardBackPosSize[2], //Velikost textury po ose X
            funcRenderCard.cardBackPosSize[3], //Velikost textury po ose Y)
            null
            );
        
    };

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Start")) {
            System.out.println("Started");
            // funcRenderCard.cardDeck = new ImageIcon("D:/Github/Java-Learning/1/BlackJack/res/.cards/cardStackSmall-back1.png").getImage();
            timer = new Timer(50, this);
        }
    }
    void myStartCardAnimation() {}
}