class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int numCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                numCount++;
                nums[numCount - 1] = nums[i];
            }
         }
        for (int i = numCount; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}