/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {

    public char[] temp = new char[4];
    public int bufPtr = 0;
    public int bufCnt = 0;
    
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int ptr = 0;
        while(ptr < n) {
            if (bufPtr == 0) {
                bufCnt = read4(temp);
            }
            if (bufCnt == 0) break;
            while(ptr < n && bufPtr < bufCnt) {
                buf[ptr++] = temp[bufPtr++];
            }
            if (bufPtr >= bufCnt) bufPtr = 0;
        }
        return ptr; 
    }
}