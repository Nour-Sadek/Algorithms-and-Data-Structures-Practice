package hackerrank.arrays.medium;

import java.util.List;

/*

Task Description:

It is New Year's Day and people are in line for the Wonderland roller coaster ride.
Each person wears a sticker indicating their initial position in the queue from 1 to n.
Any person can bribe the person directly in front of them to swap positions, but they still wear their original sticker.
One person can bribe at most two others.

Determine the minimum number of bribes that took place to get to a given queue order.
Print the number of bribes, or, if anyone has bribed more than two people, print Too chaotic.

Example

q = [1, 2, 3, 5, 4, 6, 7, 8]
If person 5 bribes person 4, the queue will look like this: 1, 2, 3, 5, 4, 6, 7, 8. Only 1 bribe is required. Print 1.

q = [4, 1, 2, 3]
Person 4 had to bribe 3 people to get to the current position. Print Too chaotic.

---------------------------------------------------------

Function Description:

Complete the function minimumBribes, which has the following parameters:
    - int q[n]: the positions of the people after all bribes
    Returns: No value is returned. Print the minimum number of bribes necessary or Too chaotic if someone has bribed more than 2 people.

---------------------------------------------------------

Constraints:

1 <= n <= 10^5

 */


public class NewYearChaos {

    public static void minimumBribes(List<Integer> q) {
        int totalNumOfBribes = 0;

        for (int i = q.size() - 1; i >= 0; i--) {
            int numberAtCurrIndex = q.get(i);

            if (numberAtCurrIndex - i > 3) {
                System.out.println("Too chaotic");
                return;
            }

            int mostPossibleBribes = q.size() - numberAtCurrIndex;
            for (int j = i - 1; j >= 0 && mostPossibleBribes > 0; j--) {
                if (q.get(j) > q.get(i)) {
                    totalNumOfBribes++;
                    mostPossibleBribes--;
                }
            }

        }

        System.out.println(totalNumOfBribes);

    }
}
