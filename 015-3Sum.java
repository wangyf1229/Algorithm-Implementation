class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //O(n^2)
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int idx = 0;
        while (idx < nums.length - 2) {
            twoSum(nums, idx + 1, nums[idx], res);
            while (idx < nums.length - 2 && nums[idx] == nums[idx + 1]) {
                idx++;
            }
            idx++;
        }
        return res;
    }
    
    public void twoSum(int[] nums, int start, int firstNum, List<List<Integer>> res) {
        int i = start;
        int j = nums.length - 1;
        int target = -firstNum;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                List<Integer> list = new ArrayList<>();
                list.add(firstNum);
                list.add(nums[i]);
                list.add(nums[j]);
                res.add(list);
                while (i < j && nums[i] == nums[i + 1]) {
                    i++;
                }
                i++;
                while (i < j && nums[j] == nums[j - 1]) {
                    j--;
                }
                j--;
            } if (sum < target) {
                i++;
            } if (sum > target) {
                j--;
            }
        }
    }
}