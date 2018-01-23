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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inEnd = inorder.length - 1;
        int postEnd = postorder.length - 1;
        return helper(0, postEnd, 0, inEnd, inorder, postorder);
    }

    public TreeNode helper(int postStart, int postEnd, int inStart, int inEnd, int[] inorder, int[] postorder) {
        if (postEnd < postStart || inEnd < inStart) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        postEnd--;
        int inIndex = 0;
        for(int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        root.left = helper(postStart, postStart + inIndex - inStart - 1, inStart, inIndex - 1, inorder, postorder);
        root.right = helper(postStart + inIndex - inStart, postEnd, inIndex + 1, inEnd, inorder, postorder);
        return root;

    }
}