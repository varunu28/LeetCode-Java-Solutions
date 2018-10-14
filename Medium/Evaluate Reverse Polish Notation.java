class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        String signs = "+-*/";
        
        for (String token : tokens) {
            if (signs.indexOf(token) != -1) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                
                int temp = performOperation(num2, num1, token);
                
                stack.push(temp);
            }
            else {
                stack.push(Integer.parseInt(token));
            }
        }
        
        return stack.peek();
    }
    
    private int performOperation(int n1, int n2, String oper) {
        if (oper.equals("+")) {
            return n1 + n2;
        }
        else if (oper.equals("-")) {
            return n1 - n2;
        }
        else if (oper.equals("*")) {
            return n1 * n2;
        }
        else {
            return n1 / n2;
        }
    }
}
