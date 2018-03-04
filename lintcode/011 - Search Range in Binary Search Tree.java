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
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<Integer> ();
        //My solution
        // stack.push(root);
        // while (root.left!=null) {
        //         stack.push(root.left);
        //         root = root.left;
        //     }
        // while (!stack.empty()) {
        //     root = stack.pop();
        //     if (root.val >= k1 && root.val <= k2) {
        //         result.add(root.val);
        //     }
        //     if (root.right != null) {
        //         stack.push(root.right);
        //         TreeNode tmp= root.right;
        //         while (tmp.left != null) {
        //             stack.push(tmp.left);
        //             tmp = tmp.left;
        //         }
        //     }
        // }

        //Wu Yang's Solution
        // while (root != null || !stack.isEmpty()) {
        //     if (root != null) {
        //         stack.push(root);
        //         root = root.left;
        //     } else {
        //         root = stack.pop();
        //         System.out.println(root.val);
        //         if (root.val >= k1 && root.val <= k2) {
        //             result.add(root.val);
        //         }
        //         root = root.right;
        //     }
        // }
        // return result;

        //jiu zhang's solution
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val >= k1 && root.val <= k2) {
             result.add(root.val);
            }
            root = root.right;
        }
        return result;
    }
}