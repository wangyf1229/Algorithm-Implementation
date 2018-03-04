/**
 * Definition for singly-linked list.
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
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
        ListNode curt = head;
        if (head == null || head.next == null) return head;
        int nodeNum = 1;
        while (curt.next != null) {
            curt = curt.next;
            nodeNum ++;
        }
        if(k >= nodeNum) k = k % nodeNum;
        curt.next = head;
        for (int i = 1; i < nodeNum - k; i++) {
            head = head.next;
        }
        ListNode newHead = head.next;
        head.next = null;
        return newHead;
    }
}