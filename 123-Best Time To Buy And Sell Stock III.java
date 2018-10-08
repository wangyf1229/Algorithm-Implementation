class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1) return 0;
        //profitFromLeft[i] => the max profit I get if I sell stock before or on day i;
        int[] profitFromLeft = new int[prices.length]; 
        int minLeft = prices[0];
        int maxProfitLeft = 0;
        //profitFromRight[i] => the max profit I get if I buy stock after or on day i;
        int[] profitFromRight = new int[prices.length]; 
        int maxRight = prices[prices.length - 1];
        int maxProfitRight = 0;
        
        int res = 0;    
        for (int i = 1; i < prices.length; i++) {
            maxProfitLeft = Math.max(maxProfitLeft, prices[i] - minLeft);
            profitFromLeft[i] = maxProfitLeft;
            minLeft = Math.min(prices[i], minLeft);
        }
        for (int i = prices.length - 2; i >= 0; i--) {
            maxProfitRight = Math.max(maxProfitRight, maxRight - prices[i]);
            profitFromRight[i] = maxProfitRight;
            maxRight = Math.max(prices[i], maxRight);
        }

        for (int i = 0; i < prices.length; i++) {
            int profit = 0;
            if (i == 0) {
                profit = profitFromRight[0];
            } else if (i == prices.length - 1) {
                profit = profitFromLeft[i];
            } else {
                profit = profitFromLeft[i] + profitFromRight[i + 1];
            }
            res = Math.max(profit, res);
        }
        
        return res;        
    }
}