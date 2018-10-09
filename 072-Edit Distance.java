class Solution {
    public int minDistance(String word1, String word2) {
        //dp[i][j] => the minimum operations to convert word1[0, i-1] to word2[0, j-1]
        //dp[i][j] => the minimum operations to convert the first i chars in word1 to the first j chars in word2
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];  
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= word2.length(); i++) {
            dp[0][i] = i;
        }
        
        //Initialization
        //State transition
        //if word1 char at i is diff from word2 char at j
        //insert a char: dp[i][j] = dp[i][j - 1] + 1;
        //delete a char: dp[i][j] = dp[i - 1][j] + 1;
        //replace a char: dp[i][j] = dp[i - 1][j - 1] + 1;
        //if word1 char at i is the same as word2 char at j
        //keep the char: dp[i][j] = dp[i - 1][j - 1];
        //insert a char: dp[i][j] = dp[i][j - 1] + 1;
        //delete a char: dp[i][j] = dp[i - 1][j] + 1;
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    int minN = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]);
                    dp[i][j] = minN + 1;
                } else {
                    int minN = Math.min(Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1), dp[i - 1][j - 1]);
                    dp[i][j] = minN;
                }
            }
        }    
        return dp[word1.length()][word2.length()];
    }
}