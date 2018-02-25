class Solution {
    public void reverseWords(char[] str) {
        if (str == null || str.length == 0) return;
        int start = 0;
        int end = 0;
        while (end < str.length) {
            if (str[end] == ' ') {
                helper(str, start, end - 1);
                start = end + 1;
                end++;
            } else {
                end++;
            }
        }
        helper(str, start, end - 1);
        helper(str, 0, str.length - 1);
        return;
    }

    public void helper(char[] str, int s, int e) {
        for (int i = s, j = e; i <= j; i++, j--) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
        return;
    }
}