class Solution {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        int sizeA = A.length;
        int sizeB = B.length;
        if (sizeA == 0) return B;
        if (sizeB == 0) return A;
        int[] result = new int[sizeA + sizeB];
        int j = 0, k = 0, i = 0;
        while(j < sizeA && k < sizeB) {
            if (A[j] < B[k]) {
                result[i++] = A[j++];
            } else {
                result[i++] = B[k++];
            }
        }

        while (j < sizeA) {
            result[i++] = A[j++];
        }

        while (k < sizeB) {
            result[i++] = B[k++];
        }

        return result;
    }
}