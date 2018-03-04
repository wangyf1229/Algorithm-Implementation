public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // if (nums == null) return -1;
        // if (nums.length == 0) return 0;
        // int max = Integer.MIN_VALUE, minSum = 0;
        // int[] sum = new int[nums.length + 1];
        // sum[0] = 0;
        // for (int i = 1; i <= nums.length; i++) {
        //     sum[i] = sum[i - 1] + nums[i-1];
        //     max = Math.max(sum[i] - minSum, max);
        //     minSum = Math.min(sum[i], minSum);
        // }
        // return max;

        // if (nums == null) return -1;
        // if (nums.length == 0) return 0;
        // //minSum doesn't need to contain nums[0], but the maxSubarray must contain at least one element.
        // int max = nums[0], minSum = Math.min(nums[0],0);
        // int[] sum = new int[nums.length];
        // sum[0] = nums[0];
        // for (int i = 1; i < nums.length; i++) {
        //     sum[i] = sum[i-1] + nums[i];
        //     max = Math.max(sum[i]-minSum, max);
        //     minSum = Math.min(minSum, sum[i]);
        // }
        // return max;

        if (nums == null || nums.length == 0) return 0;
        int max = Integer.MIN_VALUE, minSum = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            max = Math.max(sum-minSum, max);
            minSum = Math.min(minSum, sum);
        }
        return max;
    }
}