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
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    // Use Heap
    // public class mergeComparator implements Comparator<ListNode> {
    //     public int compare(ListNode left, ListNode right) {
    //         return (left.val - right.val);
    //     }
    // }

    // public ListNode mergeKLists(List<ListNode> lists) {
    //     int num = lists.size();
    //     if (num == 0) return null;
    //     //PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(num, (a,b)->a.val - b.val);
    //     PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(num,new mergeComparator());
    //     for (int i = 0; i < num; i++) {
    //         if(lists.get(i) != null) {
    //             heap.add(lists.get(i));
    //         }
    //     }

    //     ListNode dummy = new ListNode(0);
    //     ListNode curt = dummy;
    //     while (!heap.isEmpty()) {
    //         curt.next = heap.poll();
    //         curt = curt.next;
    //         if (curt.next != null){
    //             heap.add(curt.next);
    //         }
    //     }
    //     curt.next = null;
    //     return dummy.next;
    // }

    //
    // public ListNode mergeKLists(List<ListNode> lists) {
    //     int num = lists.size();
    //     if (num == 0) return null;
    //     ListNode result = sortHelper(lists, 0, num-1);
    //     return result;
    // }

    public ListNode sortHelper(List<ListNode> lists, int start, int end) {
        if (start == end) return lists.get(start);
        ListNode first = sortHelper(lists, start, (start + end)/2);
        ListNode second = sortHelper(lists, (start + end)/2 + 1, end);
        return mergeTwoLists(first, second);
    }

    public ListNode mergeTwoLists(ListNode n1, ListNode n2) {
        if (n1 == null) return n2;
        if (n2 == null) return n1;
        ListNode dummy = new ListNode(0);
        ListNode curt = dummy;
        while (n1 != null && n2 != null) {
            if(n1.val < n2.val) {
                curt.next = n1;
                n1 = n1.next;
            }else {
                curt.next = n2;
                n2 = n2.next;
            }
            curt = curt.next;
        }
        if (n1 != null) curt.next = n1;
        if (n2 != null) curt.next = n2;
        return dummy.next;
    }

    public ListNode mergeKLists(List<ListNode> lists) {
        int num = lists.size();
        if (num == 0) return null;
        while(lists.size()>1) {
            ListNode tmp = mergeTwoLists(lists.get(0),lists.get(1));
            lists.remove(0);
            lists.remove(0);
            lists.add(tmp);
        }
        return lists.get(0);
    }
}
