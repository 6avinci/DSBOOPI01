public class Schachbrett {
    private String[][] brett;

    public Schachbrett() {
        brett = new String[8][8];
        // Initialisiere das Brett mit den Anfangspositionen der Figuren
        // ...
    }

    public String getFigur(String position) {
        int[] koordinaten = konvertierePosition(position);
        return brett[koordinaten[0]][koordinaten[1]];
    }

    public List<String> moeglicheZuege(String position) {
        String figur = getFigur(position);
        if (figur == null || !figur.endsWith("T")) {
            throw new IllegalArgumentException("Kein Turm an der angegebenen Position.");
        }

        List<String> zuege = new ArrayList<>();
        int[] koordinaten = konvertierePosition(position);

        // Horizontal und vertikal bewegen
        for (int richtung = -1; richtung <= 1; richtung += 2) {
            for (int i = 1; i < 8; i++) {
                int zeile = koordinaten[0] + i * richtung;
                if (zeile >= 0 && zeile < 8) {
                    zuege.add(konvertiereKoordinaten(new int[] { zeile, koordinaten[1] }));
                }

                int spalte = koordinaten[1] + i * richtung;
                if (spalte >= 0 && spalte < 8) {
                    zuege.add(konvertiereKoordinaten(new int[] { koordinaten[0], spalte }));
                }
            }
        }

        return zuege;
    }

    private int[] konvertierePosition(String position) {
        int spalte = position.charAt(0) - 'a';
        int zeile = 8 - Character.getNumericValue(position.charAt(1));
        return new int[] { zeile, spalte };
    }

    private String konvertiereKoordinaten(int[] koordinaten) {
        char spalte = (char) ('a' + koordinaten[1]);
        int zeile = 8 - koordinaten[0];
        return "" + spalte + zeile;
    }
}
