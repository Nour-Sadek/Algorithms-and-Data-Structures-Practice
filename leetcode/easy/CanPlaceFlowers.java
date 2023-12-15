package leetcode.easy;

/*

You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.

Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n,
return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.

Examples:

Example 1:

Input: flowerbed = [1,0,0,0,1], n = 1
Output: true

Example 2:

Input: flowerbed = [1,0,0,0,1], n = 2
Output: false

 */

public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        if (n == 0) return true;

        if (flowerbed.length == 1) {
            if (flowerbed[0] == 0) {
                n--;
                return n <= 0;
            } else {
                return false;
            }
        }

        if (flowerbed.length > 1) {

            // Checking for beginning case
            if (flowerbed[0] == 0 && flowerbed[1] == 0) {
                flowerbed[0] = 1;
                n--;
            }

            // Checking for ending case
            if (flowerbed[flowerbed.length - 1] == 0 && flowerbed[flowerbed.length - 2] == 0) {
                flowerbed[flowerbed.length - 1] = 1;
                n--;
            }

        }

        boolean counter = false;

        for (int i = 0; i < flowerbed.length && n > 0; i++) {
            
            if (flowerbed[i] == 0 && !counter) {
                counter = true;
            } else if (flowerbed[i] == 0 && counter) {
                if (i != flowerbed.length - 1) {
                    if (flowerbed[i + 1] == 0) {
                        n--;
                    }
                    counter = false;
                }
            } else {
                counter = false;
            }

        }

        return n <= 0;

    }

}
