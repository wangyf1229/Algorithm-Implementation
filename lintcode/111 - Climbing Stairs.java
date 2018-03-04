public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] result = new int[n];
        result[0] = 1;
        result[1] = 2;
        for (int i = 2; i<n; i++) {
            result[i] = result[i-2] + result[i-1];
        }
        return result[n-1];
    }
}