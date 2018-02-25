class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        int s = 0;
        while (s < nums.length) {
            twoSum(nums, -nums[s], s + 1, res);
            while (s < (nums.length - 1) && nums[s] == nums[s + 1]  ) {
                s++;
            }
            s++;
        }
        return res;
    }

    public void twoSum(int[] nums, int target, int start, List<List<Integer>> res) {
        int lo = start;
        int hi = nums.length - 1;
        while (lo < hi) {
            if (nums[lo] + nums[hi] == target) {
                List<Integer> list = new ArrayList<>();
                list.add(-target);
                list.add(nums[lo]);
                list.add(nums[hi]);
                res.add(list);
                while (lo < hi && nums[lo] == nums[lo + 1]) {
                    lo++;
                }
                while (lo < hi && nums[hi] == nums[hi - 1]) {
                    hi--;
                }
                lo++;
                hi--;

            } else if (nums[lo] + nums[hi] < target) {
                lo++;
            } else if (nums[lo] + nums[hi] > target) {
                hi--;
            }
        }
    }
}