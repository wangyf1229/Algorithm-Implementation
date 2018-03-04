class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        int plus = 1;
        int idx = digits.length - 1;
        int cur = digits[idx] + plus + carry;
        while (cur >= 10 && idx > 0) {
            digits[idx] = cur % 10;
            carry = 1;
            cur = digits[--idx] + carry;
        }
        if (cur < 10) {
            digits[idx] = cur;
            return digits;
        }
        int[] res = new int[digits.length + 1];
        for (int i = digits.length; i > 1; i--) {
            res[i] = digits[i - 1];
        }
        res[1] = cur % 10;
        res[0] = 1;
        return res;
    }
}