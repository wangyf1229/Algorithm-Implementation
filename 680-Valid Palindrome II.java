class Solution {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        int i = 0;
        int j = s.length() - 1;
        while (j >= i) {
            if (s.charAt(i) != s.charAt(j)) {
                String cand1 = s.substring(0, i) + s.substring(i+1);
                String cand2 = s.substring(0, j) + s.substring(j+1);
                return isValidPalindrome(cand1) || isValidPalindrome(cand2);
            } else {
                i++;
                j--;
            }
        }
        return true;
    }
    
    public boolean isValidPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (j >= i) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}