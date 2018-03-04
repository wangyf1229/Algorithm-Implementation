public class Solution {
    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers2(int[] A) {
        quickSort(A);
        //mergeSort(A);
    }

    public void mergeSort(int[] A) {
        if (A == null || A.length == 0) return;
        mergeSortHelper(0, A.length - 1, A);
    }

    public void mergeSortHelper(int start, int end, int[] A) {
        if (start >= end) return;
        int mid = (start + end)/2;
        mergeSortHelper(start, mid, A);
        mergeSortHelper(mid + 1, end, A);
        merge(start, mid, end, A);
    }

    public void merge(int start, int mid, int end, int[] A) {
        int k = start;
        int i = start;
        int j = mid + 1;
        int[] B = new int[A.length];
        while (i <= mid && j <= end) {
            if (A[i] < A[j]) {
                B[k++] = A[i++];
            } else {
                B[k++] = A[j++];
            }
        }
        //When exit i > mid || j > end;
        if (i <= mid) {
            for (int m = i; m <= mid; m++) {
                B[k++] = A[m];
            }
        } else {
            for (int m = j; m <= end; m++) {
                B[k++] = A[m];
            }
        }

        for (int m = start; m <= end; m++) {
            A[m] = B[m];
        }
    }

    public void quickSort(int[] A) {
        if (A == null || A.length == 0) return;
        //quickSortHelper2(0, A.length - 1, A);
        quickSortHelper3(0, A.length - 1, A);
    }

    public void quickSortHelper3(int start, int end, int[] A) {
        if (start >= end) return;
        int pivot = A[end];
        int left = start;
        int right = end;
        int cur = left;
        while (cur <= right) {
            if (A[cur] < pivot) {
                swapNum(cur, left, A);
                left++;
                cur++;
            } else if (A[cur] == pivot) {
                cur++;
            } else if (A[cur] > pivot) {
                swapNum(cur, right, A);
                right--;
            }
        }
        quickSortHelper3(start, left - 1, A);
        quickSortHelper3(right + 1, end, A);
    }

    public void quickSortHelper2(int start, int end, int[] A) {
        if (start >= end) return;
        int pivot = A[end];
        int left = start;
        int right = end;
        while (left <= right) {
            while (left <= right && A[left] < pivot) {
                left++;
            }
            while (left <= right && A[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swapNum(left, right, A);
                left++;
                right--;
            }
        }
        //right + 1 is the index of the first number which is >= pivot;
        quickSortHelper2(start, right, A);
        quickSortHelper2(right + 1, end, A);
    }

    public void swapNum(int i, int j, int[] A) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}