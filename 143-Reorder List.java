/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null) return;
        
        //slow fast pointer to find the middle point
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //reverse the second half of the linkedlist
        ListNode secHead;
        secHead = reverseList(slow.next);
        slow.next = null;
        
        //merge the two halves of the linkedlist
        ListNode firHead = head;
        while (secHead != null) {
            ListNode firNext = firHead.next;
            ListNode secNext = secHead.next;
            firHead.next = secHead;
            secHead.next = firNext;
            firHead = firNext;
            secHead = secNext;
        }
        return;
    }
    
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while(head != null) {
            ListNode newHead = head.next;
            head.next = prev;
            prev = head;
            head = newHead;
        }
        return prev;
    }
}