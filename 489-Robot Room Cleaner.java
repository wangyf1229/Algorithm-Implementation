/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */
class Solution {
    public void cleanRoom(Robot robot) {
        Set<String> visited = new HashSet<>();
        dfsHelper(robot, visited, 0, 0, 0);
    }
    
    public void dfsHelper(Robot robot, Set<String> visited, int row, int col, int degree) {
        //注意点：1. row和col为相对位置，所以要记录方位，不然面向的方位不同，row和col值不同 2.每回探索完一个方向要转回最开始的方向
        String coordinate = row + "->" + col;
        if (visited.contains(coordinate)) return;
        visited.add(coordinate);
        robot.clean();
        int[][] dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for (int i = 0; i < 4; i++) {
            int deg = (degree + i*90) % 360;
            int d = deg/90;
            if (robot.move()) {
                dfsHelper(robot, visited, row + dir[d][0], col + dir[d][1], deg);
                //trace back
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            robot.turnRight();
        }
    }
    
}