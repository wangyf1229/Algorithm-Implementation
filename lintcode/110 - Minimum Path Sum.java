public class Solution {
    /**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if (m==0) return 0;
        int n = grid[0].length;
        if (n==0) return 0;
        //state
        int[][] result = new int[m][n];

        //Initialization
        result[0][0]=grid[0][0];
        for (int i = 1; i < m; i++) {
            result[i][0] = grid[i][0] + result[i-1][0];
        }
        for (int i = 1; i < n; i++) {
            result[0][i] = grid[0][i] + result[0][i-1];
        }

        //Function
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                result[i][j] = Math.min(result[i-1][j],result[i][j-1]) + grid[i][j];
            }
        }

        //  for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         System.out.printf("%d ", result[i][j]);
        //     }
        //     System.out.println();
        // }
        //Answer
        return result[m-1][n-1];
    }
}
