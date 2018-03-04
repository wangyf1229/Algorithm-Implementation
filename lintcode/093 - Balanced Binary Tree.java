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
class ResultType {
    public boolean isBalanced;
    public int h;
    public ResultType (boolean isBalanced, int h) {
        this.isBalanced = isBalanced;
        this.h = h;
    }
}
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        return helper(root).isBalanced;
    }

    public ResultType helper (TreeNode root) {
        if (root == null) {
            return new ResultType(true,0);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        ResultType result = new ResultType(false, Math.max(left.h,right.h) + 1);
        if (left.isBalanced && right.isBalanced && Math.abs(left.h - right.h)<=1) {
            result.isBalanced = true;
        }
        return result;
    }
}