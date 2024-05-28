package leetcode.easy;

import java.lang.Math;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/*

Given an integer array nums and an integer k, 
return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

Examples:

Example 1:
Input: nums = [1,2,3,1], k = 3
Output: true

Example 2:
Input: nums = [1,0,1,1], k = 1
Output: true

Example 3:
Input: nums = [1,2,3,1,2,3], k = 2
Output: false

Constraints:
- 1 <= nums.length <= 10^5
- -10^9 <= nums[i] <= 10^9
- 0 <= k <= 10^5

 */

public class ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        // Populate the map with key = number in <nums> and 
        // value = list of indices at which that number appears in <nums>
        // Example: if nums = [1, 2, 3, 1]
        // then map is: {1: [0, 3], 2: [1], 3: [2]}
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                List<Integer> indices = new ArrayList<>();
                indices.add(i);
                map.put(nums[i], indices); 
            } else {
                List<Integer> indices = map.get(nums[i]);
                indices.add(i);
            }
        }

        // For every list that has more than one value (i.e. the number appeared at least twice in <nums>),
        // check for every permutation if the absolute difference is <= k
        for (var entrySet: map.entrySet()) {
            List<Integer> indices = entrySet.getValue();
            if (indices.size() > 1) {
                for (int i = 0; i < indices.size() - 1; i++) {
                    for (int j = i + 1; j < indices.size(); j++) {
                        if (Math.abs(indices.get(i) - indices.get(j)) <= k) return true;
                    }
                }
            }
        }

        return false;

    }

}
