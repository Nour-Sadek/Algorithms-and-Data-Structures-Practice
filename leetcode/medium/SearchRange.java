package leetcode.medium;

/*

Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

Example: 1

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Example 3:

Input: nums = [], target = 0
Output: [-1,-1]

Constraints:

- 0 <= nums.length <= 10^5
- -10^9 <= nums[i] <= 10^9
- nums is a non-decreasing array.
- -10^9 <= target <= 10^9

 */

public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
      
        int[] output = {-1, -1};

        int i = 0;
        int j = nums.length - 1;

        boolean keepIMoving = true;
        boolean keepJMoving = true;

        while (i <= j && (keepIMoving || keepJMoving)) {
            if (keepIMoving) {
                if (nums[i] != target) i++;
                else {
                    output[0] = i;
                    keepIMoving = false;
                }
            }

            if (keepJMoving) {
                if (nums[j] != target) j--;
                else {
                    output[1] = j;
                    keepJMoving = false;
                }
            }      
        }

        return output;

    }

}
