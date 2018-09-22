/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public int maxLength = Integer.MIN_VALUE;
    
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return maxLength;
    }
    
    public int helper(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = helper(root.left);
        int rightDepth = helper(root.right);
        maxLength = Math.max(leftDepth + rightDepth, maxLength);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}