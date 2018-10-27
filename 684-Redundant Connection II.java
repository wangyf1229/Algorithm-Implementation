class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        //Union Find
        int[] parents = new int[edges.length + 1];
        int[] cand1 = new int[]{-1, -1};
        int[] cand2 = new int[]{-1, -1};
        for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];
            if (parents[child] != 0) {
                cand1 = new int[]{parents[child], child};
                cand2 = new int[]{parent, child};
                edge[1] = -1;
                break;
            } else {
                parents[child] = parent;
            }
        }
        
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        for (int[] edge: edges) {
            if (edge[1] == -1) continue;
            int rootA = find(parents, edge[0]);
            int rootB = find(parents, edge[1]);
            if (rootA == rootB) {
                if (cand1[0] == -1) {
                    return edge;
                } else {
                    return cand1;
                }
            } else {
                union(parents, rootA, rootB);
            }
        }
        return cand2;
    }
    
    public int find(int[] parents, int node) {
        //O(log(n))
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