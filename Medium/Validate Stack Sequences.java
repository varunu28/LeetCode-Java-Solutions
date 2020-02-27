class Solution {
  public boolean validateStackSequences(int[] pushed, int[] popped) {
    int pushStart = 0;
    int popStart = 0;
    Stack<Integer> stack = new Stack<>();
    while (pushStart < pushed.length && popStart < popped.length) {
      if (stack.isEmpty()) {
        stack.push(pushed[pushStart++]);
      }
      else {
        if (stack.peek() == popped[popStart]) {
          stack.pop();
          popStart++;
        }
        else {
          stack.push(pushed[pushStart++]);
        }
      }
    }
    while (popStart < popped.length) {
      if (stack.peek() != popped[popStart]) {
        return false;
      }
      stack.pop();
      popStart++;
    }
    return true;
  }
}
