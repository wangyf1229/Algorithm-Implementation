class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) return Integer.MAX_VALUE;
        boolean isNegative = (dividend < 0)^(divisor < 0);
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);
        if (ldividend < ldivisor) return 0;
        long ans = divideHelper(ldividend, ldivisor);
        if (ans > Integer.MAX_VALUE && isNegative) return Integer.MIN_VALUE;
        if (ans > Integer.MAX_VALUE && (!isNegative)) return Integer.MAX_VALUE;
        if (isNegative) return (int) ((-1)*(ans));
        return (int) ans;

    }

    public long divideHelper(long ldividend, long ldivisor) {
        if (ldividend < ldivisor) return 0;
        long sum = ldivisor;
        long multiplier = 1;
        while ((sum + sum) < ldividend) {
            sum += sum;
            multiplier += multiplier;
        }
        return multiplier + divideHelper(ldividend - sum, ldivisor);
    }
}