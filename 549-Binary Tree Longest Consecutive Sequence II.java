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
    //clever!!!
    private int max = Integer.MIN_VALUE;

    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return max;
    }

    public int[] helper(TreeNode root) {
        //int[0] => means the longest increasing length except current node;
        //int[1] => means the longest decreasing length except current node;
        if (root == null) return new int[]{0, 0};

        int[] resL = helper(root.left);
        int[] resR = helper(root.right);
        int[] res = new int[]{0, 0};
        if (root.left != null && root.left.val == root.val - 1) {
            res[0] = Math.max(res[0], resL[0] + 1);
        } else if (root.left != null && root.left.val == root.val + 1) {
            res[1] = Math.max(res[1], resL[1] + 1);
        }
        if (root.right != null && root.right.val == root.val - 1) {
            res[0] = Math.max(res[0], resR[0] + 1);
        } else if (root.right != null && root.right.val == root.val + 1) {
            res[1] = Math.max(res[1], resR[1] + 1);
        }

        max = Math.max(res[0] + res[1] + 1, max);
        return res;
    }

}