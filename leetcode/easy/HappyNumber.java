package leetcode.easy;

import java.util.Set;
import java.util.HashSet;

/*

Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

- Starting with any positive integer, replace the number by the sum of the squares of its digits.
- Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
- Those numbers for which this process ends in 1 are happy.

Return true if n is a happy number, and false if not.

Example 1:

Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1

Example 2:

Input: n = 2
Output: false

 */

public class HappyNumber {

    public boolean isHappy(int n) {

        Set<Integer> passed = new HashSet<>();
        passed.add(n);
        int currentIteration = 1;
        String num = String.valueOf(n);

        while (currentIteration == passed.size()) {
          
            int sum = 0;

            for (int i = 0; i < num.length(); i++) {
                double square = Math.pow(Integer.parseInt(String.valueOf(num.charAt(i))), 2);
                sum = sum + (int) square;
            }

            if (sum == 1) return true;
            else {
                num = String.valueOf(sum);
                currentIteration++;
                passed.add(sum);
            }
          
        }

        return false;

    }
  
}
