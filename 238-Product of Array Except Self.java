class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int product = 1;
        res[0] = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            res[i] = nums[i] * res[i - 1];
        }
        for (int i = nums.length - 1; i > 0; i--) {
            res[i] = product * res[i - 1];
            product *= nums[i];
        }
        res[0] = product;
        return res;
    }
}