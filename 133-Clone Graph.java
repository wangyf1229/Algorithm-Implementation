/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        queue.offer(node);
        while (! queue.isEmpty()) {
            UndirectedGraphNode uNode = queue.poll();
            if (! map.containsKey(uNode)) {
                UndirectedGraphNode new_node = new UndirectedGraphNode(uNode.label);
                map.put(uNode, new_node);
                for (UndirectedGraphNode neighbor: uNode.neighbors) {
                    if (! map.containsKey(neighbor)) {
                        queue.offer(neighbor);
                    }
                }
            }
        }
        for (Map.Entry<UndirectedGraphNode, UndirectedGraphNode> entry: map.entrySet()) {
            UndirectedGraphNode nodeKey = entry.getKey();
            UndirectedGraphNode nodeValue = entry.getValue();
            for (UndirectedGraphNode neighbor: nodeKey.neighbors) {
                nodeValue.neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
}