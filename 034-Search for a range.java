class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end) {
            int mid = (start + end)/2;
            if (target > nums[mid]) {
                start = mid;
            } else if (target < nums[mid]) {
                end = mid;
            } else if (target == nums[mid]) {
                if (target > nums[mid - 1] && target < nums[mid + 1]) {
                    return new int[]{mid, mid};
                }
                int bef = mid;
                int after = mid;
                while (bef >= 0 && nums[bef] == target) {
                    bef--;
                }
                while (after < nums.length && nums[after] == target) {
                    after++;
                }
                return new int[]{bef + 1, after - 1};
            }
        }
        if (target == nums[start] && target == nums[end]) return new int[]{start, end};
        if (target == nums[start]) return new int[]{start, start};
        if (target == nums[end]) return new int[] {end, end};
        return new int[]{-1, -1};
    }
}