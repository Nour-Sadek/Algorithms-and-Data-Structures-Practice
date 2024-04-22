package leetcode.easy;

import java.lang.Math;

/*

Given a string columnTitle that represents the column title as appears in an Excel sheet, return its corresponding column number.

For example:
A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 
...

Examples:

Example 1:
Input: columnTitle = "A"
Output: 1

Example 2:
Input: columnTitle = "AB"
Output: 28

Example 3:
Input: columnTitle = "ZY"
Output: 701

Constraints:
- 1 <= columnTitle.length <= 7
- columnTitle consists only of uppercase English letters.
- columnTitle is in the range ["A", "FXSHRXW"].

 */

public class ExcelSheetColumnNumber {

    public int titleToNumber(String columnTitle) {

        // Rationale: "ZY" value = 26^0 * Integer('Y') + 26^1 * Integer('Z')
        int output = 0;
        int exponent = 0;

        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            // ASCII value of 'A' is 65 but for excel 'A' == 1
            // so subtract 64 from the integer value of the letter characters 
            int letterValue = columnTitle.charAt(i) - 64;
            output += Math.pow(26, exponent++) * letterValue;
        }

        return output;

    }

}
