public class Solution {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        int n = S.length();
        int m = T.length();
        int[][] f = new int[n+1][m+1];
        //initialization
        for (int j = 0; j <= m; j++) {
            f[0][j] = 0;
        }
        for (int i = 0; i <= n; i++){
            f[i][0] = 1;
        }
        //function
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (S.charAt(i-1) == T.charAt(j-1)) {
                    f[i][j] = f[i-1][j-1] + f[i-1][j];
                } else {
                    f[i][j] = f[i-1][j];
                }
            }
        }
        return f[n][m];
    }
}