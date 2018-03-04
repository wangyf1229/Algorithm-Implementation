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
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        //Iterative
        // ArrayList<Integer> preorder = new ArrayList<Integer> ();
        // Stack<TreeNode> stack = new Stack<TreeNode> ();

        // if (root == null) {
        //     return preorder;
        // }

        // stack.push(root);
        // while(!stack.empty()) {
        //     TreeNode node = stack.pop();
        //     preorder.add(node.val);
        //     if (node.right != null) {
        //         stack.push(node.right);

        //     }
        //     if (node.left != null) {
        //         stack.push(node.left);
        //     }
        // }
        // return preorder;

        //Recursive
        ArrayList<Integer> preorder = new ArrayList<Integer> ();
        if (root == null) {
            return preorder;
        }
        preorder.add(root.val);
        preorder.addAll(preorderTraversal(root.left));
        preorder.addAll(preorderTraversal(root.right));
        return preorder;


    }
}