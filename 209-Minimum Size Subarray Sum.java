class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null) return 0;
        int start = 0;
        int end = 0;
        int minLen = nums.length + 1;
        int count = 0;
        while (end  < nums.length) {
            count += nums[end];
            while (count >= s) {
                minLen = Math.min((end - start + 1), minLen);
                count -= nums[start];
                start++;
            }
            end++;
        }
        return minLen == nums.length + 1 ? 0 : minLen;
    }
}