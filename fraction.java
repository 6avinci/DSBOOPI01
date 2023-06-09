import java.util.Scanner;

public class Fraction {

    int numerator;
    int denominator;

    // Konstruktor
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Nenner darf nicht Null sein.");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    // Grundrechenarten

    public Fraction add(Fraction b) {
        return new Fraction(this.numerator * b.denominator + this.denominator * b.numerator,
                this.denominator * b.denominator).simplify();
    }

    public Fraction subtract(Fraction b) {
        return new Fraction(this.numerator * b.denominator - this.denominator * b.numerator,
                this.denominator * b.denominator).simplify();
    }

    public Fraction multiply(Fraction b) {
        return new Fraction(this.numerator * b.numerator, this.denominator * b.denominator).simplify();
    }

    public Fraction divide(Fraction b) {
        return new Fraction(this.numerator * b.denominator, this.denominator * b.numerator).simplify();
    }

    // Erweiterte Grundrechenarten

    public Fraction power(int exponent) {
        if (exponent == 0) {
            return new Fraction(1, 1);
        }
        Fraction result = new Fraction(this.numerator, this.denominator);
        for (int i = 1; i < exponent; i++) {
            result = result.multiply(this);
        }
        return result.simplify();
    }

    public double root(int root) {
        return Math.pow((double) this.numerator / this.denominator, 1.0 / root);
    }

    // Bruchmanipulationen

    public Fraction simplify() {
        int gcd = gcd(Math.abs(this.numerator), Math.abs(this.denominator));
        return new Fraction(this.numerator / gcd, this.denominator / gcd);
    }

    public Fraction extend(int factor) {
        return new Fraction(this.numerator * factor, this.denominator * factor);
    }

    // Hilfsmethode zur Berechnung des gr\u00F6\u00DFten gemeinsamen Teilers
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    @Override
    public String toString() {
        return this.numerator + "/" + this.denominator;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Bitte geben Sie den Z\u00E4hler des ersten Bruchs ein oder 'quit' zum Beenden:");
                String input = scanner.next();
                if (input.equalsIgnoreCase("quit")) {
                    break;
                }
                int numerator1 = Integer.parseInt(input);

                System.out.println("Bitte geben Sie den Nenner des ersten Bruchs ein oder 'quit' zum Beenden:");
                input = scanner.next();
                if (input.equalsIgnoreCase("quit")) {
                    break;
                }
                int denominator1 = Integer.parseInt(input);
                Fraction fraction1 = new Fraction(numerator1, denominator1);

                System.out.println("Bitte geben Sie den Z\u00E4hler des zweiten Bruchs ein oder 'quit' zum Beenden:");
                input = scanner.next();
                if (input.equalsIgnoreCase("quit")) {
                    break;
                }
                int numerator2 = Integer.parseInt(input);

                System.out.println("Bitte geben Sie den Nenner des zweiten Bruchs ein oder 'quit' zum Beenden:");
                input = scanner.next();
                if (input.equalsIgnoreCase("quit")) {
                    break;
                }
                int denominator2 = Integer.parseInt(input);
                Fraction fraction2 = new Fraction(numerator2, denominator2);

                System.out.println(
                        "Bitte geben Sie den Exponenten f\u00FCr die Potenzierung ein oder 'quit' zum Beenden:");
                input = scanner.next();
                if (input.equalsIgnoreCase("quit")) {
                    break;
                }
                int exponent = Integer.parseInt(input);

                System.out.println("Ergebnis der Addition: " + fraction1.add(fraction2));
                System.out.println("Ergebnis der Subtraktion: " + fraction1.subtract(fraction2));
                System.out.println("Ergebnis der Multiplikation: " + fraction1.multiply(fraction2));
                System.out.println("Ergebnis der Division: " + fraction1.divide(fraction2));
                System.out.println("Ergebnis der Potenzierung des ersten Bruchs (Exponent = " + exponent + "): "
                        + fraction1.power(exponent));
                System.out.println("Ergebnis der Potenzierung des zweiten Bruchs (Exponent = " + exponent + "): "
                        + fraction2.power(exponent));

                System.out.println(
                        "Bitte geben Sie den Exponenten f\u00FCr die Wurzelberechnung ein oder 'quit' zum Beenden:");
                input = scanner.next();
                if (input.equalsIgnoreCase("quit")) {
                    break;
                }
                int root = Integer.parseInt(input);
                System.out.println("Ergebnis der Wurzelberechnung des ersten Bruchs (Wurzelexponent = " + root + "): "
                        + fraction1.root(root));
                System.out.println("Ergebnis der Wurzelberechnung des zweiten Bruchs (Wurzelexponent = " + root + "): "
                        + fraction2.root(root));

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Fehlerhafte Eingabe, bitte erneut versuchen.");
            }
        }
        scanner.close();
    }
}
