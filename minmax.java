public class Main {
    public static void main(String[] args) {
        int[] arr = { 45, 7, 88, 102, 1, 3, 50 };
        findMinMax(arr);
    }

    public static void findMinMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("Das Array ist leer oder nicht existent.");
            return;
        }

        int min = arr[0];
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            } else if (arr[i] > max) {
                max = arr[i];
            }
        }

        System.out.println("Das kleinste Element ist: " + min);
        System.out.println("Das größte Element ist: " + max);
    }
}
