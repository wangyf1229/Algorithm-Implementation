class Solution {
    public int maxKilledEnemies(char[][] grid) {
        //在第一行的时候记录每一列的hit数，在第一列的时候记录每一行的hit数
        //当前面一列是Bomb或者上面一行是是Bomb时，重新记录hit数
        //因为我是一行一行scan的，所以rowHits可以只是一个int，而不是一个array
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[] rowHits = new int[m];
        int[] colHits = new int[n];
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 || grid[i - 1][j] == 'W') {
                    colHits[j] = 0;
                    for (int k = i; k < m && grid[k][j] != 'W'; k++) {
                        if (grid[k][j] == 'E') colHits[j]++;
                    }
                }
                if (j == 0 || grid[i][j - 1] == 'W') {
                    rowHits[i] = 0;
                    for (int k = j; k < n && grid[i][k] != 'W'; k++) {
                        if (grid[i][k] == 'E') rowHits[i]++;
                    }
                }
                if (grid[i][j] == '0') {
                    res = Math.max(res, rowHits[i] + colHits[j]);
                }
            }
        }
        return res;
    }
}