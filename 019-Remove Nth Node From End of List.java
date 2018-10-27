/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            //Remove the first one
            ListNode res = head.next;
            head.next = null;
            return res;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //when slow.next == null => slow is the last one but fast will be the last one
        slow.next = slow.next.next;
        return head;
    }
}