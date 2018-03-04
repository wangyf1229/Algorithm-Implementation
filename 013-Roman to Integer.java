class Solution {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] arr = s.toCharArray();
        int res = toNumber(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            int bef = toNumber(arr[i - 1]);
            int cur = toNumber(arr[i]);
            if (bef < cur) {
                res += cur - 2 * bef;
            } else {
                res += cur;
            }
        }
        return res;
    }

    public int toNumber(char c) {
        int res = 0;
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return res;
    }
}