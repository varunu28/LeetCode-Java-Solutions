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
        backtrack(robot, visited, 0, 0, 0);
    }
    
    private void backtrack(Robot robot, Set<String> visited, int x, int y, int dir) {
        String key = x + "|" + y;
        if (visited.contains(key)) {
            return;
        }
        
        visited.add(key);
        robot.clean();
        
        for (int k = 0; k < 4; k++) {
            int i = x;
            int j = y;
            if (robot.move()) {
                if (dir == 0) {
                    i = x - 1;
                }
                else if (dir == 1) {
                    j = y + 1;
                }
                else if (dir == 2) {
                    i = x + 1;
                }
                else {
                    j = y - 1;
                }
                
                backtrack(robot, visited, i, j, dir);
                robot.turnLeft();
                robot.turnLeft();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            
            robot.turnRight();
            dir += 1;
            dir %= 4;
        }
    }
}
