public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        int n = nums.length;
        if ( n == 0) return 0;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = 1;
        }
        for ( int i = 0; i < n; i++) {
            for ( int j = i; j < n; j++) {
                if (nums[j] > nums[i]) {
                    result[j] = Math.max (result[j], result[i] + 1);
                }
            }
        }
        int max = result[0];
        for ( int i = 0; i < n; i++) {
            max = Math.max(max, result[i]);
        }
        return max;
    }
}
