class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (start + end)/2;
            if (nums[mid] < nums[end]) {
                end = mid;
            } else if (nums[mid] > nums[start] && nums[end] < nums[start]) {
                start = mid;
            }
        }
        return Math.min(nums[start], nums[end]);
    }
}