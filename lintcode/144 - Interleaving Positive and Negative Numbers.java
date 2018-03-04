class Solution {
    /**
     * @param A: An integer array.
     * @return: void
     */
    public void rerange(int[] A) {
        //Solution 1: Non In-place Solution
        if (A == null || A.length <= 2) return;
        int[] pos = new int[A.length];
        int[] neg = new int[A.length];
        int posNum = 0, negNum = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                pos[posNum++] = A[i];
            } else {
                neg[negNum++] = A[i];
            }
        }

        int[] result = new int[A.length];
        if (posNum > negNum) {
            result = merge(pos, neg, posNum, negNum);
        } else {
            result = merge(neg, pos, negNum, posNum);
        }

        for (int j = 0; j < A.length; j++) {
            A[j] = result[j];
        }
    }

    public int[] merge(int[] large, int[] small, int largeNum, int smallNum) {
        int[] result = new int[largeNum + smallNum];
        int j = 0, k = 0;
        for (int i = 0; i < result.length; i++) {
            if (i % 2 == 0) {
                result[i] = large[j++];
            } else {
                result[i] = small[k++];
            }
        }
        return result;
    }


        //Solution 2: In-place Solution
        //divide the array into positive part and negative part
        // if (A == null || A.length <= 2)  return;
        // int left = 0;
        // int right = A.length - 1;
        // while (left <= right) {
        //     while (left <= right && (A[left] > 0)) {
        //         left++;
        //     }
        //     while (left <= right && (A[right] < 0)) {
        //         right--;
        //     }
        //     if (left <= right) {
        //         int temp = A[left];
        //         A[left] = A[right];
        //         A[right] = temp;
        //     }
        // }

        //rearrange the array in place
        //right + 1 is the first negative number
        // int neg = right + 1;
        // int i;
        //neg == the number of positive numbers, if posNum is smaller than negNum, the first number should be negative.
        // if (neg <= A.length/2) {
        //     i = 0;
        // } else {
        //     i = 1;
        // }
        // while (i < neg && neg <= A.length - 1) {
        //     int temp = A[i];
        //     A[i] = A[neg];
        //     A[neg] = temp;
        //     i += 2;
        //     neg ++;
        // }
   //}
}