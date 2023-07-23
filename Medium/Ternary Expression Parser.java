class Solution {
    public String parseTernary(String expression) {
        Stack<Character> stack = new Stack<>();
        int idx = expression.length() - 1;
        while (idx >= 0) {
            char c = expression.charAt(idx);
            if (c >= '0' && c <= '9' || c == 'T' || c == 'F') {
                stack.push(c);
            } else if (c == '?') {
                char trueValue = stack.pop();
                char falseValue = stack.pop();
                stack.push(expression.charAt(idx - 1) == 'T' ? trueValue : falseValue);
                idx--;
            }
            idx--;
        }
        return String.valueOf(stack.pop());
    }
}
