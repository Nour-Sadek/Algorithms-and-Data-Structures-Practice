package leetcode.medium;

import java.util.List;
import java.util.ArrayList;

/*

Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
- Each row must contain the digits 1-9 without repetition.
- Each column must contain the digits 1-9 without repetition.
- Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

Note:
- A Sudoku board (partially filled) could be valid but is not necessarily solvable.
- Only the filled cells need to be validated according to the mentioned rules.

Example 1:

Input: board =
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true

Example 2:

Input: board =
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false

 */

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {

        List<List<Character>> columns = new ArrayList<>();
        List<List<Character>> subBoxes = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            columns.add(new ArrayList<>());
            subBoxes.add(new ArrayList<>());
        }

        for (int i = 0; i < board.length; i++) {

            List<Character> row = new ArrayList<>();
            // <index> represents index of current sub-box
            int index;
            if (i <= 2) index = 0;
            else if (i <= 5) index = 3;
            else index = 6;

            for (int j = 0; j < board.length; j++) {

                // Check if the current row is valid
                if (row.contains(board[i][j])) {
                    return false;
                } else if (board[i][j] != '.') {
                    row.add(board[i][j]);
                }

                // Check if columns are valid
                if (columns.get(j).contains(board[i][j])) {
                    return false;
                } else if (board[i][j] != '.') {
                    columns.get(j).add(board[i][j]);
                }

                // Check if the sub-boxes are valid
                if (j == 3) index = index + 1;
                else if (j == 6) index = index + 1;

                if (subBoxes.get(index).contains(board[i][j])) {
                    return false;
                } else if (board[i][j] != '.') {
                    subBoxes.get(index).add(board[i][j]);
                }

            }

        }

        return true;

    }

}
