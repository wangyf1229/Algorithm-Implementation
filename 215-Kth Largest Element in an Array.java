class Solution {

    public int findKthLargest(int[] nums, int k) {
        //quick select
        shuffle(nums); //randomize the input to make the worst case input to have better performance
        return helper(nums, k, 0, nums.length - 1);
    }
    
    public int helper(int[] nums, int k, int left, int right) {
        int idx = partition(nums, left, right);
        if (idx == k - 1) return nums[k - 1];
        if (idx < k - 1) {
            return helper(nums, k, idx + 1, right);
        } else {
            return helper(nums, k, left, idx - 1);
        }
    }
    
    public void shuffle(int[] nums) {
        Random rand = new Random();
        for (int i = nums.length - 1; i >= 0; i--) {
            int j = rand.nextInt(i + 1);
            swap(nums, i, j);
        }
    }
    
    public int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int lo = left;
        int hi = right;
        int cur = left;
        while (cur <= hi) {
            int curNum = nums[cur];
            if (curNum < pivot) {
                swap(nums, hi, cur);
                hi--;
            } else if (curNum > pivot) {
                swap(nums, lo, cur);
                lo++;
                cur++;
            } else if (curNum == pivot) {
                cur++;
            }
        }
        return lo;
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

class Solution {
    
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (a - b));
        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}