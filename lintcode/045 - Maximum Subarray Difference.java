public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two
     *          Subarrays
     */
    public int maxDiffSubArrays(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int maxResult = Integer.MIN_VALUE, minSum = 0, sum = 0;
        int minResult = Integer.MAX_VALUE, maxSum = 0;
        int[] leftMin = new int[nums.length];
        int[] leftMax = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxResult = Math.max(maxResult, sum - minSum);
            minSum = Math.min(sum, minSum);
            minResult = Math.min(minResult, sum - maxSum);
            maxSum = Math.max(maxSum, sum);
            leftMax[i]= maxResult;
            leftMin[i] = minResult;
        }

        maxResult = Integer.MIN_VALUE; minSum = 0; sum = 0;
        minResult = Integer.MAX_VALUE; maxSum = 0;
        int[] rightMax = new int[nums.length];
        int[] rightMin = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i];
            maxResult = Math.max(maxResult, sum - minSum);
            minSum = Math.min(sum, minSum);
            minResult = Math.min(minResult, sum - maxSum);
            maxSum = Math.max(maxSum, sum);
            rightMax[i] = maxResult;
            rightMin[i] = minResult;
        }

        int finalResult = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            int largest = Math.max(Math.abs(leftMax[i] - rightMin[i+1]), Math.abs(leftMin[i] - rightMax[i+1]));
            finalResult = Math.max(largest, finalResult);
        }
        return finalResult;


    }
}

