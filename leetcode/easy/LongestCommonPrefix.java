package leetcode.easy;

/*

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.

 */

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        String common = strs[0];

        if (common.isEmpty()) return common;

        for (int i = 1; i < strs.length; i++) {

            common = commonPrefix(common, strs[i]);

            if (common.isEmpty()) return common;

        }

        return common;

    }

    private static String commonPrefix(String first, String second) {

        String common = "";

        int i = 0;
        int j = 0;

        while (i < first.length() && j < second.length()) {

            if (first.charAt(i) == second.charAt(j)) {
                common = common + first.charAt(i);
            } else {
                break;
            }

            i++;
            j++;
        }

        return common;
    }

}
