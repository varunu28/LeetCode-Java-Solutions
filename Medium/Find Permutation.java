class Solution {
  public int[] findPermutation(String s) {
    int[] ans = new int[s.length() + 1];
    Stack<Integer> stack = new Stack<>();
    int idx = 0;
    for (int i = 1; i <= s.length(); i++) {
      if (s.charAt(i - 1) == 'I') {
        stack.push(i);
        while (!stack.isEmpty()) {
          ans[idx++] = stack.pop();
        }
      }
      else {
        stack.push(i);
      }
    }
    stack.push(s.length() + 1);
    while (!stack.isEmpty()) {
      ans[idx++] = stack.pop();
    }
    return ans;
  } 
}
