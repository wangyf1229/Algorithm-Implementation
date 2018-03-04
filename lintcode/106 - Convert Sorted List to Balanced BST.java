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
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        TreeNode root = sortHelper(head,null);
        return root;

    }

    //find the middle ListNode of the linked list, the left subtree is the left part of the linked list while the right subtree is the right part of the linked list.
    public TreeNode sortHelper(ListNode head, ListNode end) {
        if (head == end) return null;
        ListNode mid = findMid(head,end);
        TreeNode root = new TreeNode(mid.val);
        root.left = sortHelper(head, mid);
        root.right = sortHelper(mid.next, end);
        return root;
    }

    //find the middle point between ListNode head and ListNode end. (end excluded);
    public ListNode findMid(ListNode head, ListNode end) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != end && fast.next.next != end) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}

//jiuzhang solution: similar to DFS && inorder traversal of a binary tree;
// public class Solution {
//     private ListNode current;

//     private int getListLength(ListNode head) {
//         int size = 0;

//         while (head != null) {
//             size++;
//             head = head.next;
//         }

//         return size;
//     }

//     public TreeNode sortedListToBST(ListNode head) {
//         int size;

//         current = head;
//         size = getListLength(head);

//         return sortedListToBSTHelper(size);
//     }

//     public TreeNode sortedListToBSTHelper(int size) {
//         if (size <= 0) {
//             return null;
//         }

//         TreeNode left = sortedListToBSTHelper(size / 2);
//         TreeNode root = new TreeNode(current.val);
//         current = current.next;
//         TreeNode right = sortedListToBSTHelper(size - 1 - size / 2);

//         root.left = left;
//         root.right = right;

//         return root;
//     }
// }
