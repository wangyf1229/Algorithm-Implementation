class Solution {
    private int[] nums;
    private Random rand;

    public Solution(int[] nums) {
        this.nums = nums;
        rand = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] shuf = Arrays.copyOf(nums, nums.length);
        for (int i = nums.length - 1; i >= 1; i--) {
            int t = rand.nextInt(i + 1);
            int temp = shuf[t];
            shuf[t] = shuf[i];
            shuf[i] = temp;
        }
        return shuf;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */