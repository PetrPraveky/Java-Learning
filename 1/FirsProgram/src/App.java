// Toto je je první soubor
// https://www.youtube.com/watch?v=xk4_1vDrzzo
import java.util.ArrayList;
public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<String> food = new ArrayList<String>();

        food.add("pizza");
        food.add("hamburger");
        food.add("hotdog");

        food.clear();

        for (int i=0; i<food.size(); i++) {
            System.out.println(food.get(i));
        }
    }   
}
