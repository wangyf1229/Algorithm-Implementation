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
    public int maxValue = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return maxValue;
    }
    
    public int helper(TreeNode root) {
        if (root == null) return 0;
        int leftValue = Math.max(helper(root.left), 0);
        int rightValue = Math.max(helper(root.right), 0);
        maxValue = Math.max(leftValue + rightValue + root.val, maxValue);
        return Math.max(leftValue, rightValue) + root.val;
    }
}