class Solution {
    public boolean isMatch2(String s, String p) {
        if (p.length() == 0) return (s.length() == 0);
        boolean first_match = (s.length() != 0) && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if (p.length() >= 2) {
            if (p.charAt(1) == '*') {
                return (isMatch(s, p.substring(2)) || first_match && isMatch(s.substring(1), p));
            } else {
                return first_match && isMatch(s.substring(1), p.substring(1));
            }
        }
        return first_match && (s.length() == 1);
    }

    public boolean isMatch(String s, String p) {
        //dp[i][j] => means the ith char in string s matched jth char in string p
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        if (s == null || p == null) return false;
        dp[0][0] = true;
        for (int j = 0; j < p.length(); j++) {
            if (p.charAt(j) == '*') {
                dp[0][j + 1] = dp[0][j - 1];
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (p.charAt(j) == '*') {
                    if (s.charAt(i) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                        dp[i + 1][j + 1] = dp[i][j + 1] || dp[i + 1][j - 1] || dp[i + 1][j];
                    } else {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    }
                } else if (s.charAt(i) == p.charAt(j)){
                    dp[i + 1][j + 1] = dp[i][j];
                }
            }
        }
        return dp[s.length()][p.length()];
    }

}