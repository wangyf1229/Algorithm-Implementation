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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        invertTreeHelper(root);
        return root;
    }

    public TreeNode invertTreeHelper(TreeNode root) {
        if (root == null) return root;
        TreeNode ltn = invertTreeHelper(root.left);
        TreeNode rtn = invertTreeHelper(root.right);
        root.left = rtn;
        root.right = ltn;
        return root;
    }
}