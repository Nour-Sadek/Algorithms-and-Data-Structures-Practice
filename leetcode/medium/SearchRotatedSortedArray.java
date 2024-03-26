package leetcode.medium;

/*

There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) 
such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). 
For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

Example: 1

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

Example 3:

Input: nums = [1], target = 0
Output: -1

 */

public class SearchRotatedSortedArray {

    public int search(int[] nums, int target) {
      
        int left = 0;
        int right = nums.length - 1;

        // Determine where the pivot is
        while (left < right - 1) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            }
        }

        int k = left;
        if (nums[k] == target) return k;

        // Determine new left and right values depending on pivot
        if (nums[nums.length - 1] < target) {
            left = 0;
            right = k;
        } else {
            left = k + 1;
            right = nums.length;
        }

        // Do normal binary search
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid;
        }

        return -1;

    }

}
