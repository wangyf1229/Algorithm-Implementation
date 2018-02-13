class Solution {
    public static Set<Character> set = new HashSet<>(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9'));
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<Character> row = new HashSet<>();
            Set<Character> column = new HashSet<>();
            Set<Character> grid = new HashSet<>();
            for (int j = 0; j < board[0].length; j++) {
                if (!(board[i][j] == '.') && (!(set.contains(board[i][j])) || row.contains(board[i][j]))) {
                    return false;
                } else {
                    row.add(board[i][j]);
                }

                if (!(board[j][i] == '.') && (!(set.contains(board[j][i])) || column.contains(board[j][i]))) {
                    return false;
                } else {
                    column.add(board[j][i]);
                }

                int rowIndex = 3 * (i / 3);
                int colIndex = 3 * (i % 3);
                char temp = board[rowIndex + j/3][colIndex + j%3];
                if (! (temp == '.') && (!(set.contains(temp)) || grid.contains(temp))) {
                    return false;
                } else {
                    grid.add(temp);
                }
            }
        }
        return true;
    }

}