class AllOne {
    
    class ListNode {
        int value;
        Set<String> set;
        ListNode prev;
        ListNode next;
        
        public ListNode(int val) {
            value = val;
            set = new HashSet<>();
            prev = null;
            next = null;
        }
    }
    
    Map<String, Integer> keyValue;
    Map<Integer, ListNode> valueNode;
    ListNode min;
    ListNode max;
    
    /** Initialize your data structure here. */
    public AllOne() {
        keyValue = new HashMap<>();
        valueNode = new HashMap<>();
        max = new ListNode(100);
        min = new ListNode(0);
        max.prev = min;
        max.next = min;
        min.prev = max;
        min.next = max;
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (!keyValue.containsKey(key)) {
            int value = 1;
            keyValue.put(key, value);
            if (valueNode.containsKey(value)) {
                ListNode node = valueNode.get(value);
                node.set.add(key);
            } else {
                ListNode node = new ListNode(value);
                node.set.add(key);
                insertListNodeAfter(min.prev, node);
                valueNode.put(value, node);
            }
        } else {
            int value = keyValue.get(key) + 1;
            keyValue.put(key, value);
            
            ListNode lastNode = valueNode.get(value - 1);
            if (valueNode.containsKey(value)) {
                ListNode node = valueNode.get(value);
                node.set.add(key);
            } else {
                ListNode node = new ListNode(value);
                node.set.add(key);
                insertListNodeAfter(lastNode.prev, node);
                valueNode.put(value, node);
            }
            
            if (lastNode.set.size() == 1) {
                removeListNode(lastNode);
                valueNode.remove(value - 1);
            } else {
                lastNode.set.remove(key);
            }
        }
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (keyValue.containsKey(key)) {
            int value = keyValue.get(key) - 1;
            
            if (value == 0) {
                keyValue.remove(key);
            } else {
                keyValue.put(key, value);
            }
            
            ListNode lastNode = valueNode.get(value + 1);
            if (valueNode.containsKey(value)) {
                ListNode node = valueNode.get(value);
                node.set.add(key);
            } else {
                if (value != 0) {
                    ListNode node = new ListNode(value);
                    node.set.add(key);
                    insertListNodeAfter(lastNode, node);
                    valueNode.put(value, node);
                }
            }
            
            if (lastNode.set.size() == 1) {
                removeListNode(lastNode);
                valueNode.remove(value + 1);
            } else {
                lastNode.set.remove(key);
            }
        }
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (max.next == min) return "";
        ListNode node = valueNode.get(1);
        return max.next.set.iterator().next();
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (min.prev == max) return "";
        return min.prev.set.iterator().next();
    }
    
    public void removeListNode(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
    }
    
    public void insertListNodeAfter(ListNode prev, ListNode node) {
        node.next = prev.next;
        node.prev = prev;
        prev.next = node;
        node.next.prev = node;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */