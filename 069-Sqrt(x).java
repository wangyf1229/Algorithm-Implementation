class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int start = 1;
        int end = x;
        while (start + 1 < end) {
            int mid = (start + end)/2;
            if (x/mid < mid) {
                end = mid;
            }
            if (x/mid > mid) {
                start = mid;
            }
            if (x/mid == mid) {
                return mid;
            }
        }
        return start;
    }
}