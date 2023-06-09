import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] arr = { 45, 7, 88, 102, 1, 3, 50 };
        System.out.println("Original Array: " + Arrays.toString(arr));
        int[] shuffledAndSortedArray = sortArray(shuffleArray(arr));
        System.out.println("Gemischt und sortiertes Array: " + Arrays.toString(shuffledAndSortedArray));
    }

    public static int[] shuffleArray(int[] arr) {
        int[] shuffledArray = arr.clone();
        Random rand = new Random();
        for (int i = 0; i < shuffledArray.length; i++) {
            int randomIndexToSwap = rand.nextInt(shuffledArray.length);
            int temp = shuffledArray[randomIndexToSwap];
            shuffledArray[randomIndexToSwap] = shuffledArray[i];
            shuffledArray[i] = temp;
        }
        return shuffledArray;
    }

    public static int[] sortArray(int[] arr) {
        int[] sortedArray = arr.clone();
        quickSort(sortedArray, 0, sortedArray.length - 1);
        return sortedArray;
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return (i + 1);
    }
}
