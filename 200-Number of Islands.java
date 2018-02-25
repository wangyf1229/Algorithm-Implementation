class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1'){
                    //bfs(grid, i, j);
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int x, int y) {
        if (grid[x][y] == '0') return;
        int m = grid.length;
        int n = grid[0].length;
        grid[x][y] = '0';
        if (x > 0 && grid[x - 1][y] == '1') dfs(grid, (x - 1), y);
        if (x < (m - 1) && grid[x + 1][y] == '1') dfs(grid, (x + 1), y);
        if (y > 0 && grid[x][y - 1] == '1') dfs(grid, x, (y - 1));
        if (y < (n - 1) && grid[x][y + 1] == '1') dfs(grid, x, (y + 1));
    }

    public void bfs(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<int[]> ();
        queue.offer(new int[]{i, j});
        grid[i][j] = '0';
        while (! queue.isEmpty()) {
            int[] co = queue.poll();
            int x = co[0];
            int y = co[1];
            if (x > 0 && grid[x - 1][y] == '1') {
                grid[x - 1][y] = '0';
                queue.offer(new int[]{(x - 1), y});
            }
            if (x < (m - 1) && grid[x + 1][y] == '1') {
                grid[x + 1][y] = '0';
                queue.offer(new int[]{(x + 1), y});
            }
            if (y > 0 && grid[x][y - 1] == '1') {
                grid[x][y - 1] = '0';
                queue.offer(new int[]{x, (y - 1)});
            }
            if (y < (n - 1) && grid[x][y + 1] == '1') {
                grid[x][y + 1] = '0';
                queue.offer(new int[]{x, (y + 1)});
            }
        }
    }
}