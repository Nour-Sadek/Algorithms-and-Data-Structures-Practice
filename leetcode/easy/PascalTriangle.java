package leetcode.easy;

import java.util.List;
import java.util.ArrayList;

/*

Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it.

For Example, if numRows = 5, then the triangle will look like this:
    1
   1 1
  1 2 1
 1 3 3 1
1 4 6 4 1

Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

Example 2:

Input: numRows = 1
Output: [[1]]

Constraints:

1 <= numRows <= 30

 */

public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> output = new ArrayList<>();
        
        output.add(List.of(1));
        if (numRows == 1) return output;

        output.add(List.of(1, 1));
        if (numRows == 2) return output;

        for (int i = 2; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> previousRow = output.get(i - 1);
            // Add the first value (always 1)
            row.add(1);
            // Fill the values in the middle
            for (int j = 1; j < i; j++) row.add(previousRow.get(j - 1) + previousRow.get(j));
            // Add the last value (always 1)
            row.add(1);
            output.add(row);
        }

        return output;

    }

}
