class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
        // find the last number which square of it <= x
        long start = 0;
        long end = (long)x;
        if (x < 0){
            return -1;
        }
        while (start + 1 < end){
            long mid = start + (end - start)/2;
            if (mid*mid <= x){
                start = mid;
            }else {
                end = mid;
            }

        }
        if (end*end <= x){
            return (int)end;
        }

        if (start*start <= x){
            return (int)start;
        }

        return -1;
    }
}