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
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        // ListNode dummy = new ListNode(0);
        // dummy.next = head;
        // if (head == null) return null;
        // ListNode prev = dummy;
        // ListNode curt = head;
        // for (int i = 0; i < m - 1; i++) {
        //         prev = curt;
        //         curt = curt.next;
        // }

        // ListNode mPrev = prev;
        // ListNode mNode = curt;

        //only need to iterate once from position m to n;
        // for (int i = 0; i < (n - m); i++) {
        //     prev = curt;
        //     curt = curt.next;
        // }

        // ListNode nNode = curt;
        // ListNode nNext = curt.next;

        // curt = mNode;
        // prev = mPrev;

        // while (curt != nNext) {
        //     ListNode tmp = curt.next;
        //     curt.next = prev;
        //     prev = curt;
        //     curt = tmp;
        // }

        // mPrev.next = nNode;
        // mNode.next = nNext;

        // return dummy.next;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        if (head == null) return null;
        ListNode prev = dummy;
        ListNode curt = head;
        //curt at m position, suffix without dummy node is m-1;
        for (int i = 1; i <= m - 1; i++) {
                prev = curt;
                curt = curt.next;
        }

        ListNode mPrev = prev;
        ListNode mNode = curt;
        //prev is nNode and curt is nNext;
        for (int i = m; i <= n; i++ ) {
            if (curt == null) break;
            ListNode tmp = curt.next;
            curt.next = prev;
            prev = curt;
            curt = tmp;
        }
        //now prev is nNode and curt is nNext;

        mPrev.next = prev;
        mNode.next = curt;

        return dummy.next;

    }
}