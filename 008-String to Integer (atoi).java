class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;
        int res = 0;
        int sign = 1;
        boolean numberStart = false;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ' && !numberStart) continue;
            if (str.charAt(i) == '-' && res == 0 && !numberStart) {
                sign = -1;
                numberStart = true;
                continue;
            } else if (str.charAt(i) == '+' && res == 0 && !numberStart) {
                sign = 1;
                numberStart = true;
                continue;
            } else if (! Character.isDigit(str.charAt(i))) {
                return sign * res;
            }
            numberStart = true;
            int num = str.charAt(i) - '0';
            if (Integer.MAX_VALUE / 10 < res || (Integer.MAX_VALUE / 10 == res && num > Integer.MAX_VALUE % 10)) {
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = 10 * res + num;
        }
        return sign * res;
    }
}