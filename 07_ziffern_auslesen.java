import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte geben Sie eine positive ganze Zahl ein:");
        int num = scanner.nextInt();

        String text = "";
        while (num > 0) {
            int digit = num % 10;
            switch (digit) {
                case 0:
                    text = "Null " + text;
                    break;
                case 1:
                    text = "Eins " + text;
                    break;
                case 2:
                    text = "Zwei " + text;
                    break;
                case 3:
                    text = "Drei " + text;
                    break;
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
            num /= 10;
        }
        System.out.println(text.trim());
    }
}
