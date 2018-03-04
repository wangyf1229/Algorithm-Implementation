/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = head;
        ListNode curr = head;
        while (curr != null) {
            while (curr != null && prev.val == curr.val) {
                curr = curr.next;
            }
            //sec == null || fir.val != sec.val
            prev.next = curr;
            prev = curr;
        }
        return head;
    }
}
