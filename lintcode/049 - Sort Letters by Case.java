public class Solution {
    /**
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        if (chars == null || chars.length == 0) return;
        int left = 0;
        int right = chars.length - 1;
        while (left <= right) {
            while (left <= right && Character.isLowerCase(chars[left])) {
                left++;
            }
            while (left <= right && Character.isUpperCase(chars[right])) {
                right--;
            }
            if (left <= right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
            }
        }
    }
}
