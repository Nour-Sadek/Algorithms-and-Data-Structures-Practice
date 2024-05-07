package leetcode.easy;

import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;

/*

Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.

Example 1:

Input: pattern = "abba", s = "dog cat cat dog"
Output: true

Example 2:

Input: pattern = "abba", s = "dog cat cat fish"
Output: false

Example 3:

Input: pattern = "aaaa", s = "dog cat cat dog"
Output: false

Constraints:

- 1 <= pattern.length <= 300
- pattern contains only lower-case English letters.
- 1 <= s.length <= 3000
- s contains only lowercase English letters and spaces ' '.
- s does not contain any leading or trailing spaces.
- All the words in s are separated by a single space.

 */

public class WordPattern {

    public boolean wordPattern(String pattern, String s) {

        Map<String, String> map = new HashMap<>();
        String[] words = s.split(" ");
        String[] letters = pattern.split("");

        if (words.length != letters.length) return false;

        int i = 0;
        while (i < words.length) {
            String letter = letters[i];
            String word = words[i];

            if (!map.containsKey(letter)) {
                map.put(letter, word);
            } else {
                if (!map.get(letter).equals(word)) return false;
            }

            i++;
        }

        HashSet<String> valuesSet = new HashSet<>(map.values());
        
        return map.keySet().size() == valuesSet.size();
        
    }

}
