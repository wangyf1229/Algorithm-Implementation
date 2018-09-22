/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        if (root != null) {
            stack.push(root);
            while(root.left != null) {
                stack.push(root.left);
                root = root.left;
            }
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode root = stack.pop();
        int smallest = root.val;
        if (root.right != null) {
            stack.push(root.right);
            root = root.right;
            while (root.left != null) {
                stack.push(root.left);
                root = root.left;
            }
        }
        return smallest;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */