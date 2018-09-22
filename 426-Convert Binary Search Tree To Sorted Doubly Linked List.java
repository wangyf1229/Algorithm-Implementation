/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

//recursion
class Solution {
    
    public Node prev = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) return root;
        Node dummy = new Node(1, null, null);
        prev = dummy;
        helper(root);
        Node newRoot = dummy.right;
        newRoot.left = prev;
        prev.right = newRoot;
        return newRoot; 
    }
    
    public void helper(Node cur) {
        if (cur == null) return;
        helper(cur.left);
        prev.right = cur;
        cur.left = prev;
        prev = cur;
        helper(cur.right);
        
    }
}

//iterative
class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) return root;
        Stack<Node> stack = new Stack<>();
        Node dummy = new Node(1, null, null);
        Node prev = dummy;
        while(root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            prev.right = root;
            root.left = prev;
            prev = root;
            root = root.right;
        }
        Node newRoot = dummy.right;
        newRoot.left = prev;
        prev.right = newRoot;
        return newRoot; 
    }
}