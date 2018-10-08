class Solution {
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int numLIS = 1;
        int maxL = 1;
        int[] dp = new int[nums.length]; //dp[i] => the LIS ending in current char
        int[] sol = new int[nums.length]; //sol[i] => the number of solutions in current char
        dp[0] = 1;
        sol[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int maxCur = 1;
            int solCur = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j] + 1 > maxCur) {
                        maxCur = dp[j] + 1;
                        solCur = sol[j];
                    } else if (dp[j] + 1 == maxCur) {
                        solCur += sol[j];
                    }
                }
            }
            dp[i] = maxCur;
            sol[i] = solCur;
            if (maxCur > maxL) {
                numLIS = solCur;
                maxL = maxCur;
            } else if (maxCur == maxL) {
                numLIS += solCur;
            }
        }
        return numLIS;
    }
}