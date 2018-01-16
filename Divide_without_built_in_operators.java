import java.util.*;

/**
 * Reference: http://www.geeksforgeeks.org/add-two-numbers-without-using-arithmetic-operators/
 */

class Solution {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        System.out.println(add(x, y));
        System.out.println(divide(x, y));
    }

    public static int add(int x, int y) {
        while (x != 0) {
            int t = (x & y) << 1;   // get the carry
            y ^= x;                 // get the sum
            x = t;                  // next, we need to get the sum of y and carry
        }
        return y;
    }

    /**
     * The operator ‘>>’ uses the sign bit (left most bit) to fill the trailing
     * positions after shift. If the number is negative, then 1 is used as
     * a filler and if the number is positive, then 0 is used as a filler.
     *
     * the operator ‘>>>’ is unsigned right shift operator. It always fills 0
     * irrespective of the sign of the number.
     *
     * Reference: http://www.geeksforgeeks.org/bitwise-shift-operators-in-java/
     * https://stackoverflow.com/questions/21923791/how-to-get-absolute-value-of-a-number-in-java-using-bit-manipulation
     */
    public static int abs(int n) {
        return add(n ^ (n >> 31), n >>> 31);
    }

    public static int divide(int dividend, int divisor) {
        int sign = ((dividend < 0 && divisor > 0) ||
                    (dividend > 0 && divisor < 0)) ? -1 : 1;

        dividend = abs(dividend);
        divisor = abs(divisor);

        int num = 0;
        int sum = divisor;
        while (sum <= dividend) {
            sum = add(sum, divisor);
            num = add(num, 1);
        }
        return sign == -1 ? add(~num, 1) : num;
        // 负数的二进制表示是对应正数的补码，补码为反码加1
    }
}


// 011 & 101 = 001
// 001 << 1 = 010
// 011 ^ 101 = 110

// ~0000 0011 = 1111 1100
// 1111 1100 + 0000 0001 = 1111 1101