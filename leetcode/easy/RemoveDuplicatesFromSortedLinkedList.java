package leetcode.easy;

import leetcode.ListNode;

/*

Given the head of a sorted linked list, delete all duplicates such that each element appears only once. 

Return the linked list sorted as well.

Example 1:

Input: head = [1,1,2]
Output: [1,2]

Example 2:

Input: head = [1,1,2,3,3]
Output: [1,2,3]

Constraints:

- The number of nodes in the list is in the range [0, 300].
- -100 <= Node.val <= 100
- The list is guaranteed to be sorted in ascending order.

 */

public class RemoveDuplicatesFromSortedLinkedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode output = new ListNode(head.val);
        ListNode outputCurr = output;

        ListNode prev = head;
        ListNode curr = head.next;

        while (curr != null) {
          
            if (prev.val != curr.val) {
                outputCurr.next = new ListNode(curr.val);
                outputCurr = outputCurr.next;
            }
            prev = curr;
            curr = curr.next;
          
        }

        return output;
    }

}
