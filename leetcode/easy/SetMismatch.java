package leetcode.easy;

import java.util.Set;
import java.util.HashSet;

/*

You have a set of integers s, which originally contains all the numbers from 1 to n. 
Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, 
which results in repetition of one number and loss of another number.

You are given an integer array nums representing the data status of this set after the error.

Find the number that occurs twice and the number that is missing and return them in the form of an array.

Example 1:

Input: nums = [1,2,2,4]
Output: [2,3]

Example 2:

Input: nums = [1,1]
Output: [1,2]

 */

public class SetMismatch {

    public int[] findErrorNums(int[] nums) {

       // Fill in the set with all the numbers in range
       Set<Integer> arrayNums = new HashSet<>();
       for (int i = 1; i <= nums.length; i++) arrayNums.add(i);

       int repeatedNum = -1;

       // Remove all numbers from <arrayNums> that appear in <nums>, so the missing number remains in <arrayNums> and 
       // the repeated number is caught
       for (int num: nums) {
        if (!arrayNums.contains(num)) repeatedNum = num;
        else arrayNums.remove(num);
       }

       // <arrayNums> should only have one number, the one missing from <nums>
       int missingNum = arrayNums.iterator().next(); 

       return new int[] {repeatedNum, missingNum};

    }
  
}
