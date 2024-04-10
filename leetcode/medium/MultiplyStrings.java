package leetcode.medium;

import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

/*

Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"

Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"

Constraints:

- 1 <= num1.length, num2.length <= 200
- num1 and num2 consist of digits only.
- Both num1 and num2 do not contain any leading zero, except the number 0 itself.

 */

public class MultiplyStrings {

    public String multiply(String num1, String num2) {
      
        List<String> numsToAdd = new ArrayList<>();

        for (int i = num2.length() - 1; i >= 0; i--) {
            String num = "";
            int remainder = 0;
            for (int j = num1.length() - 1; j >= 0; j--) {
                int result = (Integer.parseInt(String.valueOf(num2.charAt(i))) * Integer.parseInt(String.valueOf(num1.charAt(j)))) + remainder;
                if (result >= 10) {
                    num = String.valueOf(result % 10) + num;
                    remainder = result / 10;
                } else {
                    num = String.valueOf(result) + num;
                    remainder = 0;
                }
            }
            if (remainder != 0) num = String.valueOf(remainder) + num;
            numsToAdd.add(num);
        }

        // Add the appropriate zeroes on the right side of each number
        // Example: [738, 615, 492] becomes [738, 6150, 49200]
        for (int i = 0; i < numsToAdd.size(); i++) {
            String toAdd = "0".repeat(i);
            numsToAdd.set(i, numsToAdd.get(i) + toAdd);
        }

        // Add the numbers of the list up
        String output = numsToAdd.get(0);
        for (int i = 1; i < numsToAdd.size(); i++) {
            String curr = numsToAdd.get(i);
            // Add zeroes on the left side of the shorter number
            int maxLength = Math.max(output.length(), curr.length());
            output = "0".repeat(maxLength - output.length()) + output;
            curr = "0".repeat(maxLength - curr.length()) + curr;
            // Add the two numbers up
            String currSum = "";
            int remainder = 0;
            for (int j = maxLength - 1; j >= 0; j--) {
                int result = (Integer.parseInt(String.valueOf(output.charAt(j))) + Integer.parseInt(String.valueOf(curr.charAt(j)))) + remainder;
                if (result >= 10) {
                    currSum = String.valueOf(result % 10) + currSum;
                    remainder = result / 10;
                } else {
                    currSum = String.valueOf(result) + currSum;
                    remainder = 0;
                }
            }
            if (remainder != 0) currSum = String.valueOf(remainder) + currSum;
            output = currSum;
        }

        // Remove any leftover zeroes on the left side
        int subStart = output.length() - 1;
        for (int i = 0; i < output.length() - 1; i++) {
            if (output.charAt(i) != '0') {
                subStart = i;
                break;
            }
        }
        
        return output.substring(subStart, output.length());

    }

}
