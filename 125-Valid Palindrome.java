class Solution {
    public boolean isPalindrome(String s) {
        if (s == "" || s == null) return true;
        char[] str = s.toCharArray();
        int i = 0;
        int j = str.length - 1;
        while (i < j) {
            while ((i < j) && (! Character.isLetterOrDigit(str[i]))) {
                i++;
            }
            while ((i < j) && (! Character.isLetterOrDigit(str[j]))) {
                j--;
            }
            if (Character.toLowerCase(str[i]) == Character.toLowerCase(str[j])) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;

    }
}