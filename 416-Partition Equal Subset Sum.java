class Solution {
    public boolean canPartition(int[] nums) {
        //knapsack problem
        if (nums == null || nums.length == 0) return false;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) return false;
        sum /= 2;

        //2d array dp[i][j] means whether the first i elements can make the sum j;
        //from this 2d array we could see that dp[i][j] is only related with the last row dp[i - 1][x]
        // boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        // for (int i = 0; i < nums.length + 1; i++) {
        //     dp[i][0] = true;
        // }
        // for (int j = 1; j < sum + 1; j++) {
        //     dp[0][j] = false;
        // }
        // for (int i = 1; i < nums.length + 1; i++) {
        //     for (int j = 1; j < sum + 1; j++) {
        //         dp[i][j] = nums[i - 1] > j ? dp[i - 1][j] : dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
        //     }
        // }
        // return dp[nums.length][sum];

        //1d array dp[j] means whether sum j can be achieved by current number
        boolean[] dp = new boolean[sum + 1];
        for (int num: nums) {
            dp[0] = true;
            //WATCH HERE!!! BE CAREFUL THAT THE NUMBER SHOULD NOT BE COVERED!
            for (int j = sum; j >= 1; j--) {
                dp[j] = num > j ? dp[j] : dp[j] || dp[j - num];
            }
        }
        return dp[sum];

    }
}