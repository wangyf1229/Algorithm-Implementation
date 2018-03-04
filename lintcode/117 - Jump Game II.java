public class Solution {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        //Dynamic Programming
        // int n = A.length;
        // if ( n == 0) return 0;
        // int[] result = new int[n];
        // result[0] = 0;
        // for (int i = 1; i < n; i++) {
        //     int min = Integer.MAX_VALUE;
        //     for ( int j = 0; j < i; j++) {
        //         if (A[j] + j >= i) {
        //             min = Math.min(min,result[j]+1);
        //         }
        //     }
        //     result[i] = min;
        // }
        // return result[n-1];

       //Greedy
       int n = A.length;
       if (n == 0) return 0;
       int jump = 0;
       int start = 0;
       int end = 0;
       int farthest = 0;
       while ( end + 1 < n) {
           jump ++;
           for ( int i = start; i <= end; i ++) {
               if (A[i] + i > farthest ) {
                   farthest = A[i] + i;
               }
           }
           start = end + 1;
           end = farthest;
       }
       return jump;
    }
}
