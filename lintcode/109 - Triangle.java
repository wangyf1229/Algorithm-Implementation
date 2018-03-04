public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */

    // public int minimumTotal(int[][] triangle) {
    //     int h = triangle.length;
    //     int w = triangle[h-1].length;
    //     int[][] hash = new int[h][w];
    //     for (int i = 0; i < h; i++) {
    //         for (int j = 0; j < w; j++) {
    //             hash[i][j] = Integer.MAX_VALUE;
    //         }
    //     }
    //     return dfs(triangle,hash,0,0);
    // }

    // public int dfs(int[][] triangle, int[][] hash, int x, int y) {
    //     if (x == triangle.length) {
    //         return 0;
    //     }
    //     if (hash[x][y] != Integer.MAX_VALUE) {
    //         return hash[x][y];
    //     }
    //     int left = dfs(triangle,hash,x+1,y);
    //     int right = dfs(triangle,hash,x+1,y+1);

    //     hash[x][y] = Math.min(left,right) + triangle[x][y];
    //     return hash[x][y];
    // }

    public int minimumTotal(int[][] triangle) {
        //bottomup
        int n = triangle.length;
        int[] f = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = triangle[n-1][i];
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                f[j] = Math.min(f[j],f[j+1]) + triangle[i][j];
            }
        }
        return f[0];


    }
}
