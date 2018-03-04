public class Solution {
    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] f = new int[n+1][m+1];
        //initialization
        for (int j = 0; j <= n; j++) {
            f[j][0] = j;
        }
        for (int i = 0; i <= m; i++) {
            f[0][i] = i;
        }
        //function
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int min = Math.min(f[i-1][j]+1, f[i][j-1]+1);
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    f[i][j] = Math.min(f[i-1][j-1], min);
                }else {
                    f[i][j] = Math.min(f[i-1][j-1] + 1, min);
                }
            }
        }

        return f[n][m];
    }
}