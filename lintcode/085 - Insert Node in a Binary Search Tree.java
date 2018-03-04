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
 */
public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        TreeNode curr = root;
        TreeNode prev = root;
        if (root == null) return node;
        while (curr != null) {
            prev = curr;
            if (node.val > curr.val) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        //System.out.println(prev.val);
        if (node.val > prev.val) {
            prev.right = node;
        }
        if (node.val <= prev.val) {
            prev.left = node;
        }
        return root;
    }
}