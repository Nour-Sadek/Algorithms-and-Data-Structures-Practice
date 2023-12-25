package leetcode.medium;

/*

Given the head of a linked list, remove the nth node from the end of the list and return its head.

Example 1:

Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Example 2:

Input: head = [1], n = 1
Output: []

Example 3:

Input: head = [1,2], n = 1
Output: [1]

Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz

 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode currPointer = head;
        ListNode secondPointer = null;
        ListNode prev = null;
        int counter = 1;

        while (currPointer != null) {
            currPointer = currPointer.next;
            if (counter == n) {
                if (secondPointer == null) {
                    secondPointer = head;
                } else {
                    prev = secondPointer;
                    secondPointer = secondPointer.next;

                }
            } else {
                counter++;
            }
        }

        if (prev == null) {
            head = secondPointer.next;
        } else {
            prev.next = secondPointer.next;
        }

        return head;

    }

}
