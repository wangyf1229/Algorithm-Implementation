public class Solution {
    /**
     * @param nums: The rotated sorted array
     * @return: void
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        // write your code
        int start = 0;
            int end = nums.size()-1;
            int target = nums.get(nums.size()-1);
            int firstIndex = 0;
            // find the first number which is smaller than the last number;
            while (start + 1 < end){
                int mid = start + (end - start)/2;
                if (nums.get(mid) > target){
                    start = mid;
                }else if (nums.get(mid) < target) {
                    end = mid;
                } else {
                    if (nums.get(mid) <= nums.get(end)) {
                        end --;
                    } else {
                        start ++;
                    }
                }
            }
           // System.out.println(start);
            if (nums.get(end)<target){
                firstIndex = end;
            }
            if (nums.get(start)<target){
                firstIndex = start;
            }

            for (int i = 0; i < firstIndex/2; i ++){
                int tmp1 = nums.get(i);
                int tmp2 = nums.get(firstIndex-i-1);
                nums.set(i,tmp2);
                nums.set((firstIndex-i-1),tmp1);
            }

            for (int i = firstIndex; i < (nums.size() + firstIndex)/2; i ++){
                int tmp1 = nums.get(i);
                int tmp2 = nums.get(nums.size() - 1 - i + firstIndex);
                nums.set(i,tmp2);
                nums.set((nums.size()-i-1+firstIndex),tmp1);
            }

            for (int i = 0; i < nums.size()/2; i ++){
                int tmp1 = nums.get(i);
                int tmp2 = nums.get(nums.size()-i-1);
                nums.set(i,tmp2);
                nums.set((nums.size()-i-1),tmp1);
            }
    }
}