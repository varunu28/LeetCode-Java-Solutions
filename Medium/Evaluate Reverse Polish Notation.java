class Solution {
    
    private static final Set<String> OPERATIONS = Set.of("*", "+", "/", "-");
    
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (OPERATIONS.contains(token)) {
                stack.push(performOperation(stack.pop(), stack.pop(), token));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
    
    private static int performOperation(int num2, int num1, String operation) throws UnsupportedOperationException {
        return switch(operation) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            default -> throw new UnsupportedOperationException("Operation not supported");
        };
    }
}
