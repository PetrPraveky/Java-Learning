// Toto je je první soubor
// https://www.youtube.com/watch?v=xk4_1vDrzzo
public class App {
    public static void main(String[] args) throws Exception {
        String [][] cars = {
            {"Camero", "Corvette", "Silverado"},
            {"Mustang", "Ranger", "F-150"}, 
            {"Ferrari", "Lambo", "Tesla"}
        };

        for (int i=0; i<cars.length; i++) {
            System.out.println();
            for(int j=0; j<cars[i].length; j++) {
                System.out.print(cars[i][j]+" ");
            }
        }
    }
}
