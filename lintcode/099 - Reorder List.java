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
     * @return: void
     */
    public void reorderList(ListNode head) {
        //split two linked list;
        if (head == null) return;
        ListNode curt1 = head;
        ListNode middle = findMiddle(head);
        ListNode curt2 = middle.next;
        middle.next = null;


        //reverse second linked list;
        curt2 = reverseList(curt2);

        //merge two linked lists;
        while (curt2 != null) {
            ListNode tmp = curt2.next;
            curt2.next = curt1.next;
            curt1.next = curt2;
            curt1 = curt2.next;
            curt2 = tmp;
        }
    }

    public ListNode reverseList (ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }

    public ListNode findMiddle (ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
