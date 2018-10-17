class Solution {
    public int divide(int dividend, int divisor) {
        //The first two cases is to avoid corner cases:
        //(1) dividend = Integer.MIN_VALUE, divisor = 1, return Integer.MIN_VALUE;
        //(2) dividend = Integer.MIN_VALUE, divisor = -1, return Integer.MAX_VALUE; => overflow
        //because under my logic, these two corner cases will convert to dividend = Integer.MIN_VALUE, divisor = -1 in the end.
        //So I need to find a way to distinguish them.
        if (divisor == 1) return dividend;
        if (divisor == -1 && dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;
        if (dividend > 0) return -divide(-dividend, divisor);
        if (divisor > 0) return -divide(dividend, -divisor);
        int res = 0;
        while (dividend <= divisor) {
            int shiftNum = 0;
            int temp = divisor;
            //temp cannot exceed Integer.MIN_VALUE either in the loop or outside
            while (dividend - temp < 0 && temp >= (Integer.MIN_VALUE/2)) {
                temp = temp << 1;
                shiftNum++;
            } 
            //Special case 1: dividend == divisor * 2^(shiftNum) So we get the result
            if (dividend == temp) {
                res += (1 << shiftNum);
                break;
            }
            if (shiftNum == 0) {
                //Special case 2: dividend is larger than divisor first So shiftNum == 0 now
                dividend -= temp;
                res += (1 << shiftNum);
            } else {
                dividend -= (temp >> 1);
                res += (1 << (shiftNum - 1));
            }
        }
        return res;
    }   
}