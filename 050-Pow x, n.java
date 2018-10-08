class Solution {
    public double myPow(double x, int n) {
        //special cases: n can be 0, negative, Integer.MIN_VALUE.
        //So I need to convert n to long in case n is Integer.MIN_VALUE
        long n_long = (long) n;
        return helper(x, n_long);
    }
    
    public double helper(double x, long n) {
        if (n < 0) {
            n = -n;
            x = 1/x;
        }
        if (n == 0) return 1;
        if(n == 1) return x;
        if (n % 2 == 0) {
            double pow = helper(x, n/2);
            return pow*pow;
        } else {
            double pow = helper(x, n/2);
            return pow*x*pow;
        }
    }
}