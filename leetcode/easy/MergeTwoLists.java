package leetcode.easy;

import leetcode.ListNode;

/*

You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

Example 1:

Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:

Input: list1 = [], list2 = []
Output: []

Example 3:

Input: list1 = [], list2 = [0]
Output: [0]

 */

public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null && list2 == null) return null;
        if (list1 == null && list2.next == null) return list2;
        if (list2 == null && list1.next == null) return list1;

        ListNode output = new ListNode();
        ListNode curr = output;

        ListNode curr1 = list1;
        ListNode curr2 = list2;

        while (curr1 != null && curr2 != null) {
            if (curr1.val < curr2.val) {
                curr.val = curr1.val;
                curr1 = curr1.next;
            } else {
                curr.val = curr2.val;
                curr.next = new ListNode();
                curr2 = curr2.next;
            }
            curr.next = new ListNode();
            curr = curr.next;
        }

        ListNode prev = curr;
        while (curr1 != null) {
            curr.val = curr1.val;
            curr1 = curr1.next;
            curr.next = new ListNode();
            prev = curr;
            curr = curr.next;
        }

        while (curr2 != null) {
            curr.val = curr2.val;
            curr2 = curr2.next;
            curr.next = new ListNode();
            prev = curr;
            curr = curr.next;
        }

        prev.next = null;

        return output;

    }

}
