package leetcode.medium;

/*

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows,
and then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows.

Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Explanation:
P   A   H   N
A P L S I I G
Y   I   R

Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I

Example 3:

Input: s = "A", numRows = 1
Output: "A"

Constraints:

1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000

 */

public class ZigZagConversion {

    public String convert(String s, int numRows) {

        if (numRows == 1) return s;

        int length = s.length();
        String output = "";

        int firstDiff = (numRows - 1) * 2;
        int secondDiff = 0;

        for (int i = 0; i < numRows && i < length; i++) {
            output += s.charAt(i);

            int next = i;

            while (next < length) {
                if (firstDiff != 0) {
                    next = next + firstDiff;
                    if (next < length) {
                        output += s.charAt(next);
                    }
                }
                if (secondDiff != 0) {
                    next = next + secondDiff;
                    if (next < length) {
                        output += s.charAt(next);
                    }
                }
            }

            firstDiff -= 2;
            secondDiff += 2;
        }

        return output;

    }

}
