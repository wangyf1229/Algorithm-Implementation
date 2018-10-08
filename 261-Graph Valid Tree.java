class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] parents = new int[n];
        int root = n;
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        for (int[] edge : edges) {
            int rootOfX = find(edge[0], parents);
            int rootOfY = find(edge[1], parents);
            if (rootOfX == rootOfY) return false; //there is cycle;
            union(rootOfX, rootOfY, parents);
            root--;
        }
        return root == 1;
    }
    
    public int find(int x, int[] parents) {
        if (parents[x] != x) {
            parents[x] = find(parents[x], parents);
        }
        return parents[x];
    }
    
    public void union(int x, int y, int[] parents) {
        //the root of x becomes the root of Y
        parents[find(y, parents)] = find(x, parents);
    }
}