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
     * @param head: The first node of linked list.
     * @param x: an integer
     * @return: a ListNode
     */
    public ListNode partition(ListNode head, int x) {
        ListNode leftDummy = new ListNode(0);
        ListNode rightDummy = new ListNode(0);
        ListNode leftEnd = leftDummy;
        ListNode rightEnd = rightDummy;
        ListNode curt = head;
        if (head == null) return null;
        while (curt != null) {
            if (curt.val < x) {
                leftEnd.next = curt;
                leftEnd = curt;
            } else {
                rightEnd.next = curt;
                rightEnd = curt;
            }
            curt = curt.next;
        }
        leftEnd.next = rightDummy.next;
        rightEnd.next = null;
        return leftDummy.next;
    }
}
