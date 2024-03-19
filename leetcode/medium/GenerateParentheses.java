package leetcode.medium;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

/*

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example: 1

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:

Input: n = 1
Output: ["()"]

Constraints: 1 <= n <= 8

 */

public class GenerateParentheses {

    public static char OP = '(';
    public static char ED = ')';

    public List<String> generateParenthesis(int n) {

        // Generate every possible permutation that starts with <OP>
        List<String> combos = new ArrayList<>();
        combos.add("(");
        int curr = 1;

        while (curr < n * 2) {
            List<String> copy = new ArrayList<>(combos);
            combos.clear();

            for (String combo: copy) {
                // Count number of OP and ED strings
                long opCount = combo.chars().filter(ch -> ch == OP).count();
                long edCount = combo.chars().filter(ch -> ch == ED).count();
                if (opCount < n) {
                    combos.add(combo + OP);
                }
                if (edCount < n) {
                    combos.add(combo + ED);
                }
            }

            curr++;
        }

        // Check every generated permutation if it is valid
        List<String> valid = new ArrayList<>();
        for (String possibleCombo: combos) {
            Stack<Character> stack = new Stack<>();
            for (int i = possibleCombo.length() - 1; i >= 0; i--) {
                stack.push(possibleCombo.charAt(i));
            }

            int countOp = 0;

            while (!stack.isEmpty()) {
                char letter = stack.pop();
                if (letter == OP) countOp++;
                else {
                    if (countOp > 0) countOp--;
                    else break;
                }
            }

            if (stack.isEmpty()) valid.add(possibleCombo);
        }

        return valid;
        
    }

}
