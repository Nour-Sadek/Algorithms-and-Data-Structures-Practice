package leetcode.medium;

import java.util.Arrays;

/*

You are given an integer array nums of size n and a positive integer k.

Divide the array into one or more arrays of size 3 satisfying the following conditions:
- Each element of nums should be in exactly one array.
- The difference between any two elements in one array is less than or equal to k.

Return a 2D array containing all the arrays. If it is impossible to satisfy the conditions, return an empty array.
And if there are multiple answers, return any of them.

Example 1:

Input: nums = [1,3,4,8,7,9,3,5,1], k = 2
Output: [[1,1,3],[3,4,5],[7,8,9]]
Explanation: We can divide the array into the following arrays: [1,1,3], [3,4,5] and [7,8,9].
The difference between any two elements in each array is less than or equal to 2.
Note that the order of elements is not important.

Example 2:

Input: nums = [1,3,3,2,7,3], k = 3
Output: []
Explanation: It is not possible to divide the array satisfying all the conditions.

Constraints:
- n == nums.length
- 1 <= n <= 105
- n is a multiple of 3.
- 1 <= nums[i] <= 10^5
- 1 <= k <= 10^5

 */

public class DivideArray {

    public int[][] divideArray(int[] nums, int k) {

        int[][] output = new int[nums.length / 3][3];
        Arrays.sort(nums);

        int i = 0;
        int j = nums.length - 1;
        int index = 0;

        while (i < j) {

            if (nums[i + 2] - nums[i] > k || nums[j] - nums[j - 2] > k) return new int[][] {};

            if (j - i == 2) {
                output[index] = new int[] {nums[i], nums[i + 1], nums[i + 2]};
            } else {
                output[index] = new int[] {nums[i], nums[i + 1], nums[i + 2]};
                output[++index] = new int[] {nums[j], nums[j - 1], nums[j - 2]};
                index++;
            }

            i = i + 3;
            j = j - 3;

        }

        return output;

    }

}
