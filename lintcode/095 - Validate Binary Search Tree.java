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
class ResultType{
    public boolean isBST;
    public int minValue;
    public int maxValue;
    public ResultType(boolean isBST, int minValue, int maxValue) {
        this.isBST = isBST;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }
}
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        return validateHelper(root).isBST;
    }

    public ResultType validateHelper(TreeNode root) {
        if (root == null) {
            return new ResultType(true, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }


        ResultType left = validateHelper(root.left);
        ResultType right = validateHelper(root.right);

        //System.out.println(left.maxValue);
        //System.out.println(right.minValue);

        if ((!left.isBST)||(!right.isBST)) {
            return new ResultType (false,0,0);
        }

        if (root.left!= null && left.maxValue >= root.val) {
            return new ResultType (false,0,0);
        }

        if (root.right!= null && root.val >= right.minValue) {
            return new ResultType (false,0,0);
        }

        return new ResultType (true, Math.min(left.minValue, root.val), Math.max(right.maxValue, root.val));
    }
}