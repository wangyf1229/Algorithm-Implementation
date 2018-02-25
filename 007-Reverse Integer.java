class Solution {
    public int reverse(int x) {
        int cur = 0;
        int sign = 1;
        if (x < 0) sign = -1;
        x = Math.abs(x);
        while (x > 0) {
            //int prev = cur;
            if (Integer.MAX_VALUE / 10 < cur || (Integer.MAX_VALUE / 10 == cur && x % 10 > Integer.MAX_VALUE % 10)) {
                return 0;
            }
            cur = cur * 10 + x % 10;
            // if ((cur - x % 10)/10 != prev) return 0;
            x = x / 10;
        }
        return sign * cur;

    }
}

//two ways to solve overflow questions:
//1. check whether the new value can be restored to the old value
//2. check whether the old number is smaller than Integer.MAX_VALUE/10 (recommended)
//also see 8. String to Integer(atoi)