public class Solution {
    /**
     * @param str: an array of char
     * @param offset: an integer
     * @return: nothing
     */
    private void reverse(char[]str, int start, int end){
        for (int i = start, j = end; i < j; i++, j--){
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
    }

    public void rotateString(char[] str, int offset) {
        // write your code here
        if (str.length != 0){
        offset %= str.length;
        reverse(str,0,str.length-1);
        reverse(str,0,offset-1);
        reverse(str,offset,str.length-1);
        }
    }
}