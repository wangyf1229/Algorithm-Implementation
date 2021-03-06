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
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
       ListNode newHead = null;
       while (head != null) {
           ListNode temp = head.next;
           head.next = newHead;
           newHead = head;
           head = temp;
       }
       return newHead;
    }
}
