//BFS
class Solution {
    public int findCircleNum(int[][] M) {
        int circle = 0;
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < M.length; i++) {
            if (visited.contains(i)) continue;
            visited.add(i);
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            circle++;
            while (!queue.isEmpty()) {
                int k = queue.poll();
                for (int j = 0; j < M[k].length; j++) {
                    if (M[k][j] == 1 && (!visited.contains(j))) {
                        queue.add(j);
                        visited.add(j);
                    }
                }
            }
        }
        return circle;
        
    }
}

//Union Find
class Solution {
    public int findCircleNum(int[][] M) {
        int[] parents = new int[M.length];
        int circles = M.length;
        for (int i = 0; i < M.length; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < M.length; i++) {
            for (int j = i + 1; j < M[i].length; j++) {
                if (M[i][j] == 1) {
                    int rootOfI = find(i, parents);
                    int rootOfJ = find(j, parents);
                    //if 2,3,4 are 1's friends and 3, 4 are 2's friends, we don't need to calculate again
                    if (rootOfI != rootOfJ) {
                        union(rootOfI, rootOfJ, parents);
                        circles--;
                    }
                }
            }
        }
        return circles == 0? 1: circles;
    }
    
    public int find(int x, int[] parents) {
        if (parents[x] != x) {
            //path compression
            parents[x] = find(parents[x], parents);
        }
        return parents[x];
    }
    
    public void union(int x, int y, int[] parents) {
        //the root of X becomes the root of Y
        parents[find(y, parents)] = find(x, parents);
    }
}