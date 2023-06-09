import java.util.Scanner;

public class ErweiterteRechenarten {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bitte geben Sie die erste Zahl ein:");
        double zahl1 = scanner.nextDouble();

        System.out.println("Bitte geben Sie die zweite Zahl ein (falls notwendig, sonst 0):");
        double zahl2 = scanner.nextDouble();

        System.out.println("Bitte w\u00e4hlen Sie eine Operation: +, -, *, /, %, ^, Wurzel");
        String operation = scanner.next();

        double ergebnis = 0;

        switch (operation) {
            case "+":
                ergebnis = zahl1 + zahl2;
                break;
            case "-":
                ergebnis = zahl1 - zahl2;
                break;
            case "*":
                ergebnis = zahl1 * zahl2;
                break;
            case "/":
                if (zahl2 == 0) {
                    System.out.println("Teilen durch Null ist nicht erlaubt.");
                    System.exit(1);
                }
                ergebnis = zahl1 / zahl2;
                break;
            case "%":
                ergebnis = zahl1 * zahl2 / 100;
                break;
            case "^":
                ergebnis = Math.pow(zahl1, zahl2);
                break;
            case "Wurzel":
                if (zahl1 < 0) {
                    System.out.println("Wurzelziehen aus negativen Zahlen ist nicht erlaubt.");
                    System.exit(1);
                }
                ergebnis = Math.sqrt(zahl1);
                break;
            default:
                System.out.println("Ungültige Operation.");
                System.exit(1);
        }

        System.out.println("Ergebnis: " + ergebnis);
    }
}
