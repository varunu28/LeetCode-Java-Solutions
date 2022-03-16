class Solution {
  public boolean validateStackSequences(int[] pushed, int[] popped) {
    Stack<Integer> stack = new Stack<>();
    int pushIdx = 0;
    int popIdx = 0;
    while (pushIdx < pushed.length) {
      while (!stack.isEmpty() && popped[popIdx] == stack.peek()) {
        stack.pop();
        popIdx++;
      }
      stack.push(pushed[pushIdx++]);
    }
    while (popIdx < popped.length) {
      if (stack.isEmpty() || stack.peek() != popped[popIdx]) {
        return false;
      }
      stack.pop();
      popIdx++;
    }
    return true;
  }
}
