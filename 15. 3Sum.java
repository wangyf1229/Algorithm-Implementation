public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (nums == null || nums.length == 0) return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            result = TwoSum(i + 1, nums.length - 1, -nums[i], nums, result);
        }
        return result;
    }

    public List<List<Integer>> TwoSum(int left, int right, int target, int[] numbers, List<List<Integer>> result) {
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else if (sum == target) {
                List<Integer> resultTmp = new LinkedList<>();
                resultTmp.add(-target);
                resultTmp.add(numbers[left]);
                resultTmp.add(numbers[right]);
                result.add(resultTmp);
                left++;
                right--;
                while (left < right && numbers[left] == numbers[left-1]){
                    left++;
                }
                while (left < right && numbers[right] == numbers[right + 1]) {
                    right--;
                }
            }
        }
        return result;
    }
}