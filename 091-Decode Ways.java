class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] dp = new int[s.length() + 1];
        //dp[i] => the decoding methods at ith char.
        dp[0] = 1;
        if (s.charAt(0) == '0') return 0;
        dp[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i-1) == '0') {
                if (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2') {
                    dp[i] = dp[i -2];
                } else {
                    return 0;
                }
            } else if (s.charAt(i - 2) == '0') {
                 dp[i] = dp[i - 1];
            } else {
                int num = Integer.parseInt(s.substring(i - 2, i));
                dp[i] = num <= 26 ? dp[i-1] + dp[i-2] : dp[i - 1];
            }
        }
        return dp[s.length()];
    }
}

class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        //dp[i] => the decoding methods at ith char.
        int prevprev = 1;
        if (s.charAt(0) == '0') return 0;
        int prev = 1;
        int now = 1;
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i-1) == '0') {
                if (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2') {
                    now = prevprev;
                } else {
                    return 0;
                }
            } else if (s.charAt(i - 2) == '0') {
                 now = prev;
            } else {
                int num = Integer.parseInt(s.substring(i - 2, i));
                now = num <= 26? prev + prevprev : prev;
            }
            prevprev = prev;
            prev = now;
        }
        return now;
    }
}