class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int minToCur = 1;
        int maxToCur = 1;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int minBef = minToCur;
            int maxBef = maxToCur;
            minToCur = Math.min(nums[i], Math.min(maxBef * nums[i], minBef * nums[i]));
            maxToCur = Math.max(nums[i], Math.max(maxBef * nums[i], minBef * nums[i]));
            res = Math.max(nums[i], Math.max(maxToCur, res));
        }
        return res;
    }
}