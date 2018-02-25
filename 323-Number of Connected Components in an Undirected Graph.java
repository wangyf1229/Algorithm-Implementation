class Solution {
    //Union Find
    public int countComponents(int n, int[][] edges) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int[] edge: edges) {
            int first = find(map, edge[0]);
            int second = find(map, edge[1]);
            map.put(first, second);
        }
        for (int i = 0; i < n; i++) {
            int root = find(map, i);
            if (! set.contains(root)) {
                count++;
                set.add(root);
            }
        }
        return count;
    }

    public int find(Map<Integer, Integer> map, int i) {
        if (! map.containsKey(i)) map.put(i, i);
        if (map.get(i) == i) return i;
        return find(map, map.get(i));
    }

    public int countComponents2(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        int count = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge: edges) {
            List<Integer> list = map.getOrDefault(edge[0], new ArrayList<>());
            list.add(edge[1]);
            map.put(edge[0], list);
            List<Integer> list2 = map.getOrDefault(edge[1], new ArrayList<>());
            list2.add(edge[0]);
            map.put(edge[1], list2);
        }
        for (int i = 0; i < n; i++) {
            if (! visited[i]) {
                count++;
                bfs(visited, map, i);
            }
        }
        return count;
    }

    //dfs
    public void dfs(boolean[] visited, Map<Integer, List<Integer>> map, int i) {
        visited[i] = true;
        if (! map.containsKey(i)) return;
        List<Integer> list = map.get(i);
        for (int node: list) {
            if (map.containsKey(node) && (!visited[node])) {
                dfs(visited, map, node);
            }
        }
        return;
    }

    //bfs
    public void bfs(boolean[] visited, Map<Integer, List<Integer>> map, int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        while (! queue.isEmpty()) {
            int temp = queue.poll();
            visited[temp] = true;
            if (! map.containsKey(temp)) continue;
            List<Integer> list = map.get(temp);
            for (int node: list) {
                if (map.containsKey(node) && (!visited[node])) {
                    queue.offer(node);
                }
            }
        }
    }
}