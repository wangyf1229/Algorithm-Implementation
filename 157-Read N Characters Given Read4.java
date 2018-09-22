/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int count = 0;
        char[] temp = new char[4];
        boolean finished = false;
        while(!finished) {
            int length = read4(temp);
            int index = n > length ? length : n;
            for(int i = count; i < (count + index); i++) {
                buf[i] = temp[i - count];
            }
            count += index;
            n -= index;
            if (length < 4 || n <= 0) finished = true;
        }
        return count;
    }
}