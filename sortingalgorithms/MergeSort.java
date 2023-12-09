package sortingalgorithms;

import java.util.List;
import java.util.ArrayList;

public class MergeSort <T extends Comparable<T>> {

    public List<T> sort(List<T> arr) {
        int length = arr.size();
        if (length <= 1) {
            return arr;
        }
        int mid = length / 2;
        List<T> leftArray = arr.subList(0, mid);
        List<T> rightArray = arr.subList(mid, length);
        return merge(sort(leftArray), sort(rightArray));
    }

    public List<T> merge(List<T> left, List<T> right) {
        List<T> merged = new ArrayList<T>();
        int leftPos = 0;
        int rightPos = 0;

        while (leftPos < left.size() && rightPos < right.size()) {
            if (left.get(leftPos).compareTo(right.get(rightPos)) < 0) {
                merged.add(left.get(leftPos));
                leftPos++;
            } else {
                merged.add(right.get(rightPos));
                rightPos++;
            }
        }

        // Add remaining elements from left list
        if (leftPos < left.size()) {
            for (int i = leftPos; i < left.size(); i++) {
                merged.add(left.get(i));
            }
        }

        // Add remaining elements from right list
        if (rightPos < right.size()) {
            for (int i = rightPos; i < right.size(); i++) {
                merged.add(right.get(i));
            }
        }

        return merged;
    }

}
