class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        //Solution 1: Counting Sort
        // if (nums == null || nums.length == 0) return;
        // int zeroNum = 0;
        // int oneNum = 0;
        // int twoNum = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     switch (nums[i]) {
        //         case 0: zeroNum++;
        //                 break;
        //         case 1: oneNum++;
        //                 break;
        //         case 2: twoNum++;
        //                 break;
        //     }
        // }
        // for (int i = 0; i < zeroNum; i++) {
        //     nums[i] = 0;
        // }
        // for (int i = zeroNum; i < zeroNum + oneNum; i++) {
        //     nums[i] = 1;
        // }
        // for (int i = zeroNum + oneNum; i < zeroNum + oneNum + twoNum; i++) {
        //     nums[i] = 2;
        // }

        //Solution 2: Partition Array into three parts
        if (nums == null || nums.length == 0) return;
        int left = 0;
        int right = nums.length - 1;
        int i = 0;
        while (i <= right) {

            if (nums[i] == 0) {
                swapNum(i, left, nums);
                left++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                swapNum(i, right, nums);
                right--;
            }

        }
    }

    public void swapNum(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}