//Soubor mé textové hry
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
public class App {
    public static void main(String[] args) throws Exception {
        //Rozdělení na pár částí - 3 konkrétně, podle rozhodování konec
        Scanner scanner = new Scanner(System.in);
        // Hlavní "nabídka"
            //Vypsání hlavní nabídky
        System.out.println("\tVýtej v této krátké adventuře");
        System.out.println("Tvým úkolem je se správně rozhodovat a vzít si jeden ze tří konců");
        System.out.println("\n Bude odpovídat způsobem vypsání do řádku možností, které budou v []");
        //Cyklus systému pro zadávání možností
        while (true) {
            System.out.println("\tJe vše jasné? [Y] [N]"); //Vypsní možností
            String option = scanner.nextLine(); //Zaznamenání hodnot uživatelského vstupu
            if (option.equals("Y")||option.equals("N")) { //Testuje, jaká je odpověď, pokud-li je neplatná, nezlomí cyklus
                break; //Pokud-li je platná, cyklus zlomí
            }
        }
        TimeUnit.SECONDS.sleep(1); //Uspí program na jednu vteřinu
        int reputation = 5;
        //První část
            //Vypsání textu první části
        System.out.println("\n- Probudil ses ve vesnici, dle nábytku u lékaře, nic si nepamatuješ."); TimeUnit.SECONDS.sleep(1);
        System.out.println("- Náhle ale slyšíš něčí hlas..."); TimeUnit.SECONDS.sleep(1);
        System.out.println("\"Konečně si ses probral, už jsme si mysleli, že takto budeš ležet napořád.\", řekl hlas"); TimeUnit.SECONDS.sleep(1);
        System.out.println("\"Pamatuješ si něco z posledního týdne?\""); TimeUnit.SECONDS.sleep(1);
        System.out.println("\"Omlouvám se, ale mám v hlavě mlhu, ani nevím, kde jsem...\", odpověděl si."); TimeUnit.SECONDS.sleep(1);
        System.out.println("\"Škoda, mohl jsi nám řící, co se stalo v té vesnici, nevadí. Chceš pomoci se zvednout?\""); TimeUnit.SECONDS.sleep(1);
            //První volba
        while (true) {
            System.out.println("\t [Y] - Ano | [N] - Ne"); //Možnosti "ano" a "ne"
            String option = scanner.nextLine(); //Zaznamenání hodnot uživatelského vstupu
            if (option.equals("Y")) { //Testuje, zda-li je odpověď ano
                System.out.println("\"Ano, necítím se na tolik dobře, že bych se mohl sám postavit\""); //Vypíše text
                break; //Zlomí cyklus
            }
            else if (option.equals("N")) { //Testuje, zda-li je odpověď ne
                System.out.println("\"Ne děkuji, cítím se celkem zdráv\""); //Vypíše text
                reputation++; System.out.println("\t\t\t\t\t\t\tPřidána reputace za rychlé uzdravení"); //Přidá reputaci
                break; //Zlomí cyklus
            } //Pokud-li je odpověď jiná, cyklus se opaku
        }
        TimeUnit.SECONDS.sleep(1); //Uspí program na jednu vteřinu
    }
}