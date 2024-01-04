package leetcode.medium;

import java.util.*;

/*

Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
typically using all the original letters exactly once.

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Example 2:

Input: strs = [""]
Output: [[""]]

Example 3:

Input: strs = ["a"]
Output: [["a"]]

Constraints:
- 1 <= strs.length <= 104
- 0 <= strs[i].length <= 100
- strs[i] consists of lowercase English letters.

 */

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String word: strs) {
            char[] curr = word.toCharArray();
            Arrays.sort(curr);
            String sorted = new String(curr);
            if (map.containsKey(sorted)) {
                map.get(sorted).add(word);
            } else {
                List<String> lst = new ArrayList<>();
                lst.add(word);
                map.put(sorted, lst);
            }
        }

        List<List<String>> output = new ArrayList<>();

        for (String key: map.keySet()) {
            output.add(map.get(key));
        }

        return output;

    }

}
