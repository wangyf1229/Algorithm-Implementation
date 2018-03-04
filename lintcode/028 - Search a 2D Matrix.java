public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if(row==0){
            return false;
        }
        int col = matrix[0].length;
        int[] position = new int[2];
        position[0]=-1;
        position[1]=-1;
        int start = 0;
        int end = row-1;
        int mid;
        while (start+1<end){
            mid = start + (end-start)/2;
            if (matrix[mid][0]==target){
                return true;
            }else if (matrix[mid][0]<target){
                start = mid;
            }else if (matrix[mid][0]>target){
                end = mid;
            }
        }

        if (matrix[start][0]==target){
            return true;
        }

        if (matrix[end][0]==target){
            return true;
        }

        int i;
        if (matrix[end][0]<target){
            i = end;
        }else{
            i = start;
        }

        start = 0;
        end = col-1;

        while(start+1<end){
            mid = start + (end-start)/2;
            if (matrix[i][mid]==target){
               return true;
            }else if (matrix[i][mid]<target){
                start = mid;
            }else if (matrix[i][mid]>target){
                end = mid;
            }
        }

         if (matrix[i][start]==target){
            position[0]=i;
            position[1]=start;
        }

        if (matrix[i][end]==target){
            position[0]=i;
            position[1]=end;
        }

        if (position[0]==-1 && position[1] == -1){
            return false;
        }else {
            return true;
        }
    }
}
