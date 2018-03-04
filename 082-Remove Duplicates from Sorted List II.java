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
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        while (curr != null) {
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }
            //curr.next == null || curr.val != curr.next.val
            //1->2->3->4
            if (prev.next == curr) {
                prev = prev.next;
                curr = curr.next;
            } else {
            //1->2->2->3->3->4
                prev.next = curr.next;
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}