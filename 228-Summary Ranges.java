//two pointer
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        int start = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) continue;
            if (nums[i - 1] == start) res.add(nums[i - 1]+"");
            if (nums[i - 1] != start) res.add(start + "->" + nums[i - 1]);
            start = nums[i];
        }

        if (start == nums[nums.length - 1]) {
            res.add(nums[nums.length - 1]+"");
        } else {
            res.add(start + "->" + nums[nums.length - 1]);
        }

        return res;
    }
}