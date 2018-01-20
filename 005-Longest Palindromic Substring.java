class Solution {
    //中心扩散法
    int lo = 0;
    int hi = 0;
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        for (int i = 0; i < s.length(); i++) {
            extend(s, i, i);
            extend(s, i, i + 1);
        }
        return s.substring(lo, hi + 1);
    }

    public void extend(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if (right - left + 1 > hi - lo + 1) {
               hi = right;
               lo = left;
            }
            left--;
            right++;
        }
        return;
    }

    //dp
    public String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) return s;
        String res = s.substring(0, 1);
        int max = Integer.MIN_VALUE;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
            if (max < 1) {
                max = 1;
                res = s.substring(i, i + 1);
            }
        }

        for (int i = 0; i < len - 1; i++) {
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            if (dp[i][i + 1] && max < 2) {
                max = 2;
                res = s.substring(i, i + 2);
            }
        }

        for (int l = 3; l <= len; l++) {
            for (int i = 0; i <= len - l; i++) {
                dp[i][i + l - 1] = dp[i + 1][i + l - 2] && s.charAt(i) == s.charAt(i + l - 1);
                if (dp[i][i + l - 1] && max < l) {
                    max = Math.max(max, l);
                    res = s.substring(i, i + l);
                }
            }
        }

        return res;
    }
}