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
     * @return: buttom-up level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // Queue<TreeNode> queue = new LinkedList<>();
        // Stack<TreeNode> stack = new Stack<>();
        // ArrayList<Integer> size = new ArrayList<>();
        // ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
        // if (root == null) return result;
        // queue.offer(root);
        // while (!queue.isEmpty()) {
        //     size.add(queue.size());
        //     int sizeQ = queue.size();
        //     for (int i = 0; i < sizeQ; i++) {
        //         TreeNode tmp = queue.poll();
        //         stack.push(tmp);
        //         if (tmp.right != null) queue.offer(tmp.right);
        //         if (tmp.left != null) queue.offer(tmp.left);
        //     }
        // }

        // for (int i=size.size()-1; i>=0; i--) {
        //     int num = size.get(i);
        //     ArrayList<Integer> level = new ArrayList<>();
        //     for (int j = 0; j < num; j++) {
        //         level.add(stack.pop().val);
        //     }
        //     result.add(level);
        // }

        // return result;

        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                level.add(tmp.val);
                if (tmp.left != null) queue.offer(tmp.left);
                if (tmp.right != null) queue.offer(tmp.right);
            }
            //result.add(0,level);
            result.add(level);
        }
        Collections.reverse(result);
        return result;


    }
}