class Solution {
    public boolean isValid(String S) {
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c == 'a' || c == 'b') {
                stack.push(c);            
            }
            else {
                if (stack.isEmpty() || stack.pop() != 'b') {
                    return false;
                }
                
                if (stack.isEmpty() || stack.pop() != 'a') {
                    return false;
                }
            }
        }
        
        return stack.size() == 0;
    }
}
