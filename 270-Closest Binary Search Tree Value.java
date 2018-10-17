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
    public int closestValue(TreeNode root, double target) {
        TreeNode ret = root;
        while (root != null) {
            if (Math.abs(root.val - target) < Math.abs(ret.val - target)) {
                ret = root;
            }
            root = target > root.val ? root.right : root.left;
        }
        return ret.val;
    }
}