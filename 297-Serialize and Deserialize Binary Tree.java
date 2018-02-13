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
        if (root == null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuffer strB = new StringBuffer();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode root_temp = queue.poll();
            if (root_temp == null) {
                strB.append("null ");
            } else {
                strB.append(root_temp.val + " ");
            }
            if (root_temp != null) {
                queue.offer(root_temp.left);
                queue.offer(root_temp.right);
            }
        }
        return strB.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") return null;
        String[] nodes = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 1; i < nodes.length; i++) {
            TreeNode temp = queue.poll();
            if (! nodes[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(nodes[i]));
                temp.left = left;
                queue.offer(left);
            }
            if (! nodes[++i].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(nodes[i]));
                temp.right = right;
                queue.offer(right);
            }
        }
        return root;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));