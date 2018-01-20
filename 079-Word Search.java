class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) return false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (existHelper(i, j, board, word, 0)) return true;
            }
        }
        return false;
    }

    public boolean existHelper(int x, int y, char[][] board, String word, int index) {
        if (x < 0 || x >= board.length) return false;
        if (y < 0 || y >= board[0].length) return false;
        if (word.charAt(index) != board[x][y]) return false;
        if (index == (word.length() - 1)) return true;
        char temp = board[x][y];
        board[x][y] = '#';
        boolean res = existHelper(x, y-1, board, word, index + 1) || existHelper(x, y+1, board, word, index + 1)
                      || existHelper(x+1, y, board, word, index + 1) || existHelper(x-1, y, board, word, index + 1);
        board[x][y] = temp;
        return res;
    }
}