package leetcode.medium;

import leetcode.ListNode;

/*

You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example: 1

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]

Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]

 */

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode currNode1 = l1;
        ListNode currNode2 = l2;

        int extra = 0;
        ListNode result = new ListNode();
        ListNode curr = result;

        while (currNode1 != null || currNode2 != null || extra != 0) {
            int num1 = 0;
            int num2 = 0;

            if (currNode1 != null) {
                num1 = currNode1.val;
                currNode1 = currNode1.next;
            }
            if (currNode2 != null) {
                num2 = currNode2.val;
                currNode2 = currNode2.next;
            }

            int sum = num1 + num2 + extra;

            if (sum >= 10) {
                String sumString = String.valueOf(sum);
                extra = Integer.parseInt(String.valueOf(sumString.charAt(0)));
                sum = Integer.parseInt(String.valueOf(sumString.charAt(1)));
            } else {
                extra = 0;
            }

            curr.next = new ListNode(sum, null);
            curr = curr.next;
        }

        return result.next;

    }

}
