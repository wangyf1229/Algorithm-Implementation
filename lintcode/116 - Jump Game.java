public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        // int n = A.length;
        // if (n == 0) return true;
        // boolean[] result = new boolean[n];
        // result[0] = true;
        // for (int i = 1; i < n; i++) {
        //     for (int j = 0; j < i; j++) {
        //         if (result[j] == true && A[j] + j >= i) {
        //             result[i]= true;
        //             break;
        //         }
        //     }
        // }
        // return result[n-1];

        int n = A.length;
        if (n == 0) return true;
        int reachable = 0;
        for (int i = 0; i < n; i++){
            if (i <= reachable) {
                reachable = Math.max(reachable, A[i] + i);
            } else {
                return false;
            }
        }
        return true;
    }
}
