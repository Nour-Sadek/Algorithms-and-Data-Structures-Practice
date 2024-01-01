package leetcode.easy;

import java.util.*;

/*

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:
- Open brackets must be closed by the same type of brackets.
- Open brackets must be closed in the correct order.
- Every close bracket has a corresponding open bracket of the same type.

Example 1:

Input: s = "()"
Output: true

Example 2:

Input: s = "()[]{}"
Output: true

Example 3:

Input: s = "(]"
Output: false

 */

public class ValidParentheses {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        Map<Character, Character> matches = new HashMap<>();
        matches.put('(', ')');
        matches.put('[', ']');
        matches.put('{', '}');

        int i = 0;
        while (i < s.length()) {
            char curr = s.charAt(i);
            if (matches.containsKey(curr)) stack.push(curr);
            else {
                if (stack.isEmpty()) return false;
                else {
                    char top = stack.pop();
                    if (matches.get(top) != curr) return false;
                }
            }
            i++;
        }

        return stack.isEmpty();

    }

}
