class Solution {
  public int[] asteroidCollision(int[] asteroids) {
    Stack<Integer> stack = new Stack<>();
    for (int asteroid : asteroids) {
      if (asteroid < 0) {
        while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroid)) {
          stack.pop();
        }
        if (!stack.isEmpty() && stack.peek() > 0) {
          if (stack.peek() == Math.abs(asteroid)) {
            stack.pop();
          }
        } else {
          stack.push(asteroid);
        }
      } else {
        stack.push(asteroid);
      }
    }
    int[] result = new int[stack.size()];
    for (int i = result.length - 1; i >= 0; i--) {
      result[i] = stack.pop();
    }
    return result;
  }
}
