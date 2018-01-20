class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        //dp[i] means the maximum subarray ending in dp[i]
        int[] dp = new int[nums.length];
        int max = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] > 0? dp[i - 1] + nums[i] : nums[i];
            max = Math.max(dp[i], max);
        }
        return max;
    }

    // prefix Sum的定义
    // 假设数组的下标是从1 ~ n
    // 那么Sum[i] = a[1] + a[2] + a[3] + a[3] + a[4]＋...... + a[i]

    // 那么连续的一段和，就是a[i] + a[i + 1] + a[i + 2] + a[i + 3] + .... + a[j] = Sum[j] - Sum[i - 1]
    // 这里就可以看出，任意一段子段和都可以表示成两个前缀之差．

    // 假设我们已经枚举到j了，那么为了使得连续和最大，Sum[j] 确定的情况下，Sum[i - 1]的值越小越好．
    // 所以我们不防在枚举ｊ的过程中，顺便记录一下 Sum[0] ~ Sum[j - 1] 中的最小值 就可以了．
    // 这求是求maxmimum subarray的思路
    public int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        //Prefix Sum
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int minSum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            max = Math.max(sum - minSum, max);
            minSum = Math.min(sum, minSum);
        }
        return max;
    }

    public int maxSubArray3(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return divideAndConquer(0, nums.length - 1, nums);
    }

    public int divideAndConquer(int left, int right, int[] nums) {
        if (left == right) return nums[left];
        int mid = (left + right)/2;
        int lRes = divideAndConquer(left, mid, nums);
        int rRes = divideAndConquer(mid + 1, right, nums);
        int maxR = 0;
        int maxL = 0;
        int sumR = 0;
        int sumL = 0;
        for (int i = mid - 1; i >= left; i--) {
            sumR = sumR + nums[i];
            maxR = Math.max(sumR, maxR);
        }
        for (int i = mid + 2; i <= right; i++) {
            sumL = sumL + nums[i];
            maxL = Math.max(sumL, maxL);
        }

        int maxRes = maxR + nums[mid] + nums[mid + 1] + maxL;
        int res = Math.max(maxRes, rRes);
        res = Math.max(res, lRes);
        return res;
    }
}