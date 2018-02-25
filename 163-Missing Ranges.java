class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        //just one number => No '->'
        //an range => 'a -> b'
        List<String> res = new ArrayList<>();
        int start = lower;
        for (int i = 0; i < nums.length; i++) {
            //avoid duplicate numbers
            if (nums[i] < start) continue;
            //watch out for overflow conditions
            if (nums[i] == start) {
                if (nums[i] == Integer.MAX_VALUE) return res;
                start++;
                continue;
            }
            addRanges(start, nums[i] - 1, res);
            if (nums[i] == Integer.MAX_VALUE) return res;
            start = nums[i] + 1;
        }
        if (start <= upper) addRanges(start, upper, res);
        return res;
    }

    public void addRanges(int num1, int num2, List<String> res) {
        if (num1 == num2) res.add(num1 + "");
        if (num2 > num1) res.add(num1 + "->" + num2);
    }
}