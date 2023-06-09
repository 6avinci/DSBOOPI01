import java.util.Scanner;

public class AngepassteMultiplikationstabelle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bitte geben Sie eine Ganzzahl ein:");
        int n = scanner.nextInt();

        int[][] multiplikationstabelle = erstelleMultiplikationstabelle(n);
        ausgabeMultiplikationstabelle(multiplikationstabelle, n);
    }

    public static int[][] erstelleMultiplikationstabelle(int n) {
        int[][] tabelle = new int[n][n];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                tabelle[i - 1][j - 1] = i * j;
            }
        }

        return tabelle;
    }

    public static void ausgabeMultiplikationstabelle(int[][] tabelle, int n) {
        int anzahlBloeckeProZeile = (int) Math.ceil(Math.sqrt(n));

        for (int i = 0; i < tabelle.length; i++) {
            for (int k = 0; k < tabelle.length; k += anzahlBloeckeProZeile) {
                for (int j = 0; j < anzahlBloeckeProZeile; j++) {
                    if (k + j < tabelle.length) {
                        System.out.printf("%-16s", (i + 1) + "x" + (k + j + 1) + "=" + tabelle[i][k + j]);
                    }
                }
                System.out.println();
            }
            System.out.println();
            System.out.println(); // Eine zusätzliche Zeile zwischen den Blöcken

            if ((i + 1) % anzahlBloeckeProZeile == 0) {
                System.out.println();
            }
        }
    }
}
