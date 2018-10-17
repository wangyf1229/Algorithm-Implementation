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

    // Construct a BST from preorder traversal
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null) {
            while (root != null) {
                sb.append(root.val);
                sb.append(", ");
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] str = data.split(", ");
        int[] nums = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }
        return buildTree(nums, 0, nums.length - 1);
    }
    
    public TreeNode buildTree(int[] nums, int start, int end) {
        if (end < start) return null;
        if (end == start) return new TreeNode(nums[start]);
        TreeNode root = new TreeNode(nums[start]);
        //find the first element which is larger than root.val;
        int rightIdx = start + 1;
        while (rightIdx <= end) {
            if (nums[rightIdx] > root.val) break;
            rightIdx++;
        }
        root.left = buildTree(nums, start + 1, rightIdx - 1);
        root.right = buildTree(nums, rightIdx, end);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));