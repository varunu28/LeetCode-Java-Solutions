class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();
        for (char c : expression.toCharArray()) {
            if (c == ')') {
                List<Character> values = new ArrayList<>();
                while (stack.peek() != '(') {
                    values.add(stack.pop());
                }
                stack.pop();
                char operation = stack.pop();
                char result = evaluate(operation, values);
                stack.push(result);
            } else if (c != ',') {
                stack.push(c);
            }
        }
        return stack.peek() == 't';
    }

    private static char evaluate(char operation, List<Character> values) {
        if (operation == '!') {
            return values.get(0) == 't' ? 'f' : 't';
        }
        if (operation == '&') {
            for (char value : values) {
                if (value == 'f') {
                    return 'f';
                }
            }
            return 't';
        }
        if (operation == '|') {
            for (char value : values) {
                if (value == 't') {
                    return 't';
                }
            }
            return 'f';
        }
        return 'f';
    }
}
