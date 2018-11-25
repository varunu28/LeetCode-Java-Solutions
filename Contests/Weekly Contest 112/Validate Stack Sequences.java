class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        
        int i = 0;
        int j = 0;
        
        while (i < pushed.length || j < popped.length) {
            if (stack.isEmpty() || stack.peek() != popped[j]) {
                if (i < pushed.length) {
                    stack.push(pushed[i++]);
                }
                else {
                    return false;
                }
            }
            else {
                if (j < popped.length && stack.peek() == popped[j]) {
                    stack.pop();
                    j++;
                }
                else {
                    return false;
                }
            }
        }
        
        return true;
    }
}
