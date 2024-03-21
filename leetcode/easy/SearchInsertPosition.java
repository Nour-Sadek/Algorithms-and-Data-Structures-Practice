package leetcode.easy;

import java.lang.Math;

/*

Given a sorted array of distinct integers and a target value, return the index if the target is found. 
If not, return the index where it would be if it were inserted in order.

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2

Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1

Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4

Constraints:

- 1 <= nums.length <= 10^4
- -10^4 <= nums[i] <= 10^4
- nums contains distinct values sorted in ascending order.
- -10^4 <= target <= 10^4

 */

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
      
        int diffFromSmall = Math.abs(target - nums[0]);
        int diffFromLarge = Math.abs(target - nums[nums.length - 1]);

        int i;
        if (diffFromSmall < diffFromLarge) {
            i = 0;
            while (i < nums.length && nums[i] < target) {
                i++;
            }
        } else {
            i = nums.length;
            while (i > 0 && nums[i - 1] >= target) {
                i--;
            }
        }

        return i;
        
    }
  
}
