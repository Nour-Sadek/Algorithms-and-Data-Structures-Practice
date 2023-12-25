package leetcode.medium;

/*

Given the head of a linked list, rotate the list to the right by k places.

Example 1:

Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]

Example 2:

Input: head = [0,1,2], k = 4
Output: [2,0,1]

 */

public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {

        // One run to determine the size of the list
        int size = 0;
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            size++;
            prev = curr;
            curr = curr.next;
        }

        if (size == 0) return head;

        // True number of rotations
        int numOfRotations = k % size;

        if (numOfRotations != 0) {
            // Make last Node's next be the current head
            prev.next = head;

            // Determine the new head
            prev = null;
            curr = head;

            while (size != numOfRotations) {
                size--;
                prev = curr;
                curr = curr.next;
            }

            prev.next = null;
            head = curr;
        }

        return head;

    }

}
