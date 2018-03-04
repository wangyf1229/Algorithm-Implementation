public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        int n = A.length();
        int m = B.length();
        if (n == 0 || m == 0) return 0;
        int[][] f = new int[n+1][m+1];
        //initialization
        for (int i = 0; i <= n; i++){
            f[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            f[0][i] = 0;
        }
        //function
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++) {
                f[i][j] = Math.max(f[i-1][j],f[i][j-1]);
                if (A.charAt(i-1) == B.charAt(j-1)) {
                    f[i][j] = Math.max(f[i-1][j-1]+1, f[i][j]);
                }
            }
        }

        return f[n][m];
    }
}
