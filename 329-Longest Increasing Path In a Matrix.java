class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memo = new int[m][n];
        int maxL = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxL = Math.max(dfs(matrix, i, j, memo), maxL);
            }
        }
        return maxL;
    }
    
    public int dfs(int[][] matrix, int x, int y, int[][] memo) {
        if (memo[x][y] > 0) return memo[x][y];
        int maxL = 0;
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : directions) {
            int i = x + dir[0];
            int j = y + dir[1];
            if (i >= 0 && i <= matrix.length - 1 && j >= 0 && j <= matrix[0].length - 1 && matrix[i][j] < matrix[x][y]) {
                maxL = Math.max(maxL, dfs(matrix, i, j, memo));
            }
        }
        memo[x][y] = 1 + maxL;
        return memo[x][y];
    }
}