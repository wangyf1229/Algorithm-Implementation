class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        //write your code here
        int l = nums.length;
        if (l==0){
            return -1;
        }
        int start =0;
        int end = l-1;
        int mid;
        while (start +1<end){
            mid = start + (end-start)/2;
         if (nums[mid]==target){
             end =mid;
         }else if(nums[mid] < target){
             start=mid;
         }else if(nums[mid] > target){
             end = mid;
         }
        }

        if (nums[start] == target){
            return start;
        }
        if (nums[end] == target){
            return end;
        }

        return -1;
    }
}