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
    Timer timer;

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //Zjištění velikosti okna


    boolean animationDone = false;
    int cardNumber = 1;
    int startingAnimationDelay = 1; int startingAnimationCardVelX = 20; int startingAnimationCardVelY = 20;

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
        cardBack = funcRenderCard.cardBack;
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
            timer = new Timer(
                startingAnimationDelay, 
                new ActionListener() {
                    void cardMoveSum() {
                        if (cardNumber==1||cardNumber==3){
                            cardMoveHand();
                        }
                        else if (cardNumber==2||cardNumber==4) {
                            cardMoveTable();
                        } else {
                            animationDone=true;
                            return;
                        }
                    }
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (animationDone==false) {
                            cardMoveSum();
                        } else {
                            animationDone=false;
                            cardNumber=1;
                            System.out.println(animationDone);
                            timer.stop();
                        }
                    }
                }
            );
            timer.start();
        }
    }
    //Animace karet
    public void cardMoveTable() {
        if (funcRenderCard.cardBackPosSize[0]<=(int)screenSize.getWidth()/2-cardBack.getWidth(null)/2+20) {
            funcRenderCard.cardBackPosSize[0]=(int)screenSize.getWidth()/2-cardBack.getWidth(null)/2;
            funcRenderCard.cardBackPosSize[0]=(int)screenSize.getHeight()/2-cardBack.getHeight(null);
            funcRenderCard.myFunctionCardReset();
            repaint();
            cardNumber++;
            return;
        } else {
            funcRenderCard.cardBackPosSize[0]=funcRenderCard.cardBackPosSize[0]-startingAnimationCardVelX;
            funcRenderCard.cardBackPosSize[1]=funcRenderCard.cardBackPosSize[1]+startingAnimationCardVelY/4;
            repaint();
        }
    }
    public void cardMoveHand() {
        if (funcRenderCard.cardBackPosSize[0]<=(int)screenSize.getWidth()/2-cardBack.getWidth(null)/2) {
            funcRenderCard.cardBackPosSize[0]=(int)screenSize.getWidth()/2-cardBack.getWidth(null)/2;
            funcRenderCard.cardBackPosSize[0]=(int)screenSize.getHeight()-funcRenderCard.cardDeckOffset[1]-cardBack.getHeight(null);
            funcRenderCard.myFunctionCardReset();
            repaint();
            cardNumber++;
            return;
        } else {
            funcRenderCard.cardBackPosSize[0]=funcRenderCard.cardBackPosSize[0]-startingAnimationCardVelX;
            funcRenderCard.cardBackPosSize[1]=funcRenderCard.cardBackPosSize[1]+startingAnimationCardVelY;
            repaint();
        }
    }
}