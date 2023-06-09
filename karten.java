import java.util.*;

public class Kartenspiel {
    private static final String[] SORTEN = { "Herz", "Karo", "Pik", "Kreuz" };
    private static final String[] WERTE = { "7", "8", "9", "10", "Bube", "Dame", "König", "Ass" };

    public static void main(String[] args) {
        List<String> deck = erzeugeDeck();
        Collections.shuffle(deck);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Anzahl der Spieler:");
        int spielerAnzahl = scanner.nextInt();
        System.out.println("Anzahl der Runden:");
        int rundenAnzahl = scanner.nextInt();

        verteileKarten(deck, spielerAnzahl, rundenAnzahl);

        System.out.println("Flush im Deck: " + pruefeFlush(deck));
    }

    private static List<String> erzeugeDeck() {
        List<String> deck = new ArrayList<>();
        for (String sorte : SORTEN) {
            for (String wert : WERTE) {
                deck.add(wert + " von " + sorte);
            }
        }
        return deck;
    }

    private static void verteileKarten(List<String> deck, int spielerAnzahl, int rundenAnzahl) {
        if (spielerAnzahl * rundenAnzahl > deck.size()) {
            throw new IllegalArgumentException("Zu viele Spieler oder Runden für das Deck.");
        }

        for (int runde = 0; runde < rundenAnzahl; runde++) {
            System.out.println("Runde " + (runde + 1) + ":");
            for (int spieler = 0; spieler < spielerAnzahl; spieler++) {
                String karte = deck.remove(deck.size() - 1);
                System.out.println("Spieler " + (spieler + 1) + " erhält " + karte);
            }
        }
    }

    private static boolean pruefeFlush(List<String> deck) {
        Map<String, Integer> sortenZaehler = new HashMap<>();
        for (String karte : deck) {
            String sorte = karte.split(" von ")[1];
            sortenZaehler.put(sorte, sortenZaehler.getOrDefault(sorte, 0) + 1);
        }
        for (int zaehler : sortenZaehler.values()) {
            if (zaehler >= 5) {
                return true;
            }
        }
        return false;
    }
}
