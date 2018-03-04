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
     * @return: You should return the head of the sorted linked list,
     *               using constant space complexity.
     */
     //Merge Sort
    // public ListNode sortList(ListNode head) {
    //     if (head == null) return null;
    //     ListNode head2 = findMiddle(head);
    //     if (head2.next == null) return head;
    //     ListNode newHead = head2.next;
    //     head2.next = null;
    //     ListNode left = sortList(head);
    //     ListNode right = sortList(newHead);
    //     return merge(left,right);
    // }

    // public ListNode findMiddle(ListNode head) {
    //     ListNode fast = head;
    //     ListNode slow = head;
    //     while (fast.next != null && fast.next.next != null) {
    //         fast = fast.next.next;
    //         slow = slow.next;
    //     }
    //     return slow;
    // }

    // public ListNode merge(ListNode head1, ListNode head2) {
    //     ListNode dummy = new ListNode(0);
    //     ListNode curt = dummy;
    //     while (head1 != null && head2 != null) {
    //         if (head1.val < head2.val) {
    //             curt.next = head1;
    //             head1 = head1.next;
    //         } else {
    //             curt.next = head2;
    //             head2 = head2.next;
    //         }
    //         curt = curt.next;
    //     }
    //     if (head1 != null) curt.next = head1;
    //     if (head2 != null) curt.next = head2;
    //     return dummy.next;
    // }

    //Quick Sort
    public ListNode sortList(ListNode head) {
        //Partition and sort list
        if (head == null || head.next == null)  return head;
        ListNode leftDummy = new ListNode(0);
        ListNode rightDummy = new ListNode(0);
        ListNode middleDummy = new ListNode(0);
        ListNode leftEnd = leftDummy;
        ListNode rightEnd = rightDummy;
        ListNode middleEnd = middleDummy;
        ListNode pivot = findMid(head).next;
        ListNode curt = head;
        while (curt != null) {
            if (curt.val < pivot.val) {
                leftEnd.next = curt;
                leftEnd = leftEnd.next;
            } else if (curt.val > pivot.val) {
                rightEnd.next = curt;
                rightEnd = rightEnd.next;
            } else {
                middleEnd.next = curt;
                middleEnd = middleEnd.next;
            }
            curt = curt.next;
        }
        leftEnd.next = null;
        middleEnd.next = null;
        rightEnd.next = null;

        //divide and conquer;
        ListNode left = sortList(leftDummy.next);
        ListNode right = sortList(rightDummy.next);

        //merge three linked lists
            curt = left == null ? middleDummy.next:left;
            while (curt.next != null) {
                curt = curt.next;
            }
            if (left != null) {
                head = left;
                curt.next = middleDummy.next;
                middleEnd.next = right;
            } else {
                head = middleDummy.next;
                curt.next = right;
            }

        return head;

    }

    public ListNode findMid(ListNode head) {
        if (head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
