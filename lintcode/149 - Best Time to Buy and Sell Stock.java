public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int maxProfit = 0, minPrice = Integer.MAX_VALUE;
        for (int i : prices) {
            minPrice = i < minPrice ? i : minPrice;
            maxProfit = maxProfit < (i - minPrice) ? (i - minPrice) : maxProfit;
        }
        return maxProfit;
    }
}