import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Los geht's, wieder einmal reden wir über die Konsole mit uns selbst...
        Scanner scanner = new Scanner(System.in);
        while (true) { // Nach Zahlen zu fragen, ist wie nach Ärger zu fragen, aber wir versuchen es
                       // mal...
            System.out.println("Bitte geben Sie positive ganze Zahlen ein, getrennt durch Kommata:");
            String input = scanner.nextLine();
            String[] numbers = input.split(",");
            for (String number : numbers) { // Schauen wir mal, ob wir das geparst entziffern können.
                try {
                    int num = Integer.parseInt(number.trim());
                    if (num < 0) { // Ups, das ist kein gutes Zeichen. Zeit für einen Kurzschluss!
                        throw new NumberFormatException();
                    } // Wenn wir es bis hierher geschafft haben, behandeln wir diese Nummer wie ein
                      // rohes Ei.
                    processNumber(num);
                } catch (NumberFormatException e) { // Upps, da ist wohl etwas schief gelaufen. Zeit, den Benutzer zu
                                                    // blamen.
                    System.out.println("Ung\u00dcltige Eingabe: " + number);
                }
            }
        }
    }

    private static void processNumber(int num) {
        // Hier beginnt die Magie... oder das Chaos, je nachdem, wen man fragt.
        String text = "";
        int sum = 0;
        int position = 1;
        while (num > 0) { // Moment, wie viele Finger hat diese Nummer nochmal?
            int digit = num % 10;
            sum += digit; // Ok, jetzt kennen wir die Nummer. Zeit, sie bei ihrem Namen zu nennen.
            switch (digit) {
                case 0:
                    text = "Null " + text;
                    break; // und so weiter...
                case 1:
                    text = "Eins " + text;
                    break; // und so weiter...
                case 2:
                    text = "Zwei " + text;
                    break; // und so weiter...
                case 3:
                    text = "Drei " + text;
                    break; // .....
                case 4:
                    text = "Vier " + text;
                    break;
                case 5:
                    text = "F\u00dcnf " + text;
                    break;
                case 6:
                    text = "Sechs " + text;
                    break;
                case 7:
                    text = "Sieben " + text;
                    break;
                case 8:
                    text = "Acht " + text;
                    break;
                case 9:
                    text = "Neun " + text;
                    break;
            }
            switch (position) {
                case 1:
                    text = "Einheiten: " + text;
                    break;
                case 2:
                    text = "Zehner: " + text;
                    break;
                case 3:
                    text = "Hunderter: " + text;
                    break;
                case 4:
                    text = "Tausender: " + text;
                    break;
                case 5:
                    text = "Zentausender: " + text;
                    break;
                case 6:
                    text = "Hunderttausender: " + text;
                    break;
                case 7:
                    text = "Millionen: " + text;
                    break;
                // Hier könnten ihre Werbung stehen
            }
            text = "\n" + text;
            num /= 10;
            position++;
        } // Und zum Schluss... Trommelwirbel bitte... die Quersumme!
        text = "Quersumme: " + sum + text;
        System.out.println(text);
    }
}
