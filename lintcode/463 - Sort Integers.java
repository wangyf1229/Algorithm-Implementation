public class Solution {
    /*
     * @param A: an integer array
     * @return:
     */
    public void sortIntegers(int[] A) {
        // write your code here
        if (A == null || A.length == 0) return;
        quickSort(A, 0, A.length - 1);
    }

    public void quickSort(int[] A, int start, int end) {
        if (start >= end) return;
        int left = start;
        int right = end;
        int cur = start;
        int pivot = A[end];
        while (cur <= right) {
            if (A[cur] < pivot) {
                swap(A, left, cur);
                left++;
                cur++;
            } else if (A[cur] == pivot) {
                cur++;
            } else if (A[cur] > pivot) {
                swap(A, right, cur);
                right--;
            }
        }
        quickSort(A, start, left - 1);
        quickSort(A, right + 1, end);
    }



    public void swap(int[] A, int n, int m) {
        int temp = A[n];
        A[n] = A[m];
        A[m] = temp;
    }
}