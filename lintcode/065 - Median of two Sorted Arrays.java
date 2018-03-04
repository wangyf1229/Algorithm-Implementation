class Solution {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        if (A == null || B == null) return -1;
        int length = A.length + B.length;
        if (length % 2 == 1) {
            return findKth(A, 0, B, 0, length/2 + 1);
        } else {
            return (findKth(A, 0, B, 0, length/2) + findKth(A, 0, B, 0, length/2 + 1))/2.0;
        }
    }

    public int findKth(int[] A, int Astart, int[] B, int Bstart, int k) {
        if (Astart >= A.length) return B[Bstart + k - 1];
        if (Bstart >= B.length) return A[Astart + k - 1];
        if (k == 1) return Math.min(A[Astart], B[Bstart]);
        int Akey = Astart + k/2 - 1 < A.length ? A[Astart + k/2 - 1] : Integer.MAX_VALUE;
        int Bkey = Bstart + k/2 - 1 < B.length ? B[Bstart + k/2 - 1] : Integer.MAX_VALUE;
        if (Akey < Bkey) {
            return findKth(A, Astart + k/2, B, Bstart, k - k/2);
        } else {
            return findKth(A, Astart, B, Bstart + k/2, k - k/2);
        }
    }
}
