class Solution {
  public int[] asteroidCollision(int[] asteroids) {
    Stack<Integer> stack = new Stack<>();
    for (int asteroid : asteroids) {
      boolean toAdd = true;
      if (asteroid < 0) {
        while (!stack.isEmpty() && stack.peek() > 0) {
          if (Math.abs(asteroid) > stack.peek()) {
            stack.pop();
            continue;
          }
          else if (Math.abs(asteroid) == stack.peek()) {
            stack.pop();
          }
          toAdd = false;
          break;
        }
      }
      if (toAdd) {
        stack.push(asteroid);
      }
    }
    int[] ans = new int[stack.size()];
    for (int i = ans.length - 1; i >= 0; i--) {
      ans[i] = stack.pop();
    }
    return ans;
  }
}
