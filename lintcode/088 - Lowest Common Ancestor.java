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
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // 在root为根的二叉树中找A,B的LCA:
        // 如果找到了就返回这个LCA
        // 如果只碰到A，就返回A
        // 如果只碰到B，就返回B
        // 如果都没有，就返回null

        if (root == null) return null;
        if (root == A || root == B) return root;
        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);
        //对应以上四种情况
        //n1和n2分别在一左一右两棵树中
        if (left != null && right != null) return root;
        //LCA在左子树中
        if (left != null ) return left;
        //LCA在右子树中
        if (right != null ) return right;
        //LCA, n1, n2都不在左右两棵树中
        return null;
    }
}