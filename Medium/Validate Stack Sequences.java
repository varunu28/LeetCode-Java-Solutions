class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int pushedIdx = 0;
        int poppedIdx = 0;
        while (pushedIdx < pushed.length && poppedIdx < popped.length) {
            if (!stack.isEmpty() && stack.peek() == popped[poppedIdx]) {
                stack.pop();
                poppedIdx++;
            } else {
                stack.push(pushed[pushedIdx++]);
            }
        }
        while (poppedIdx < popped.length && !stack.isEmpty() && stack.peek() == popped[poppedIdx]) {
            stack.pop();
            poppedIdx++;
        }
        return pushedIdx == pushed.length && poppedIdx == popped.length;
    }
}
