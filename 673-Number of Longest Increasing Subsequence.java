class Solution {
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int number = 0;
        int maxLen = 1;
        int[] lis = new int[nums.length]; //the longest increasing subsequence ending in nums[i]
        int[] cnt = new int[nums.length]; //how many ways to form current longest lis
        lis[0] = 1;
        cnt[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            cnt[i] = lis[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] >= nums[i]) continue;
                //nums[j] < nums[i]
                if (lis[j] + 1 > lis[i]) {
                    cnt[i] = cnt[j];
                    lis[i] = lis[j] + 1;
                } else if (lis[j] + 1 == lis[i]){
                    cnt[i] += cnt[j];
                }
            }
            maxLen = Math.max(maxLen, lis[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (lis[i] == maxLen) number += cnt[i];
        }
        return number;
    }
}