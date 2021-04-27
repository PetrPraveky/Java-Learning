package render;
//Balíček pro render karet
import java.awt.*; //Přidání modulu awt
import javax.swing.*; //Přidání mudlu swing
import java.awt.event.*;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
// import java.util.Arrays;
import func.*;
//Hlavní třída
public class myRenderCards extends JPanel implements ActionListener{
    myRenderUI ui = new myRenderUI();
    myFunctionRenderCard funcRenderCard = new myFunctionRenderCard();
    myFunctionCardTableHand funcHandTableCard = new myFunctionCardTableHand();

    JSONParser parser = new JSONParser();

    Image cardDeck; Image cardBack;
    Timer timer;

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //Zjištění velikosti okna

    boolean animationDone = false;
    int cardNumber = 1;
    int startingAnimationDelay = 1; 
    
    int startingAnimationCardVelX;
    int startingAnimationCardVelY;

    //Konsturktor
    public myRenderCards() {
        try {
            Object obj = parser.parse(new FileReader("D:/Github/Java-Learning/1/BlackJack/src/render/DataRender.json"));
            JSONObject jsonObject = (JSONObject) obj;
            
            Long screenSizeX = (Long)jsonObject.get("screenSizeX");
            Long screenSizeY = (Long)jsonObject.get("screenSizeY");

            startingAnimationCardVelX = (int)((funcRenderCard.cardDeckPosSize[0]-(screenSizeX.intValue()/2-funcRenderCard.cardBack.getWidth(null)))/25); 
            startingAnimationCardVelY = (int)(((screenSizeY.intValue()-funcRenderCard.cardDeckOffset[1]-funcRenderCard.cardBack.getHeight(null)-64)-funcRenderCard.cardDeckPosSize[1])/25);

            this.setPreferredSize(new Dimension(screenSizeX.intValue(), screenSizeY.intValue()));
    
            this.setLayout(new FlowLayout());
    
            this.add(ui);
            ui.startButton.addActionListener(this);
    
            this.setBackground(Color.black);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    //Funkce pro render
    @Override
    public void paintComponent(Graphics g) {
        // funcRenderCard.myFunctionCardReset();
        cardDeck = funcRenderCard.cardDeck; //Vytvoření obrázku pro balíček karet
        cardBack = funcRenderCard.cardBack;
        super.paintComponent(g);
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
        if (funcHandTableCard.cardNumberHand1>0) {
            for (int i=0; i<funcHandTableCard.cardNumberHand1;i++) {
                g2D.drawImage(
                    new ImageIcon(funcHandTableCard.cardArrayHand1[i]).getImage(),
                    funcHandTableCard.cardHand1PosSize[0][i],
                    funcHandTableCard.cardHand1PosSize[1][i],
                    funcRenderCard.cardBackPosSize[2],
                    funcRenderCard.cardBackPosSize[3],
                    null
                );
            }
            g2D.dispose();
        } else {}
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
                            timer.stop();
                        }
                    }
                }
            );
            ui.startButton.setVisible(false);
            timer.start();
        }
    }
    //Animace karet
    public void cardMoveTable() {
        if (funcRenderCard.cardBackPosSize[0]<=(int)screenSize.getWidth()/2-cardBack.getWidth(null)) {
            funcRenderCard.cardBackPosSize[0]=(int)screenSize.getWidth()/2-cardBack.getWidth(null)/2;
            funcRenderCard.cardBackPosSize[0]=(int)screenSize.getHeight()/2-cardBack.getHeight(null);
            funcRenderCard.myFunctionCardReset();

            repaint();
            cardNumber++;
            return;
        } else {
            funcRenderCard.cardBackPosSize[0]=funcRenderCard.cardBackPosSize[0]-startingAnimationCardVelX;
            repaint();
        }
    }
    public void cardMoveHand() {
        if (funcRenderCard.cardBackPosSize[0]<=(int)screenSize.getWidth()/2-cardBack.getWidth(null)) {
            funcRenderCard.cardBackPosSize[0]=(int)screenSize.getWidth()/2-cardBack.getWidth(null);
            funcRenderCard.cardBackPosSize[0]=(int)screenSize.getHeight()-funcRenderCard.cardDeckOffset[1]-cardBack.getHeight(null)-64;
            funcRenderCard.myFunctionCardReset();

            funcHandTableCard.cardNumberHand1++;
            funcHandTableCard.NewHandCard((int)screenSize.getWidth()/2-cardBack.getWidth(null), (int)screenSize.getHeight()-funcRenderCard.cardDeckOffset[1]-cardBack.getHeight(null));

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