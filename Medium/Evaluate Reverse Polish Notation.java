class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> operations = new HashSet<>(Arrays.asList("-", "+", "*", "/"));
        for (String token : tokens) {
            if (operations.contains(token)) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(performOperation(num2, num1, token));
            }
            else {
                stack.push(Integer.parseInt(token));
            }
        }
        
        return stack.pop();
    }
    
    private int performOperation(int a, int b, String operation) {
        switch(operation) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            default:
                return a / b;
        }
    }
}
