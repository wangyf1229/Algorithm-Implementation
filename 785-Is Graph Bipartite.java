class Solution {
    public boolean isBipartite(int[][] graph) {
        //BFS
        int[] visited = new int[graph.length];
        //0 -> uncolored; 1 -> black; 2 -> white;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) {
                queue.offer(i);
                visited[i] = 1;
                while (!queue.isEmpty()) {
                    int size = queue.size();
                    for (int j = 0; j < size; j++) {
                        int current = queue.poll();
                        int[] neighbours = graph[current];
                        for (int n : neighbours) {
                            if (visited[n] != 0 && visited[n] == visited[current]) return false;
                            if (visited[n] == 0) {
                                visited[n] = visited[current] == 1 ? 2: 1;
                                queue.offer(n);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}