package hackerrank.arrays.easy;

import java.util.List;
import java.util.ArrayList;

/*

Task Description:

A left rotation operation on an array shifts each of the array's elements 1 unit to the left.
For example, if 2 left rotations are performed on array [1, 2, 3, 4, 5], then the array would become [3, 4, 5, 1, 2].
Note that the lowest index item moves to the highest index in a rotation. This is called a circular array.

Given an array <a> of <n> integers and a number, <d>, perform <d> left rotations on the array. Return the updated array.

---------------------------------------------------------

Function Description:

Complete the function rotLeft, which has the following parameters:
    - int a[n]: the array to rotate
    - int d: the number of rotations
    Returns: int a'[n]: the rotated array

---------------------------------------------------------

Constraints:

1 <= d <= n
1 <= n <= 10^5

 */

public class LeftRotation {

    public static List<Integer> rotLeft(List<Integer> a, int d) {
        int lengthOfList = a.size();
        if (lengthOfList == d) return a;

        List<Integer> rotatedList = new ArrayList<>();

        for (int i = d; i < lengthOfList; i++) {
            rotatedList.add(a.get(i));
        }

        for (int i = 0; i < d; i++) {
            rotatedList.add(a.get(i));
        }

        return rotatedList;

    }
}
