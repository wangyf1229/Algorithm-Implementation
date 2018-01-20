class Solution {
    public String reverseString(String s) {
        char[] newChar = s.toCharArray();
        int left = 0;
        int right = newChar.length - 1;
        while (left < right) {
            char a = newChar[left];
            newChar[left] = newChar[right];
            newChar[right] = a;
            left++;
            right--;
        }
        s = String.valueOf(newChar);
        return s;
    }
}