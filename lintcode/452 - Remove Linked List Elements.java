/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param head a ListNode
     * @param val an integer
     * @return a ListNode
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curt = head;
        while (curt != null) {
            if (curt.val == val) {
                curt = curt.next;
                prev.next = curt;
            }else {
                prev = curt;
                curt = curt.next;
            }
        }
        return dummy.next;
    }
}