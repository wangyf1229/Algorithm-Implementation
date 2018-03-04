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
     * @param k an integer
     * @return a ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        //fast pointer is k nodes ahead of slow pointer
        for (int i = 0; i < k; i++) {
            fast = fast.next;
            if (fast == null) return head;
        }

        boolean isEnd = false;
        while (!isEnd) {
            fast = reverseList(slow, fast);
            for (int i = 0; i < k; i++) {
                slow = slow.next;
                fast = fast.next;
                if (fast == null) {
                    isEnd = true;
                    break;
                }
            }
        }
        return dummy.next;
    }
    //reverse the list from start to end (start excluded).
    public ListNode reverseList(ListNode start, ListNode end) {
        // System.out.println(start.val);
        // System.out.println(end.val);
        ListNode prev = start;
        ListNode curt = start.next;
        while (curt != end) {
            ListNode tmp = curt.next;
            curt.next = prev;
            prev = curt;
            curt = tmp;
        }
        ListNode result = start.next;
        start.next.next = end.next;
        end.next = prev;
        start.next = end;
        return result;
    }
}