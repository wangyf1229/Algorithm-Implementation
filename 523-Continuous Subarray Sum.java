class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        k = Math.abs(k);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) {
                int remainder = sum % k;
                if (remainder == 0 && i >= 1) return true;
                if (map.containsKey(remainder)) {
                    int index = map.get(remainder);
                    if ((i - index) >= 2) return true;
                } else {
                    map.put(remainder, i);
                } 
            } else {
                if (i >= 1 && sum == 0) return true;
            }
                
        }
        return false;
    }
}