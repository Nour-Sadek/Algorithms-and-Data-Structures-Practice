package leetcode.medium;

import java.util.List;
import java.util.ArrayList;

/*

Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
- 0 <= a, b, c, d < n
- a, b, c, and d are distinct.
- nums[a] + nums[b] + nums[c] + nums[d] == target

You may return the answer in any order.

Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]

 */

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> output = new ArrayList<>();

        if (nums.length < 4) return output;

        List<List<Integer>> uniqueValues = new ArrayList<>();

        for (int i = 0; i < nums.length - 3; i++) {
            int first = nums[i];
            for (int j = i + 1; j < nums.length - 2; j++) {
                int second = nums[j];
                for (int k = j + 1; k < nums.length - 1; k++) {
                    int third = nums[k];
                    for (int l = k + 1; l < nums.length; l++) {
                        int fourth = nums[l];
                        if (first + second + third + fourth == target) {
                            List<Integer> innerList = new ArrayList<>();
                            innerList.add(first);
                            innerList.add(second);
                            innerList.add(third);
                            innerList.add(fourth);

                            boolean shouldAdd = true;
                            for (int p = 0; p < uniqueValues.size(); p++) {
                                if (uniqueValues.get(p).containsAll(innerList) && innerList.containsAll(uniqueValues.get(p))) {
                                    shouldAdd = false;
                                    break;
                                }
                            }

                            if (shouldAdd) {
                                output.add(innerList);
                                uniqueValues.add(innerList);
                            }


                        }

                    }
                }
            }
        }

        return output;

    }

}
