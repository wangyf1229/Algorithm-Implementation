public class Solution {
    /**
     * @param matrix a boolean 2D matrix
     * @return an integer
     */
    public int maximalRectangle(boolean[][] matrix) {
        // Write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int[] histogram = new int [matrix[0].length];
        int maxArea = 0;
        for (int i = 0; i < matrix.length; i++) {
            Stack<Integer> stack = new Stack<Integer>();
            for (int j = 0; j <= matrix[0].length; j++) {
                if (j != matrix[0].length) {
                    histogram[j] = matrix[i][j] ? histogram[j] + 1:0;
                }
                int curt = j == matrix[0].length ? -1 : histogram[j];
                while (!stack.empty() && histogram[stack.peek()] >= curt) {
                    int top = stack.pop();
                    int firstIndex = stack.empty() ? -1: stack.peek();
                    int area = (j - firstIndex - 1) * (histogram[top]);
                    maxArea = Math.max(area, maxArea);
                }
                stack.push(j);
            }
        }
        return maxArea;
    }
}