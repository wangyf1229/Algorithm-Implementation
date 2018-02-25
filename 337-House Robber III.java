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
    public int rob(TreeNode root) {
        if (root == null) return 0;
        int[] res = robHelper(root);
        return Math.max(res[0], res[1]);
    }

    public int[] robHelper(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        //res[0] => the maximum value containing the root's value;
        //res[1] => the maximum value without the root's value;
        int[] res = new int[]{0, 0};
        int[] lRes = robHelper(root.left);
        int[] rRes = robHelper(root.right);
        res[0] = lRes[1] + rRes[1] + root.val;
        res[1] = Math.max(lRes[0], lRes[1]) + Math.max(rRes[0], rRes[1]);
        return res;
    }
}