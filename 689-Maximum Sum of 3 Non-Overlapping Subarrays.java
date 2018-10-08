class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] prefixSum = new int[nums.length]; //prefixSum[i] => the sum from nums[0] to nums[i]
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        
        //maxFromLeft[i] => the start index of max sum from nums[0] to nums[i];
        int maxL = Integer.MIN_VALUE;
        int[] maxFromLeft = new int[nums.length]; 
        //maxFromRight[i] => the start index of max sum from nums[nums.length - 1] to nums[0];
        int maxR = Integer.MIN_VALUE;
        int[] maxFromRight = new int[nums.length]; 
        
        for (int i = k - 1; i < nums.length; i++) {
            int sum = prefixSum[i] - prefixSum[i - k + 1] + nums[i - k + 1];
            if (maxL < sum) {
                maxFromLeft[i] = i - k + 1;
                maxL = sum;
            } else {
                maxFromLeft[i] = maxFromLeft[i - 1];
            }
        }
        
        for (int i = nums.length - k; i >= 0; i--) {
            int sum = prefixSum[i + k - 1] - prefixSum[i] + nums[i];
            if (maxR <= sum) {
                maxFromRight[i] = i;
                maxR = sum;
            } else {
                maxFromRight[i] = maxFromRight[i + 1];
            }
        }
        
        int[] res = new int[3];
        int maxV = Integer.MIN_VALUE;
        for (int i = k; i <= nums.length - 2*k; i++) {
            int[] idx = new int[]{maxFromLeft[i - 1], i, maxFromRight[i + k]};
            int sum = 0;
            for (int j: idx) {
                sum += prefixSum[j + k - 1] - prefixSum[j] + nums[j];
            }
            if (sum > maxV) {
                res = Arrays.copyOf(idx, 3);
                maxV = sum;
            } 
        }
        return res;
    }
}