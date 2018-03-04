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
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode prev = head;
        if (head == null) return null;
        ListNode curt = head.next;

        while (curt != null) {
            if (prev.val == curt.val) {
                curt = curt.next;
                prev.next = curt;
            } else {
                prev = curt;
                curt = curt.next;
            }
        }
        return head;
    }
}