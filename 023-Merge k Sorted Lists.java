/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int num = lists.length;
        if (num == 0) return null;
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(num, (a,b)->a.val - b.val);
        for (int i = 0; i < num; i++) {
            if(lists[i] != null) {
                heap.add(lists[i]);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode curt = dummy;
        while (!heap.isEmpty()) {
            curt.next = heap.poll();
            curt = curt.next;
            if (curt.next != null){
                heap.add(curt.next);
            }
        }
        curt.next = null;
        return dummy.next;
    }
}