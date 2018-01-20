class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int rows = matrix.length;
        int i = rows - 1;
        int j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > target) {
                i--;
            } else if (matrix[i][j] < target) {
                j++;
            } else if (matrix[i][j] == target) {
                return true;
            }
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        //find row
        int start = 0;
        int end = matrix.length - 1;
        while (start + 1 < end) {
            int mid = (start + end)/2;
            if (matrix[mid][0] == target) return true;
            if (matrix[mid][0] > target) end = mid;
            if (matrix[mid][0] < target) start = mid;
        }
        int row = start;
        if (matrix[end][0] <= target) row = end;

        //find column
        start = 0;
        end = matrix[row].length - 1;
        while (start + 1 < end) {
            int mid = (start + end)/2;
            if (matrix[row][mid] == target) return true;
            if (matrix[row][mid] > target) end = mid;
            if (matrix[row][mid] < target) start = mid;
        }
        if (matrix[row][start] == target) return true;
        if (matrix[row][end] == target) return true;

        return false;


    }
}