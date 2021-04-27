package func;

public class myFunctionCardTableHand {
    public int cardNumberHand1 = 0;
    public int cardNumberTable = 0;
    public String[] cardArrayHand1 = new String[21];
    public String[] cardArrayTable = new String[21];
    public int[] cardHandVal = new int[21];
    int cardXOffset = 4;

    public int[][] cardHand1PosSize = new int[4][40];
    
    myRandomCardDeck randomCardDeck = new myRandomCardDeck();
    myFunctionRenderCard funcRednerCard = new myFunctionRenderCard();
    
    public myFunctionCardTableHand () {
        cardHand1PosSize[2][0] = funcRednerCard.getImageMult(funcRednerCard.cardBack.getWidth(null), 2);
        cardHand1PosSize[3][0] = funcRednerCard.getImageMult(funcRednerCard.cardBack.getHeight(null), 2);
    }
    public void NewHandCard (int posX, int posY) {
        cardHand1PosSize[1][cardNumberHand1-1] = posY-64;
        cardArrayHand1[cardNumberHand1-1] = "D:/Github/Java-Learning/1/BlackJack/res/.cards/symbols/"+randomCardDeck.randomizeCards()+".png";
        
        if (cardNumberHand1==1) {
            cardHand1PosSize[0][0] = posX-funcRednerCard.cardBack.getWidth(null)*(cardNumberHand1-1);
        } else {
            cardHand1PosSize[0][0] = posX-funcRednerCard.cardBack.getWidth(null)*(cardNumberHand1-1)-cardXOffset/2;
        }
        if (cardNumberHand1>1) {
            for (int i=1; i<cardNumberHand1; i++) {
                cardHand1PosSize[0][i] = cardHand1PosSize[0][i-1]+funcRednerCard.cardBack.getWidth(null)*2+cardXOffset;
            }
        } else {}
    }
}
