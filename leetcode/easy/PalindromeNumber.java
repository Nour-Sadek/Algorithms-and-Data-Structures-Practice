package leetcode.easy;

import java.util.List;
import java.util.ArrayList;

/*

Given an integer x, return true if x is a palindrome, and false otherwise.

Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.

Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

 */

public class PalindromeNumber {

    public boolean isPalindrome(int x) {

        if (x < 0) return false;

        List<Integer> numbers = new ArrayList<Integer>();

        int lastNumber = x % 10;
        int remainingPart = x / 10;

        numbers.add(lastNumber);

        while (remainingPart != 0) {

            lastNumber = remainingPart % 10;
            remainingPart = remainingPart / 10;

            numbers.add(lastNumber);

        }

        int i = 0;
        int j = numbers.size() - 1;

        while (i < j) {
            if (numbers.get(i) != numbers.get(j)) return false;
            i++;
            j--;
        }

        return true;

    }

}
