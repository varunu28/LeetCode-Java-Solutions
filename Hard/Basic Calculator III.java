class Solution {
    public int calculate(String s) {
        return helper(s, new int[]{0});
    }

    private int helper(String s, int[] idx) {
        Stack<Integer> stack = new Stack<>();
        int curr = 0;
        char operator = '+';
        while (idx[0] < s.length()) {
            char c = s.charAt(idx[0]++);
            if (Character.isDigit(c)) {
                curr = curr * 10 + Character.getNumericValue(c);
            }
            if (c == '(') {
                curr = helper(s, idx);
            }
            if ((!Character.isDigit(c) && c != ' ') || idx[0] == s.length()) {
                if (operator == '+') {
                    stack.push(curr);
                } else if (operator == '-') {
                    stack.push(-1 * curr);
                } else if (operator == '*') {
                    stack.push(stack.pop() * curr);
                } else if (operator == '/') {
                    stack.push(stack.pop() / curr);
                }
                if (c == ')') {
                    break;
                }
                operator = c;
                curr = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}
