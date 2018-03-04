public class Solution {
    /*
     * @param n: the integer to be reversed
     * @return: the reversed integer
     */
    public int reverseInteger(int n) {
        int result = 0;
        while (n != 0) {
            int tail = n % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail)/10 != result) return 0;
            n = n / 10;
            result = newResult;
        }

        return result;
    }
}