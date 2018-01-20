/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    //Iteration
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                prev.next = l2;
                l2 = l2.next;
            } else {
                prev.next = l1;
                l1 = l1.next;
            }
            prev = prev.next;
        }
        if (l1 == null) prev.next = l2;
        if (l2 == null) prev.next = l1;
        return dummy.next;
    }

    //Recursion
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = l1;
        if (l1.val > l2.val) {
            ListNode newHead = mergeTwoLists(l1, l2.next);
            l2.next = newHead;
            head = l2;
        } else {
            ListNode newHead = mergeTwoLists(l1.next, l2);
            l1.next = newHead;
        }
        return head;
    }
}