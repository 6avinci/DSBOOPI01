import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class LottoTipp {
    public static void main(String[] args) {
        List<Integer> tipp = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (tipp.size() < 6) {
            System.out.print("Geben Sie eine Zahl zwischen 1 und 49 ein: ");
            int zahl = scanner.nextInt();

            if (zahl < 1 || zahl > 49) {
                System.out.println("Bitte geben Sie eine Zahl zwischen 1 und 49 ein!");
                continue;
            }

            if (tipp.contains(zahl)) {
                System.out.println("Bitte geben Sie keine doppelten Zahlen ein!");
                continue;
            }

            tipp.add(zahl);
        }

        scanner.close();

        List<Integer> ziehung = mischen();
        int richtige = ziehen(tipp, ziehung);
        System.out.println("Anzahl der richtigen Zahlen: " + richtige);
    }

    private static List<Integer> mischen() {
        List<Integer> nummer = new ArrayList<>();
        for (int i = 1; i <= 49; i++) {
            nummer.add(i);
        }

        List<Integer> Mische = new ArrayList<>();
        Random random = new Random();
        while (!nummer.isEmpty()) {
            int index = random.nextInt(nummer.size());
            int number = nummer.remove(index);
            Mische.add(number);
        }

        return Mische;
    }

    private static int ziehen(List<Integer> tipp, List<Integer> ziehung) {
        Set<Integer> unique = new HashSet<>(ziehung);

        int richtige = 0;
        for (int zahl : tipp) {
            if (unique.contains(zahl)) {
                richtige++;
            }
        }

        return richtige;
    }
}
