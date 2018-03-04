/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 * Definition for Doubly-ListNode.
 * public class DoublyListNode {
 *     int val;
 *     DoublyListNode next, prev;
 *     DoublyListNode(int val) {
 *         this.val = val;
 *         this.next = this.prev = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    public DoublyListNode bstToDoublyList(TreeNode root) {
        if (root == null) return null;
        DoublyListNode dummy = new DoublyListNode(0);
        DoublyListNode curt = dummy;
        // LinkedList<TreeNode> inorder = new LinkedList<>();
        // inorderRecursion2(root,inorder);
        LinkedList<TreeNode> inorder = inorderIterative(root);
        for (TreeNode n : inorder) {
            curt.next = new DoublyListNode(n.val);
            curt.next.prev = curt;
            curt = curt.next;
        }
        if (dummy.next != null) dummy.next.prev = null;
        return dummy.next;
    }

    public void inorderRecursion(TreeNode root, List<TreeNode> result) {
        if (root == null) return;
        inorderRecursion(root.left, result);
        result.add(root);
        inorderRecursion(root.right,result);
    }

    public LinkedList<TreeNode> inorderRecursion2(TreeNode root) {
        LinkedList<TreeNode> result = new LinkedList<TreeNode>();
        if (root == null) return result;
        LinkedList<TreeNode> left = inorderRecursion2(root.left);
        LinkedList<TreeNode> right = inorderRecursion2(root.right);

        result.addAll(left);
        result.add(root);
        result.addAll(right);

        return result;
    }

    public LinkedList<TreeNode> inorderIterative(TreeNode root) {
         LinkedList<TreeNode> result = new LinkedList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curt = root;
        while (!stack.empty() || curt != null) {
            while (curt != null) {
                stack.push(curt);
                curt = curt.left;
            }
            curt = stack.pop();
            result.add(curt);
            curt = curt.right;
        }
        return result;
    }

}
