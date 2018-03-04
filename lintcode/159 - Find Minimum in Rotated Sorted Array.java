public class Solution {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0){
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int target = nums[nums.length - 1];

        // find the first element <= target
        while (start + 1 < end){
            int mid = start + (end - start)/2;
            if (nums[mid] <= target){
                end = mid;
            }else{
                start = mid;
            }
        }

        if (nums[start] <= target){
            return nums[start];
        }
        if (nums[end] <= target){
            return nums[end];
        }
        return -1;
    }
}