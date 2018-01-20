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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<>();
        HashMap<Integer, List<Integer>> map1 = new HashMap<>();
        Queue<Integer> q2 = new LinkedList<>();
        q.offer(root);
        q2.offer(0);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while (! q.isEmpty()) {
            TreeNode r = q.poll();
            int sr = q2.poll();
            min = Math.min(min, sr);
            max = Math.max(max, sr);
            List<Integer> l1 = map1.getOrDefault(sr, new ArrayList<Integer>());
            l1.add(r.val);
            map1.put(sr, l1);
            if (r.left != null) {
               q.offer(r.left);
               q2.offer(sr - 1);
            }
            if (r.right != null) {
                q.offer(r.right);
                q2.offer(sr + 1);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            result.add(map1.get(i));
        }
        return result;
    }
}