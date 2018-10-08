class Solution {
    public int maxProfit(int[] prices) {
        int profitMax = 0;
        if (prices == null || prices.length == 0) return profitMax;
        int[] dp = new int[prices.length]; //dp[i] => the smallest number including prices[i]
        dp[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (dp[i - 1] < prices[i]) profitMax = Math.max(profitMax, prices[i] - dp[i - 1]);
            dp[i] = Math.min(prices[i], dp[i - 1]);
        }
        return profitMax;
    }
}