package leetcode.medium;

/*

Given a positive integer n, generate an n x n matrix filled with elements from 1 to n^2 in spiral order.

Example: 1

Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]

Example 2:

Input: n = 1
Output: [[1]]

Constraints:

1 <= n <= 20

 */

public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {

        int[][] output = new int[n][n];
        
        if (n == 1) {
            output[0][0] = 1;
            return output;
        }

        int progress = 1;
        int i = 0;  // row
        int j = 0;  // column
        boolean keepIFixed = true;
        boolean iIncreasing = true;
        boolean jIncreasing = true;

        while (progress <= n * n) {
            output[i][j] = progress++;
            if (keepIFixed) {
                if (jIncreasing) {
                    if (j == n - 1 || output[i][j + 1] != 0) {
                        jIncreasing = false;
                        keepIFixed = false;
                        if (iIncreasing) i++;
                        else i--;
                    } else j++;
                } else {
                    if (j == 0 || output[i][j - 1] != 0) {
                        jIncreasing = true;
                        keepIFixed = false;
                        if (iIncreasing) i++;
                        else i--;
                    } else j--;
                }
            } else {
                if (iIncreasing) {
                    if (i == n - 1 || output[i + 1][j] != 0) {
                        iIncreasing = false;
                        keepIFixed = true;
                        if (jIncreasing) j++;
                        else j--;
                    } else i++;
                } else {
                    if (i == 0 || output[i - 1][j] != 0) {
                        iIncreasing = true;
                        keepIFixed = true;
                        if (jIncreasing) j++;
                        else j--;
                    } else i--;
                }
            }
        }

        return output;
    }

}
