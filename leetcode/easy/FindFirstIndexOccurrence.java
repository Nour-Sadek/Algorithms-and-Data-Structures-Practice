package leetcode.easy;

/*

Given two strings needle and haystack, return the index of the first occurrence of needle in haystack,
or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.

Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.

Constraints:

- 1 <= haystack.length, needle.length <= 10^4
- haystack and needle consist of only lowercase English characters.

 */

public class FindFirstIndexOccurrence {

    public int strStr(String haystack, String needle) {
        char firstNeedle = needle.charAt(0);
        int targetLength = needle.length();
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == firstNeedle) {
                int currLength = 1;
                int curr = i + 1;
                String word = String.valueOf(firstNeedle);
                while (currLength < targetLength && curr < haystack.length()) {
                    if (haystack.charAt(curr) == needle.charAt(currLength)) {
                        word = word + String.valueOf(haystack.charAt(curr));
                        currLength++;
                        curr++;
                    } else {
                        break;
                    }
                }
                if (word.equals(needle)) return i;
            }
        }
        return -1;

    }

}
