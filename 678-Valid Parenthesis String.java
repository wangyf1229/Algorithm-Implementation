class Solution {
    public boolean checkValidString(String s) {
        int low = 0; //the minimum number of left parentheses from the begining to current char
        int high = 0; //the maximum number of right parentheses from the begining to current char
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                low++;
                high++;
            } else if (s.charAt(i) == ')') {
                low--;
                high--;
            } else if (s.charAt(i) == '*') {
                low--;
                high++;
            }
            i++;
            if (low < 0) low = 0;
            if (high < 0) return false;
        }
        return low <= 0;
    }
}