class Solution {
    
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] matrix = new int[A.length][B[0].length];
        if (A.length == 0 || B.length == 0 || A[0].length == 0 || B[0].length == 0) return matrix;
        for (int i = 0; i < A.length; i++) {
            for (int k = 0; k < A[0].length; k++) {
                if (A[i][k] != 0) {
                    for (int j = 0; j < B[0].length; j++) {
                        if (B[k][j] != 0) {
                            matrix[i][j] += A[i][k]*B[k][j];
                        }
                    }
                }
            }
        }
        return matrix;
    }

    public int[][] multiply(int[][] A, int[][] B) {
        //Sparse Matrix Representation
        int m = A.length;
        int n = B[0].length;
        int[][] res = new int[m][n];
        Map[] aList = new Map[m];
        for (int i = 0; i < m; i++) {
            Map<Integer, Integer> row = new HashMap<>(); //Pair(index, value)
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] != 0) {
                    row.put(j, A[i][j]);
                }
            }
            aList[i] = row;
        }
        
        for (int i = 0; i < m; i++) {
            Map<Integer, Integer> row = aList[i];
            for (Map.Entry<Integer, Integer> pair : row.entrySet()) {
                int colA = pair.getKey();
                int valA = pair.getValue();
                for (int j = 0; j < n; j++) {
                    if (B[colA][j] != 0){
                        res[i][j] += valA * B[colA][j];
                    }
                }
            }
        }
        return res;
    }
}