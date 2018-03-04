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
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        //Iterative
        // ArrayList<Integer> postorder = new ArrayList<Integer> ();
        // Stack<TreeNode> stack = new Stack<TreeNode>();
        // TreeNode curr = root;
        // TreeNode prev = null;
        // stack.push(curr);
        // while (curr != null && !stack.empty()) {
        //     curr = stack.peek();
        //     if (prev == null || prev.left == curr || prev.right == curr) {
        //         if (curr.left != null) {
        //             stack.push(curr.left);
        //         } else if (curr.right != null) {
        //             stack.push(curr.right);
        //         }
        //     } else if (curr.left == prev) {
        //         if (curr.right != null) {
        //             stack.push(curr.right);
        //         }
        //     }else {
        //         curr = stack.pop();
        //         postorder.add(curr.val);
        //     }
        //     prev = curr;
        // }
        // return postorder;
        //Recursion
        ArrayList<Integer> postorder = new ArrayList<Integer> ();
        if (root == null) {
            return postorder;
        }
        postorder.addAll(postorderTraversal(root.left));
        postorder.addAll(postorderTraversal(root.right));
        postorder.add(root.val);
        return postorder;
    }
}