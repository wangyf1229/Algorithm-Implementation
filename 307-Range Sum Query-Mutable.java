class NumArray {

    int[] nums;
    int[] tree;
    int n;
    //Binary Index Tree
    //time: O(n * logn)
    public NumArray(int[] nums) {
        n = nums.length;
        tree = new int[n + 1];
        this.nums = new int[n];
        for (int i = 0; i < n; i++) {
            update(i, nums[i]);
        }
    }

    //time: O(logn)
    public void update(int i, int val) {
        if (n == 0) return;
        int diff = val - nums[i];
        nums[i] = val;
        for (int j = i + 1; j <= n; j += j & (-j)) {
            tree[j] += diff;
        }
    }

    public int sumRange(int i, int j) {
        return sum(j + 1) - sum(i);
    }

    //O(logn)
    private int sum(int k) {
        int sum = 0;
        for (int i = k; i > 0; i -= i &(-i)) {
            sum += tree[i];
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */