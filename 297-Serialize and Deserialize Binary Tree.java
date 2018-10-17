/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("null");
                sb.append(", ");
            } else {
                sb.append(node.val);
                sb.append(", ");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] array = data.split(", ");
        Queue<TreeNode> queue = new LinkedList<>();
        if (array[0].equals("null")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(array[0]));
        queue.offer(root);
        int idx = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            String leftValue = array[idx];
            if (!leftValue.equals("null")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(array[idx]));
                node.left = leftNode;
                queue.offer(leftNode);
            }
            idx++;
            String rightValue = array[idx];
            if (!rightValue.equals("null")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(array[idx]));
                node.right = rightNode;
                queue.offer(rightNode);
            }
            idx++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));