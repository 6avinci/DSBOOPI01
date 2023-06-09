import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class ErweiterteSchaltjahrBerechnung {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bitte geben Sie ein Jahr ein:");
        int jahr = scanner.nextInt();

        boolean istSchaltjahr = istSchaltjahr(jahr);
        System.out.println(jahr + (istSchaltjahr ? " ist ein Schaltjahr." : " ist kein Schaltjahr."));

        int naechstesSchaltjahr = findeNaechstesSchaltjahr(jahr);
        System.out.println("Das n\u00e4chste Schaltjahr ist: " + naechstesSchaltjahr);

        LocalDate naechsterSchalttag = LocalDate.of(naechstesSchaltjahr, 2, 29);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String naechsterSchalttagFormatiert = naechsterSchalttag.format(formatter);
        System.out.println("Der n\u00e4chste Schalttag ist der " + naechsterSchalttagFormatiert);

        LocalDate heute = LocalDate.now();
        long tageBisNaechsterSchalttag = ChronoUnit.DAYS.between(heute, naechsterSchalttag);
        System.out.println("Die Anzahl der Tage zwischen heute (" + heute.format(formatter)
                + ") und dem n\u00e4chsten Schalttag betr\u00e4gt: " + tageBisNaechsterSchalttag);

        LocalDate anfangAktuellesJahr = LocalDate.of(jahr, 1, 1);
        long tageBisNaechsterSchalttagVonAnfangJahr = ChronoUnit.DAYS.between(anfangAktuellesJahr, naechsterSchalttag);
        System.out.println(
                "Die Anzahl der Tage zwischen dem Anfang des aktuellen Jahres (" + anfangAktuellesJahr.format(formatter)
                        + ") und dem n\u00e4chsten Schalttag betr\u00e4gt: " + tageBisNaechsterSchalttagVonAnfangJahr);
    }

    private static boolean istSchaltjahr(int jahr) {
        return (jahr % 4 == 0 && (jahr % 100 != 0 || jahr % 400 == 0));
    }

    private static int findeNaechstesSchaltjahr(int jahr) {
        int naechstesJahr = jahr + 1;
        while (!istSchaltjahr(naechstesJahr)) {
            naechstesJahr++;
        }
        return naechstesJahr;
    }
}
