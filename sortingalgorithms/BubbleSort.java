package sortingalgorithms;

public class BubbleSort <T extends Comparable<T>> {

    public static <T extends Comparable<T>> T[] bubbleSort(T[] input) {
        boolean swapping = true;
        while (swapping) {
            swapping = false;
            for (int i = 0; i < input.length - 1; i++) {
                if (input[i].compareTo(input[i + 1]) > 0) {
                    swap(input, i, i + 1);
                    swapping = true;
                }
            }
        }
        return input;
    }

    private static <T extends Comparable<T>> void swap(T[] arr, int indexOne, int indexTwo) {
        T temp = arr[indexTwo];
        arr[indexTwo] = arr[indexOne];
        arr[indexOne] = temp;
    }
}
