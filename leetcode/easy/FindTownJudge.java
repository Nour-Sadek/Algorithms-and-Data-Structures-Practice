package leetcode.easy;

import java.util.*;

/*

In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi.
If a trust relationship does not exist in trust array, then such a trust relationship does not exist.

Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.

Example 1:

Input: n = 2, trust = [[1,2]]
Output: 2

Example 2:

Input: n = 3, trust = [[1,3],[2,3]]
Output: 3

Example 3:

Input: n = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1

 */

public class FindTownJudge {

    public int findJudge(int n, int[][] trust) {

        // This array stores false if the person i at index i - 1 doesn't trust anyone and true otherwise
        boolean[] trustSomeone = new boolean[n];

        // This map will store a set for each person, where the set will be filled with those people who trust the person associated with the key
        Map<Integer, Set<Integer>> whoTrustsThem = new HashMap<>();

        // Fill the map with key: value pairs where the values are empty HashSets
        for (int i = 1; i <= n; i++) {
            whoTrustsThem.put(i, new HashSet<Integer>());
        }

        // Change the status of both array and map
        for (int i = 0; i < trust.length; i++) {
            int[] pair = trust[i];

            int a = pair[0];
            int b = pair[1];

            trustSomeone[a - 1] = true;
            whoTrustsThem.get(b).add(a);
        }

        // Check if there is only one person (only one false value) that doesn't trust anyone
        int count = 0;
        int person = -1;
        for (int i = 0; i < trustSomeone.length; i++) {
            if (!trustSomeone[i] && count < 1) {
                count++;
                person = i;
            } else if (trustSomeone[i]) continue;
            else {
                person = -1;
                break;
            }

        }

        if (person == -1) return -1;

        // Check if the only person that doesn't trust anyone has it so that everyone trusts them
        return whoTrustsThem.get(person + 1).size() == n - 1 ? person + 1 : -1;

    }

}
