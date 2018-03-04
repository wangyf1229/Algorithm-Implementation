public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     */

    public void heapify(int[] A) {
        if (A == null || A.length == 0) return;
        for (int i = (A.length - 1); i >= 0; i--) {
            siftdown(A, i);
        }
    }

    public void siftdown(int[] A, int i) {
        int small = 0;
        if (2*i + 1 >= A.length) return;

        if (2*i + 2 >= A.length) {
            small = 2*i + 1;
        }else if (A[2*i+1] < A[2*i+2]) {
            small = 2*i + 1;
        }else{
            small = 2*i + 2;
        }

        if ( A[small] < A[i] ) {
                int k = A[i];
                A[i] = A[small];
                A[small] = k;
                siftdown(A, small);
        }

    }
}