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

    //BFS
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        int flip = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new LinkedList<>();
            for (int i = 0; i <size; i++) {
                TreeNode trn = queue.poll();
                if (flip == -1) {
                    level.add(0, trn.val);
                } else {
                    level.add(trn.val);
                }
                if (trn.left!= null) queue.offer(trn.left);
                if (trn.right!= null) queue.offer(trn.right);
            } 
            flip *= -1;
            res.add(level);
        }
        return res;
    }
    
    //DFS
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, 0, res);
        return res;
    }
    
    public void helper(TreeNode root, int level, List<List<Integer>> res) {
        if (root == null) return;
        if (level + 1 > res.size()) {
            List<Integer> list = new ArrayList<>();
            res.add(list);
        }
        List<Integer> list = res.get(level);
        if (level % 2 == 0) {
            list.add(root.val);
        } else {
            list.add(0, root.val);
        }
        
        helper(root.left, level + 1, res);
        helper(root.right, level + 1, res);    
    }
}