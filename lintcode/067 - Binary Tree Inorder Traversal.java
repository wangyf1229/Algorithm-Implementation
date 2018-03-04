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
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        //Iterative
        // ArrayList<Integer> inorder = new ArrayList<Integer> ();
        // Stack<TreeNode> stack = new Stack<TreeNode> ();
        // TreeNode curt = root;

        // while (curt != null || !stack.empty()) {
        //     while (curt != null) {
        //         stack.push(curt);
        //         curt = curt.left;
        //     }
        //     curt = stack.pop();
        //     inorder.add(curt.val);
        //     curt = curt.right;
        // }

        // return inorder;

        //Recursive
        ArrayList<Integer> inorder = new ArrayList<Integer> ();
        if (root == null) {
            return inorder;
        }
        inorder.addAll(inorderTraversal(root.left));
        inorder.add(root.val);
        inorder.addAll(inorderTraversal(root.right));
        return inorder;
    }
}