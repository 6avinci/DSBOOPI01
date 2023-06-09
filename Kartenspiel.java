import java.util.Random;

public class Kartenspiel {

    private static final String[] SYMBOLE = {"P ", "K ", "H ", "KA "};
    private static final String[] Z = {"6", "7", "8", "9", "10", "J", "D", "K", "A"};

    private static String[][] karten;

    public static void machkartenspiel() {
        karten = new String[SYMBOLE.length][Z.length];

        for (int i = 0; i < SYMBOLE.length; i++) {
            for (int j = 0; j < Z.length; j++) {
                karten[i][j] = Z[j] + SYMBOLE[i];
            }
        }
    }

    public static void mischeKarten() {
        Random random = new Random();

        for (int i = 0; i < karten.length; i++) {
            for (int j = 0; j < karten[i].length; j++) {
                int randomsymbol = random.nextInt(karten.length);
                int randomZ = random.nextInt(karten[i].length);

                String temp = karten[i][j];
                karten[i][j] = karten[randomsymbol][randomZ];
                karten[randomsymbol][randomZ] = temp;
            }
        }
    }

    public static void main(String[] args) {
        machkartenspiel();
        mischeKarten();

        int anzahlkarten = 6;
        int gesamtwiederholungen = 2;

        for (int i = 0; i < gesamtwiederholungen; i++) {
            for (int j = 0; j < anzahlkarten; j++) {
                int randomSuit = new Random().nextInt(karten.length);
                int randomRank = new Random().nextInt(karten[randomSuit].length);

                System.out.print(karten[randomSuit][randomRank]);
            }
            System.out.println();
        }
    }
}
