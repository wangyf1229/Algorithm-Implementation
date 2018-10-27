class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        //Union Find
        int[] parents = new int[edges.length + 1];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        for (int[] edge: edges) {
            int rootA = find(parents, edge[0]);
            int rootB = find(parents, edge[1]);
            if (rootA == rootB) {
                return edge;
            } else {
                union(parents, rootA, rootB);
            }
        }
        return null;
    }
    
    public int find(int[] parents, int node) {
        if (parents[node] != node) {
            parents[node] = find(parents, parents[node]);
        }
        return parents[node];
    }
    
    public void union(int[] parents, int x, int y) {
        //the root of x becomes the root of y
        parents[y] = find(parents, x);
    }
}