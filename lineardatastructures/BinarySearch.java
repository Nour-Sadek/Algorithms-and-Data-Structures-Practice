package lineardatastructures;

import java.util.Objects;

public class BinarySearch <T extends Comparable<T>> {

    public static void main(String[] args) {
        Integer[] example = {1, 2, 5, 9};
        System.out.println(BinarySearch.search(example, 5));

    }

    public static <T extends Comparable<T>> int search(T[] arr, T target) {
        int left = 0;
        int right = arr.length;

        while(right > left) {
            int mid = Math.floorDiv(left + right, 2);
            T midValue = arr[mid];

            if (Objects.equals(midValue, target)) {
                return mid;
            } else if (target.compareTo(midValue) < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        return -1;
    }
}
