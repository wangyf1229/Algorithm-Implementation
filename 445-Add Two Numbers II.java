/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1!=null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2!=null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        ListNode dummy = new ListNode(0);
        ListNode prev = null;
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int sum = carry;
            if (!stack1.isEmpty()) {
                sum += stack1.pop();
            }
            if (!stack2.isEmpty()) {
                sum += stack2.pop();
            }
            ListNode node = new ListNode(sum%10);
            //Add node to the first one!!
            dummy.next = node;
            node.next = prev;
            prev = node;
            carry = sum/10;
        }
        //carry may not be zero!!
        if (carry!=0) {
            ListNode node = new ListNode(carry);
            dummy.next = node;
            node.next = prev;
            prev = node;
        }
        return dummy.next;
    }
}