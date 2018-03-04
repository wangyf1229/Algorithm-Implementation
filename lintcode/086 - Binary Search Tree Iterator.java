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
 * Example of iterate a tree:
 * BSTIterator iterator = new BSTIterator(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * }
 */
public class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();
    //@param root: The root of binary tree.
    public BSTIterator(TreeNode root) {

        if (root!=null) {
            stack.push(root);
            while (root.left!= null) {
                stack.push(root.left);
                root = root.left;
            }
        }
        // while (root != null) {
        //     stack.push(root);
        //     root = root.left;
        // }
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        // write your code here
        return !stack.empty();
    }

    //@return: return next node
    public TreeNode next() {
        TreeNode next = stack.pop();
        if (next.right != null) {
            stack.push(next.right);
            TreeNode tmp = next.right;
            while (tmp.left != null) {
                stack.push(tmp.left);
                tmp = tmp.left;
            }
        }
        return next;
    }
}