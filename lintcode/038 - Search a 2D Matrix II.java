public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public static int searchMatrix(int[][] matrix, int target) {
        // write your code here
        int rows = matrix.length;
        if (rows == 0 ){
            return 0;
        }
        int cols = matrix[0].length;
        int occur =0;
        int i = rows-1;
        int j = 0;
        while(i>=0 && j <= cols-1 ){
            if (matrix[i][j]==target){
                occur ++;
                   i--;
                   j++;
            }else if (matrix[i][j]<target){
               j++;
            }else if (matrix[i][j]>target){
               i--;
            }

        }
        return occur;
    }
}
