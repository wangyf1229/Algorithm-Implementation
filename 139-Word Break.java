class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict == null) return false;
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length() + 1; i++) {
            for (int j = 0; j < i; j++) {
                String cur = s.substring(j, i);
                if (dp[j] && dict.contains(cur)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];

    }
}