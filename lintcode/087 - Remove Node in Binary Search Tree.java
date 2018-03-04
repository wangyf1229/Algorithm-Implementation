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
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode(TreeNode root, int value) {
        TreeNode curr = root;
        TreeNode prev = null;
        while (curr != null) {
            if (value > curr.val) {
                prev = curr;
                curr = curr.right;
            } else if (value < curr.val) {
                prev = curr;
                curr = curr.left;
            } else {
                break;
            }
        }
        if (curr == null) {return root;}

        // if (curr.left == null && curr.right == null) {
        //     if (prev == null) {return null;}
        //     if (prev.left == curr) {prev.left = null;}
        //     if (prev.right == curr) {prev.right = null;}
        // }

        // if (curr.left == null && curr.right != null) {
        //     if (prev == null) {return curr.right; }
        //     if (prev.left == curr) {prev.left = curr.right;}
        //     if (prev.right == curr) {prev.right = curr.right;}
        // }

        // if (curr.right == null && curr.left != null) {
        //     if (prev == null) {return curr.left;}
        //     if (prev.left == curr) {prev.left = curr.left;}
        //     if (prev.right == curr) {prev.right = curr.left;}
        // }


        // if (curr.left != null && curr.right != null) {
        //     TreeNode tmp = curr.right;
        //     TreeNode tmpPrev = curr;
        //     while (tmp.left != null) {
        //         tmpPrev = tmp;
        //         tmp = tmp.left;
        //     }
        //     if (tmpPrev != curr) {
        //         tmpPrev.left = tmp.right;
        //         tmp.left = curr.left;
        //         tmp.right = curr.right;
        //     } else {
        //         tmp.left = curr.left;
        //     }
        //     if (prev == null) return tmp;
        //     if (prev.left == curr) prev.left = tmp;
        //     if (prev.right == curr) prev.right = tmp;
        // }
        // return root;
        TreeNode node = deleteNode(curr);
        if (prev == null) return node;
        if (prev.left == curr) prev.left = node;
        if (prev.right == curr) prev.right = node;
        return root;
    }

    public TreeNode deleteNode(TreeNode curr) {
        if (curr.left == null) return curr.right;
        if (curr.right == null) return curr.left;
        TreeNode tmp = curr.right;
        TreeNode tmpPrev = curr;
        while (tmp.left != null) {
            tmpPrev = tmp;
            tmp = tmp.left;
        }
        if (tmpPrev != curr) {
            tmpPrev.left = tmp.right;
            tmp.right = curr.right;
        }
        tmp.left = curr.left;
        return tmp;

    }
}