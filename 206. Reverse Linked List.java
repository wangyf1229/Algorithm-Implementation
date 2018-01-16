/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 //iterative
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while(head != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }
}

//recursive
class Solution {
    public ListNode reverseList(ListNode head) {
        return reverseListHelper(head, null);
    }
    public ListNode reverseListHelper(ListNode head, ListNode newHead) {
        if (head == null) return newHead;
        ListNode temp = head.next;
        head.next = newHead;
        return reverseListHelper(temp, head);
    }
}