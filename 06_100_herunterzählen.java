import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Startwert der Berechnung eingeben:");
        int start = scanner.nextInt();
        System.out.println("Bis wohin gerechnet werden soll:");
        int end = scanner.nextInt();
        System.out.println("Standard-Schrittwert eineben:");
        int step = scanner.nextInt();

        System.out.println("W\u00e4hlen Sie die Art der Berechnung:");
        System.out.println("1: For-Schleife");
        System.out.println("2: While-Schleife");
        System.out.println("3: Do-While-Schleife");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                if (start > end) {
                    for (int i = start; i >= end; i -= step) {
                        System.out.println(i);
                    }
                } else {
                    for (int i = start; i <= end; i += step) {
                        System.out.println(i);
                    }
                }
                break;
            case 2:
                int i = start;
                if (start > end) {
                    while (i >= end) {
                        System.out.println(i);
                        i -= step;
                    }
                } else {
                    while (i <= end) {
                        System.out.println(i);
                        i += step;
                    }
                }
                break;
            case 3:
                i = start;
                if (start > end) {
                    do {
                        System.out.println(i);
                        i -= step;
                    } while (i >= end);
                } else {
                    do {
                        System.out.println(i);
                        i += step;
                    } while (i <= end);
                }
                break;
            default:
                System.out.println("Ung\u00dcltige Auswahl!");
        }
    }
}

// import java.util.Scanner;

// public class Main {
// public static void main(String[] args) {
// Scanner scanner = new Scanner(System.in);
// System.out.println("Bitte geben Sie den Startwert ein:");
// int start = scanner.nextInt();
// System.out.println("Bitte geben Sie den Endwert ein:");
// int end = scanner.nextInt();
// System.out.println("Bitte geben Sie den Schrittwert ein:");
// int step = scanner.nextInt();

// System.out.println("W\u00e4hlen Sie die Art der Schleife:");
// System.out.println("1: For-Schleife");
// System.out.println("2: While-Schleife");
// System.out.println("3: Do-While-Schleife");
// int choice = scanner.nextInt();

// switch (choice) {
// case 1:
// for (int i = start; i >= end; i -= step) {
// System.out.println(i);
// }
// break;
// case 2:
// int i = start;
// while (i >= end) {
// System.out.println(i);
// i -= step;
// }
// break;
// case 3:
// i = start;
// do {
// System.out.println(i);
// i -= step;
// } while (i >= end);
// break;
// default:
// System.out.println("Ung\u00dcltige Auswahl!");
// }
// }
// }