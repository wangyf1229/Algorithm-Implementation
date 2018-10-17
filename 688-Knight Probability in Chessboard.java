class Solution {
    
    public double knightProbability(int N, int K, int r, int c) {
        double[][][] memo = new double[N][N][K];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < K; k++) {
                    memo[i][j][k] = -1.0;
                }
            }
        }
        return helper(N, K, r, c, memo);
    }
    
    //return the probability of success (the knight stays on the board) with remaining K steps
    public double helper(int N, int K, int r, int c, double[][][] memo) {
        double prob = 0.0;
        if (K == 0) return 1.0;
        if (memo[r][c][K - 1] != -1.0) return memo[r][c][K - 1];
        int[][] directions = new int[][]{{-2, -1}, {-1, -2}, {-2, 1}, {-1, 2}, {2, 1}, {1, 2}, {2, -1}, {1, -2}};
        for (int i = 0; i < directions.length; i++) {
            int x = r + directions[i][0];
            int y = c + directions[i][1];
            if (x >= 0 && x <= N - 1 && y >= 0 && y <= N - 1) {
                double tempProb = helper(N, K - 1, x, y, memo);
                prob += 1.0/8.0*tempProb;
            }
        }
        memo[r][c][K - 1] = prob;
        return prob;
    }
}