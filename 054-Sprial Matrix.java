class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i <= Math.min((m - 1)/2, (n - 1)/2); i++) {
            addOneRound(matrix, i, m - 1 - i, i, n - 1 -i, res);
        }
        return res;
    }

    public void addOneRound(int[][] matrix, int rowS, int rowE, int colS, int colE, List<Integer> res) {
        if (rowS > rowE || colS > colE) return;
        //for general case
        if (rowS != rowE && colS != colE) {
            for (int i = colS; i <= colE; i++) {
                res.add(matrix[rowS][i]);
            }
            for (int i = rowS + 1; i < rowE; i++) {
                res.add(matrix[i][colE]);
            }
            for (int i = colE; i >= colS; i--) {
                res.add(matrix[rowE][i]);
            }
            for (int i = rowE - 1; i >= rowS + 1; i--) {
                res.add(matrix[i][colS]);
            }
        }
        //for single row
        if (rowS == rowE) {
            for (int i = colS; i <= colE; i++) {
                res.add(matrix[rowS][i]);
            }
            return;
        }
        //for single column
        if (colS == colE) {
            for (int i = rowS; i <= rowE; i++) {
                res.add(matrix[i][colS]);
            }
        }
    }
}