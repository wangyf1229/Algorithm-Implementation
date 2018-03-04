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
    public int root2any;
    public int any2any;
    public ResultType (int root2any, int any2any) {
        this.root2any = root2any;
        this.any2any = any2any;
    }
}
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public ResultType helper (TreeNode root) {
        //这里不设置为0的原因是root的value有可能为负数。
        if (root == null) {
            return new ResultType (Integer.MIN_VALUE, Integer.MIN_VALUE);
        }

        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        //如果从左子树或者右子树返回的root2any是负数的话，我可以选择不用走这边。
        int root2any = Math.max(0, Math.max(left.root2any, right.root2any))+root.val;
        //比较左右子树中的最大路径值和通过root分别跨越左右子树的路径值哪个比较大
        int any2any = Math.max(left.any2any, right.any2any);
        any2any = Math.max(any2any, Math.max(0,left.root2any)+Math.max(0,right.root2any)+root.val);
        ResultType result = new ResultType(root2any, any2any);

        return result;
    }

    public int maxPathSum(TreeNode root) {
        return helper(root).any2any;
    }
}