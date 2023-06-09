import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LottoSpiel {
    private static final int MAX_LOTTO_NUM = 49;
    private static final int NUM_OF_PICKS = 6;

    public static void main(String[] args) {
        // Ihr Tipp
        int[] tipp = { 1, 2, 3, 4, 5, 6 };

        // Ziehung
        int[] ziehung = generateRandomNumbers();

        // Anzahl der richtigen Tipps
        int richtige = countMatches(tipp, ziehung);

        System.out.println("Ihr Tipp: " + Arrays.toString(tipp));
        System.out.println("Ziehung: " + Arrays.toString(ziehung));
        System.out.println("Sie haben " + richtige + " Richtige.");
    }

    private static int[] generateRandomNumbers() {
        Random rand = new Random();
        Set<Integer> generated = new HashSet<>();
        while (generated.size() < NUM_OF_PICKS) {
            int num = rand.nextInt(MAX_LOTTO_NUM) + 1;
            generated.add(num);
        }
        return generated.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int countMatches(int[] tipp, int[] ziehung) {
        Set<Integer> tippSet = new HashSet<>();
        for (int num : tipp) {
            tippSet.add(num);
        }

        int matches = 0;
        for (int num : ziehung) {
            if (tippSet.contains(num)) {
                matches++;
            }
        }
        return matches;
    }
}
