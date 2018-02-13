class Solution {
    public int reverse(int x) {
        int cur = 0;
        int sign = 1;
        if (x < 0) sign = -1;
        x = Math.abs(x);
        while (x > 0) {
            int prev = cur;
            cur = cur * 10 + x % 10;
            if ((cur - x % 10)/10 != prev) return 0;
            x = x / 10;
        }
        return sign * cur;

    }
}