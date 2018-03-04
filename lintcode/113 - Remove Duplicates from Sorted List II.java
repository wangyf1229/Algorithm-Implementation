/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of the linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curt = head;
        while (curt != null) {
            if (curt.next != null && curt.val == curt.next.val) {
                int tmp = curt.val;
                while (curt != null && curt.val == tmp) {
                    curt = curt.next;
                }
                prev.next = curt;
            } else {
                prev = curt;
                curt = curt.next;
            }
        }
        return dummy.next;
    }
}
