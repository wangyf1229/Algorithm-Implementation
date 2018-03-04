public class LRUCache {
    private class ListNode {
        public int key;
        public int val;
        public ListNode next;
        public ListNode prev;
        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    private ListNode dummyNode;
    private HashMap<Integer, ListNode> hashmap;
    private int capacity;

    // @param capacity, an integer
    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummyNode = new ListNode(-1, -1);
        hashmap = new HashMap<Integer, ListNode> ();
    }

    // @return an integer
    public int get(int key) {
        if (hashmap.get(key) == null) return -1;
        ListNode node = hashmap.get(key);
        deleteNode(node);
        insertNode(dummyNode.prev, dummyNode, node);
        return node.val;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        // Insert the ListNode at the end of the LinkedList
        ListNode newNode = new ListNode(key, value);
        if (hashmap.containsKey(key)) {
            deleteNode(hashmap.get(key));
        }
        if (dummyNode.next == null) {
            insertNode(dummyNode, dummyNode, newNode);
        } else {
            insertNode(dummyNode.prev, dummyNode, newNode);
        }
        hashmap.put(key, newNode);
        if (hashmap.size() > capacity) {
            //capacity cannot be negative or 0;
            int keyDelete = dummyNode.next.key;
            deleteNode(dummyNode.next);
            hashmap.remove(keyDelete);
        }
    }

    public void insertNode (ListNode pNode, ListNode nNode, ListNode node) {
        node.next = nNode;
        node.prev = pNode;
        nNode.prev = node;
        pNode.next = node;
    }

    public void deleteNode(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }
}