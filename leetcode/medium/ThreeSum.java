package leetcode.medium;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/*

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] 
such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Example: 1

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.

Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.

Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.

 */

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
      
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();

        int i = 0;
        int j = i + 1;

        while (i < nums.length - 2) {

            while (j < nums.length - 1) {
                int firstFixed = nums[i];
                int secondFixed = nums[j];

                for (int k = j + 1; k < nums.length; k++) {
                    int possible = firstFixed + secondFixed + nums[k];

                    if (possible == 0) {
                        List<Integer> combo = List.of(firstFixed, secondFixed, nums[k]);
                        if (!output.contains(combo)) output.add(combo);
                        break;
                    } else if (possible > 0 && k == j + 1) {
                        j = nums.length;
                        break;
                    } else if (possible > 0) break;
                }

                j++;
            }

            i++;
            j = i + 1;

        }

        return output;
        
    }

}
