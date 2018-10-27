class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (deque.isEmpty() || nums[deque.peekLast()] > nums[i]) {
                deque.offer(i);
            } else {
                //deque.peekLast() <= nums[i];
                while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                    deque.pollLast();
                }
                deque.offerLast(i);
            }
            if (i >= k - 1) {
                while (deque.peekFirst() < (i - (k - 1))) {
                    deque.pollFirst();
                }
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}