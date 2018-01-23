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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preEnd = preorder.length - 1;
        int inEnd = inorder.length - 1;
        return helper(0, preEnd, 0, inEnd, preorder, inorder);
    }

    public TreeNode helper(int preStart, int preEnd, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preEnd < preStart || inEnd < inStart) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        preStart++;
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        root.left = helper(preStart, preStart + inIndex - inStart - 1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(preStart + inIndex - inStart, preEnd, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }
}