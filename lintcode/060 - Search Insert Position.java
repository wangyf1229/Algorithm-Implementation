public class Solution {
    /**
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(int[] A, int target) {
        int start =0;
        int end = A.length-1;
        int mid;
        if (A.length ==0){
            return 0;
        }
        if (target < A[0]){
            return 0;
        }
        // find the first number larger than target
        while (start+1<end){
            mid = start + (end - start)/2;
            if(A[mid]==target){
                return mid;
            }else if (A[mid]<target){
                start = mid;
            }else if (A[mid]>target){
                end = mid;
        }
    }

   if (A[end] == target){
        return end;
    }

    if (A[end]<target){
        // return A.length;
        return end+1;
    }

    if (A[start]==target){
        return start;
    }

    return start+1;
    //return end;
    }
}
