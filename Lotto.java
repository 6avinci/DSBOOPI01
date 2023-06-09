import java.util.*;

public class LottoSpiel {
    private static final int MAX_ZIEHUNG = 49;
    private static final int ZIEHUNG_ANZAHL = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> tipp = new HashSet<>();

        System.out.println("Bitte geben Sie Ihre " + ZIEHUNG_ANZAHL + " Zahlen ein (1-49):");
        while (tipp.size() < ZIEHUNG_ANZAHL) {
            int nummer = scanner.nextInt();
            if (nummer < 1 || nummer > MAX_ZIEHUNG) {
                System.out.println("Ungültige Zahl, bitte geben Sie eine Zahl zwischen 1 und 49 ein:");
            } else if (tipp.contains(nummer)) {
                System.out.println("Diese Zahl wurde bereits eingegeben, bitte geben Sie eine andere Zahl ein:");
            } else {
                tipp.add(nummer);
            }
        }

        int ziehungenVierRichtige = 0;
        int ziehungenFünfRichtige = 0;
        int ziehungen = 0;

        while (ziehungenVierRichtige == 0 || ziehungenFünfRichtige == 0) {
            Set<Integer> ziehung = ziehung();
            int richtige = richtige(tipp, ziehung);
            ziehungen++;

            if (richtige >= 4 && ziehungenVierRichtige == 0) {
                ziehungenVierRichtige = ziehungen;
            }

            if (richtige >= 5 && ziehungenFünfRichtige == 0) {
                ziehungenFünfRichtige = ziehungen;
            }
        }

        System.out.println("Vier Richtige nach " + ziehungenVierRichtige + " Ziehungen.");
        System.out.println("Fünf Richtige nach " + ziehungenFünfRichtige + " Ziehungen.");
    }

    private static Set<Integer> ziehung() {
        Set<Integer> ziehung = new HashSet<>();
        Random rand = new Random();

        while (ziehung.size() < ZIEHUNG_ANZAHL) {
            int nummer = rand.nextInt(MAX_ZIEHUNG) + 1;
            ziehung.add(nummer);
        }

        return ziehung;
    }

    private static int richtige(Set<Integer> tipp, Set<Integer> ziehung) {
        Set<Integer> intersection = new HashSet<>(tipp);
        intersection.retainAll(ziehung);
        return intersection.size();
    }
}
