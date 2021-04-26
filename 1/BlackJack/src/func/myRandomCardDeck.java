package func;
//Balíček pro níhodné generování karet
import java.util.*; //Vložení modulu util

public class myRandomCardDeck {
    Random rand = new Random(); //Náhodné generování
    String[] cardDeck = { //Balíček karet
        "club-A", "club-2", "club-3", "club-4", "club-5", "club-6", "club-7", "club-8", "club-9", "club-10", "club-J", "club-Q", "club-K", //První blaíček
        "dia-A", "dia-2", "dia-3", "dia-4", "dia-5", "dia-6", "dia-7", "dia-8", "dia-9", "dia-10", "dia-J", "dia-Q", "dia-K",
        "heart-A", "heart-2", "heart-3", "heart-4", "heart-5", "heart-6", "heart-7", "heart-8", "heart-9", "heart-10", "heart-J", "heart-Q", "heart-K",
        "spade-A", "spade-2", "spade-3", "spade-4", "spade-5", "spade-6", "spade-7", "spade-8", "spade-9", "spade-10", "spade-J", "spade-Q", "spade-K",
    };
    //Konstruktor
    public myRandomCardDeck() {
        // System.out.println(Arrays.toString(randomizeCards(cardDeck)));

    }

    String randomizeCards() {
        int randomIndex = rand.nextInt(cardDeck.length);
        String card = cardDeck[randomIndex];
        return card;
    }
}
