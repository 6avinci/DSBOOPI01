import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[][] chessBoard = {
                { "..", "..", "..", "..", "..", "..", "..", ".." },
                { "QW", "..", "..", "..", "..", "..", "..", "BS" },
                { "..", "..", "PS", "..", "..", "..", "BS", ".." },
                { "..", "..", "..", "..", "..", "BS", "..", ".." },
                { "..", "..", "..", "..", "..", "BW", "..", ".." },
                { "..", "..", "BS", "..", "..", "..", "BW", ".." },
                { "..", "..", "..", "TS", "..", "..", "..", "BW" },
                { "..", "..", "KW", "..", "KS", "..", "..", ".." },
        };

        printChessBoard(chessBoard);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Geben Sie eine Schachnotation ein (z.B. e4): ");
        String position = scanner.nextLine();
        String piece = getPieceAtPosition(chessBoard, position);
        System.out.println("Inhalt der Position " + position + ": " + piece);

        System.out.print("Geben Sie eine Schachfigur ein (z.B. PS): ");
        String figure = scanner.nextLine();
        String[] possibleMoves = calculatePossibleMoves(chessBoard, figure, position);
        System.out.println("M�gliche Z�ge f�r die Figur " + figure + " von der Position " + position + ":");
        for (String move : possibleMoves) {
            System.out.print(move + " ");
        }
        System.out.println();
    }

    public static void printChessBoard(String[][] chessBoard) {
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard[i].length; j++) {
                System.out.print(chessBoard[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static String getPieceAtPosition(String[][] chessBoard, String position) {
        int row = 8 - Character.getNumericValue(position.charAt(1));
        int col = position.charAt(0) - 'a';
        return chessBoard[row][col];
    }

    public static String[] calculatePossibleMoves(String[][] chessBoard, String figure, String position) {
        int row = 8 - Character.getNumericValue(position.charAt(1));
        int col = position.charAt(0) - 'a';

        switch (figure) {
            case "PS": // Bauer
                return calculatePawnMoves(chessBoard, row, col);
            case "BS": // L�ufer
                return calculateBishopMoves(chessBoard, row, col);
            case "TS": // Turm
                return calculateRookMoves(chessBoard, row, col);
            case "KW": // K�nig
                return calculateKingMoves(chessBoard, row, col);
            case "KS": // Springer
                return calculateKnightMoves(chessBoard, row, col);
            case "BW": // K�nigin
                return calculateQueenMoves(chessBoard, row, col);
            default:
                return new String[0]; // Ung�ltige Schachfigur
        }
    }

    private static String[] calculatePawnMoves(String[][] chessBoard, int row, int col) {
        // Implementiere die Logik zur Berechnung der m�glichen Z�ge f�r einen Bauer
        // basierend auf der aktuellen Stellung auf dem Schachbrett
        // Gib die m�glichen Z�ge als Array von Positionen zur�ck

        // Beispiel:
        String[] possibleMoves = { "d2", "d3", "d4" }; // Dummy-Werte, bitte entsprechend anpassen

        return possibleMoves;
    }

    private static String[] calculateBishopMoves(String[][] chessBoard, int row, int col) {
        // Implementiere die Logik zur Berechnung der m�glichen Z�ge f�r einen L�ufer
        // basierend auf der aktuellen Stellung auf dem Schachbrett
        // Gib die m�glichen Z�ge als Array von Positionen zur�ck

        // Beispiel:
        String[] possibleMoves = { "c3", "e3", "g5" }; // Dummy-Werte, bitte entsprechend anpassen

        return possibleMoves;
    }

    private static String[] calculateRookMoves(String[][] chessBoard, int row, int col) {
        // Implementiere die Logik zur Berechnung der m�glichen Z�ge f�r einen Turm
        // basierend auf der aktuellen Stellung auf dem Schachbrett
        // Gib die m�glichen Z�ge als Array von Positionen zur�ck

        // Beispiel:
        String[] possibleMoves = { "a4", "b4", "c4" }; // Dummy-Werte, bitte entsprechend anpassen

        return possibleMoves;
    }

    private static String[] calculateKingMoves(String[][] chessBoard, int row, int col) {
        // Implementiere die Logik zur Berechnung der m�glichen Z�ge f�r einen K�nig
        // basierend auf der aktuellen Stellung auf dem Schachbrett
        // Gib die m�glichen Z�ge als Array von Positionen zur�ck

        // Beispiel:
        String[] possibleMoves = { "e7", "f7", "g7" }; // Dummy-Werte, bitte entsprechend anpassen

        return possibleMoves;
    }

    private static String[] calculateKnightMoves(String[][] chessBoard, int row, int col) {
        // Implementiere die Logik zur Berechnung der m�glichen Z�ge f�r einen Springer
        // basierend auf der aktuellen Stellung auf dem Schachbrett
        // Gib die m�glichen Z�ge als Array von Positionen zur�ck

        // Beispiel:
        String[] possibleMoves = { "c5", "e5", "f6" }; // Dummy-Werte, bitte entsprechend anpassen

        return possibleMoves;
    }

    private static String[] calculateQueenMoves(String[][] chessBoard, int row, int col) {
        // Implementiere die Logik zur Berechnung der m�glichen Z�ge f�r eine K�nigin
        // basierend auf der aktuellen Stellung auf dem Schachbrett
        // Gib die m�glichen Z�ge als Array von Positionen zur�ck

        // Beispiel:
        String[] possibleMoves = { "d1", "d3", "d5" }; // Dummy-Werte, bitte entsprechend anpassen

        return possibleMoves;
    }
}