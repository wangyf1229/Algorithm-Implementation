class Solution {
    public void nextPermutation(int[] nums) {
        //nums[0, (n-1)]
        //从后往前找，找到第一个非递减的数，即nums[i - 1] < nums[i]。比如5654321中的第一个5
        //Reverse nums[i, (n - 1)]，即将原来的递减序列改为递增序列
        //将nums[i - 1]与nums[i, (n - 1)]中比nums[i - 1]大的最小值对调，比如nums[i-1]是5，我就找看看有没有6，没有6就找7
        //实际上是找到该递增序列中第一个比nums[i - 1]大的数，即为比nums[i-1]大的最小值。（当该最小值重复出现时，该方法可以使最高顺位的值变小）
        int index = nums.length - 1;
        while (index > 0) {
            if (nums[index - 1] >= nums[index]) {
                index--;
            } else {
                break;
            }
        }
        if (index == 0) {
            //current permutation is the largest one
            reverseArray(0, nums.length - 1, nums);
            return;
        }
        
        reverseArray(index, nums.length - 1, nums);
        //find the smallest number among nums[index, nums.length - 1] which is larger than nums[index - 1];
        //It is the first number in nums[index, nums.length - 1] which is larger than nums[index - 1]; 
        for (int i = index; i < nums.length; i++) {
            if (nums[index - 1] < nums[i]) {
                swap(i, index - 1, nums);
                break;
            }
        }
    }
    
    public void reverseArray(int i, int j, int[] nums) {
        int start = i;
        int end = j;
        while (start <= end) {
            swap(start, end, nums);
            start++;
            end--;
        }
    }
    
    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp; 
    }
}