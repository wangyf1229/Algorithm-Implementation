public class Solution {
    /**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(ArrayList<Integer> nums) {
        // if (nums == null || nums.size() == 0) return 0;
        // ArrayList<Integer> newNums = new ArrayList<>();
        // for (Integer i : nums) {
        //     newNums.add(i*(-1));
        // }
        // int max = Integer.MIN_VALUE, minSum = 0;
        // int sum = 0;
        // for (Integer j: newNums) {
        //     sum = sum + j;
        //     max = Math.max(sum - minSum, max);
        //     minSum = Math.min(minSum, sum);

        // }
        // return max*(-1);

        if (nums == null || nums.size() == 0) return 0;
        int minResult = Integer.MAX_VALUE, maxSum = 0;
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
            minResult = Math.min(sum - maxSum, minResult);
            maxSum = Math.max(sum, maxSum);
        }
        return minResult;
    }
}
