public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        if (nums == null || nums.size() == 0) return 0;
        int maxSum = Integer.MIN_VALUE, minSum = 0, sum = 0;
        int[] right = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            sum = sum + nums.get(i);
            maxSum = Math.max(maxSum, sum - minSum);
            minSum = Math.min(minSum, sum);
            right[i] = maxSum;
        }

        maxSum = Integer.MIN_VALUE;
        minSum = 0;
        sum = 0;
        int[] left = new int[nums.size()];
        for (int i = nums.size() - 1; i >= 0; i--) {
            sum = sum + nums.get(i);
            maxSum = Math.max(maxSum, sum - minSum);
            minSum = Math.min(minSum, sum);
            left[i] = maxSum;
        }

        int maxResult = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size() - 1; i++) {
            int sumTwoArrays = right[i] + left[i+1];
            maxResult = Math.max(maxResult, sumTwoArrays);
        }
        return maxResult;
    }
}

