package sortingalgorithms;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class QuickSort <T extends Comparable<T>> {

    public List<T> quickSort(List<T> list) {
        // Base Case
        if (list.size() <= 1) return list;

        // Choose a random pivot location
        Random random = new Random();
        int pivot = random.nextInt(list.size());

        List<T> lower = new ArrayList<>();
        List<T> higher = new ArrayList<>();

        // Partition the elements to lower or higher list based on comparisons with pivot
        for (int i = 0; i < list.size(); i++) {
            if (i == pivot) continue;
            if (list.get(i).compareTo(list.get(pivot)) < 0) {
                lower.add(list.get(i));
            } else {
                higher.add(list.get(i));
            }
        }

        List<T> output = quickSort(lower);
        output.add(list.get(pivot));
        output.addAll(quickSort(higher));

        return output;
    }

}
