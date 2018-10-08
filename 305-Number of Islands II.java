//Union Find
class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        int[] parents = new int[m*n];
        int[][] grid = new int[m][n];
        int number = 0;
        List<Integer> res = new ArrayList<>();
        
        for(int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        
        for (int i = 0; i < positions.length; i++) {
            int r = positions[i][0];
            int c = positions[i][1];
            number++;
            grid[r][c] = 1;
            for (int[] dir: directions) {
                int rr = r + dir[0];
                int cc = c + dir[1];
                if (rr >= 0 && rr < m && cc >= 0 && cc < n && grid[rr][cc] == 1) {
                    if (find(r*n + c, parents) != find(rr*n + cc, parents)) {
                        union(r*n + c, rr*n + cc, parents);
                        number--;
                    }
                }
            }
            res.add(number);
        }
        return res;
    }
    
    public int convert2DTo1D(int x, int y, int n) {
        return x*n + y;
    }
    
    public int find(int x, int[] parents) {
        if (parents[x] != x) {
            parents[x] = find(parents[x], parents);
        }
        return parents[x];
    }
    
    public void union(int x, int y, int[] parents) {
        //the root of X becomes the root of Y
        parents[find(y, parents)] = find(x, parents);
    } 
}