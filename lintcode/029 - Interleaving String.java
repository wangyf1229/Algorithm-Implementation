public class Solution {
    /*
     * @param : A string
     * @param : A string
     * @param : A string
     * @return: Determine whether s3 is formed by interleaving of s1 and s2
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        int k = s3.length();
        if (n+m != k) return false;
        boolean[][] f = new boolean[n+1][m+1];
        //initialization
        if (k==0) f[0][0] = true;
        for(int i = 1; i <= n; i++) {
            f[i][0] = s1.substring(0,i).equals(s3.substring(0,i));
        }
        for(int j = 1; j <= m; j++) {
            f[0][j] = s2.substring(0,j).equals(s3.substring(0,j));
        }
        //function
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++){
                f[i][j] = false;
                if(s3.charAt(i+j-1) == s1.charAt(i-1)) {
                    f[i][j] = f[i-1][j];
                    if(f[i][j]) continue;
                }
                if (s3.charAt(i+j-1) == s2.charAt(j-1)) {
                    f[i][j] = f[i][j-1];
                }
            }
        }
        return f[n][m];
    }
};