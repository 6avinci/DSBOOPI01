import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class DateTimeOut {
    public static void main(String[] args) {
        LocalDate jetzt = LocalDate.now();
        DateTimeFormatter forat = DateTimeFormatter.ofPattern(
                "EEEE, d. MMMM yyyy");
        System.out.println("**************************************");
        System.out.println("                       ");
        System.out.println("Heute ist " + forat.format(jetzt) + "!");
        System.out.println("                       ");
        System.out.println("Willkommen in DSBOOPI01");
        System.out.println("                       ");
        System.out.println("**************************************");
    }
}