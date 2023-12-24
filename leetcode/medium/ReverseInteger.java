package leetcode.medium;

import java.util.List;
import java.util.ArrayList;

/*

Given a signed 32-bit integer x, return x with its digits reversed.
If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Example 1:

Input: x = 123
Output: 321

Example 2:

Input: x = -123
Output: -321

Example 3:

Input: x = 120
Output: 21

 */

public class ReverseInteger {

    public int reverse(int x) {

        boolean isNegative;
        if (x < 0) {
            isNegative = true;
            x = -x;
        } else {
            isNegative = false;
        }

        if (x == 0) return 0;

        List<Integer> reversedNumber = new ArrayList<>();

        int lastNumber = x % 10;
        int remainingPart = x / 10;

        reversedNumber.add(lastNumber);

        while (remainingPart != 0) {
            lastNumber = remainingPart % 10;
            remainingPart = remainingPart / 10;

            reversedNumber.add(lastNumber);
        }

        // Remove any leading zeroes
        boolean remove = reversedNumber.get(0) == 0;

        while (remove) {
            reversedNumber.remove(0);
            remove = reversedNumber.get(0) == 0;
        }

        // Return reversed number or 0 in case of Exception
        String requiredNumber = "";

        for (int digit: reversedNumber) {
            requiredNumber = requiredNumber + digit;
        }

        try {
            int output = Integer.parseInt(requiredNumber);
            return isNegative ? - output : output;
        } catch (NumberFormatException e) {
            return 0;
        }

    }

}
