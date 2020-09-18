class Solution {
  public int minCost(String s, int[] cost) {
    Stack<Integer> stack = new Stack<>();
    int deletionCost = 0;
    for (int i = 0; i < s.length(); i++) {
      int insertionIndex = i;
      if (!stack.isEmpty() && s.charAt(i) == s.charAt(stack.peek())) {
        int poppedIdx = stack.pop();
        if (cost[i] > cost[poppedIdx]) {
          deletionCost += cost[poppedIdx];
        }
        else {
          deletionCost += cost[i];
          insertionIndex = poppedIdx;
        }
      }
      stack.push(insertionIndex);
    }
    return deletionCost;
  }
}
