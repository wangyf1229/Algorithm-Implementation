class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image[0].length == 0 || image[sr][sc] == newColor) return image;
        helper(image, sr, sc, newColor);
        return image;
    }

    public void helper(int[][] image, int sr, int sc, int newColor) {
        int init = image[sr][sc];
        image[sr][sc] = newColor;
        if (sr > 0 && image[sr - 1][sc] == init) {
            helper(image, sr - 1, sc, newColor);
        }
        if (sr < image.length - 1 && image[sr + 1][sc] == init) {
            helper(image, sr + 1, sc, newColor);
        }
        if (sc > 0 && image[sr][sc - 1] == init) {
            helper(image, sr, sc - 1, newColor);
        }
        if (sc < image[0].length - 1 && image[sr][sc + 1] == init) {
            helper(image, sr, sc + 1, newColor);
        }

    }
}