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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //The value of (root) LCA of p and q must be between the range of p.val and q.val
        //Because if not, p and q must be in one subtree, the root value must be larger or smaller than both value
        //Pay special attention to the case that p is the root or q is the root.
        if (root == null || p == null || q == null) return null;
        while (root != null) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
                continue;
            }
            if (root.val < p.val && root.val < q.val) {
                root = root.right;
                continue;
            }
            return root;
        }
        return root;
    }
}