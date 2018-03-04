public class Solution {
    /**
     * @param s a string
     * @return an integer
     */
    public int minCut(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int[] f = new int [n+1];
        f[0] = 0;
        boolean[][] result = new boolean[n][n];
        result = isPalindrome3(s);
        for (int i = 1; i <= n; i++) {
            f[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (result[j][i-1]) {
                f[i] = Math.min(f[i],f[j]+1);
                }
            }
        }

        return f[n] - 1;


    }

    public boolean isPalindrome(String word) {
        int l = word.length();
        for (int i = 0, j = l-1; i < j; i++, j--) {
            if (word.charAt(i) != word.charAt(j)) return false;
        }
        return true;
    }

    public boolean[][] isPalindrome2(String s) {
        int n = s.length();
        boolean[][] result = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            result[i][i] = true;
        }

        for (int i = 0; i < n - 1; i++) {
            result[i][i+1] = (s.charAt(i) == s.charAt(i+1));
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                result[i][j] = result[i+1][j-1] && (s.charAt(i) == s.charAt(j));
            }
        }
        return result;
    }

    public boolean[][] isPalindrome3(String s) {
        int n = s.length();
        boolean[][] result = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            result[i][i] = true;
        }

        for (int i = 0; i < n - 1; i++) {
            result[i][i+1] = (s.charAt(i) == s.charAt(i+1));
        }

        for (int length = 3; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                result[i][i+length-1] = result[i+1][i+length-2]&& (s.charAt(i) == s.charAt(i+length-1));
            }
        }
        return result;
    }
}