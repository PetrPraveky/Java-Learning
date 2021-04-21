// Toto je je první soubor
// https://www.youtube.com/watch?v=xk4_1vDrzzo
import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {

        ArrayList<ArrayList<String>> groceryList = new ArrayList<>();

        ArrayList<String> bakeryList = new ArrayList<>();
        bakeryList.add("pasta");
        bakeryList.add("garlic bread");
        bakeryList.add("donuts");
        groceryList.add(bakeryList);

        ArrayList<String> produceList = new ArrayList<>();
        produceList.add("tomato");
        produceList.add("zucchini");
        produceList.add("peppers");
        groceryList.add(produceList);

        ArrayList<String> drinkList = new ArrayList<>();
        drinkList.add("soda");
        drinkList.add("coffee");
        groceryList.add(drinkList);

        System.out.println(groceryList.get(0).get(0));
    }   
}
