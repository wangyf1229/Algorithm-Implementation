class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();//key => sum from 0 to index i, value => index i
        int sum = 0;
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                maxLength = i + 1;
            }else if (map.containsKey(sum - k)) {
                int idx = map.get(sum - k);
                maxLength = Math.max((i - idx), maxLength);
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLength;
        
    }
}