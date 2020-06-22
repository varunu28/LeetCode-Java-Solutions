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
  int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
  public void cleanRoom(Robot robot) {
    Set<String> set = new HashSet<>();
    int currX = 0;
    int currY = 0;
    helper(robot, currX, currY, 0, set);
  }
  
  private void helper(Robot robot, int x, int y, int dir, Set<String> set) {
    if (set.contains(x + "|" + y)) {
      return;
    }
    set.add(x + "|" + y);
    robot.clean();
    for (int i = 0; i < 4; i++) {
      if (robot.move()) {
        int newX = x + dirs[dir][0];
        int newY = y + dirs[dir][1];
        helper(robot, newX, newY, dir, set);
        robot.turnLeft();
        robot.turnLeft();
        robot.move();
        robot.turnRight();
        robot.turnRight();
      }
      robot.turnRight();
      dir = (dir + 1) % 4;
    }
  }
}
