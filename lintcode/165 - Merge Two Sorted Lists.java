/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode pointer = dummy;
        ListNode curt1 = l1;
        ListNode curt2 = l2;
        while (curt1 != null && curt2 != null) {
            if (curt1.val < curt2.val) {
                pointer.next = curt1;
                curt1 = curt1.next;
            } else {
                pointer.next = curt2;
                curt2 = curt2.next;
            }
            pointer = pointer.next;
        }
        ListNode curt = null;
        if (curt1 == null) curt = curt2;
        if (curt2 == null) curt = curt1;
        while (curt != null) {
            pointer.next = curt;
            curt = curt.next;
            pointer = pointer.next;
        }
        pointer.next = null;
        return dummy.next;
    }
}