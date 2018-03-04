public class Solution {
    /**
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        int start, end, mid;
        int[] bound = new int[2];
        bound[0] =-1;
        bound[1] =-1;
        if(A.length ==0){
            return bound;
        }
        //search for left bound
        start = 0;
        end = A.length-1;
        while (start + 1 < end){
            mid = start + (end - start)/2;
            if (A[mid]==target){
                end = mid;
            }else if (A[mid]< target){
                start = mid;
            }else if (A[mid]>target){
                end = mid;
            }
        }

         if (A[end] == target){
            bound[0]=end;
        }

        if (A[start] == target){
            bound[0]=start;
        }

        //search for right bound
        start = 0;
        end = A.length-1;
        while (start + 1 < end){
            mid = start + (end - start)/2;
            if (A[mid]==target){
                start = mid;
            }else if (A[mid]< target){
                start = mid;
            }else if (A[mid]>target){
                end = mid;
            }
        }

        if (A[start] == target){
            bound[1]=start;
        }

        if (A[end] == target){
            bound[1]=end;
        }

        return bound;
    }
}
