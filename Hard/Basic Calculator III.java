class Solution {
    public int calculate(String s) {
        if (s.length() == 0) {
            return 0;
        }
        
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        int num = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            
            if (Character.isDigit(c)) {
                num = c - '0';
                while (i < s.length() - 1 && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
                
                nums.push(num);
                num = 0;
            }
            else if (c == '(') {
                ops.push(c);
            }
            else if (c == ')') {
                while (ops.peek() != '(') {
                    nums.push(performOperation(ops.pop(), nums.pop(), nums.pop()));
                }
                ops.pop();
            }
            else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!ops.isEmpty() && precedence(c, ops.peek())) {
                    nums.push(performOperation(ops.pop(), nums.pop(), nums.pop()));
                }
                
                ops.push(c);
            }
        }
        
        while (!ops.isEmpty()) {
            nums.push(performOperation(ops.pop(), nums.pop(), nums.pop()));
        }
        
        return nums.pop();
    }
    
    private int performOperation(char op, int b, int a) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
        }
        
        return 0;
    }
    
    private boolean precedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') {
            return false;
        }
        
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
            return false;
        }
        
        return true;
    }
}
