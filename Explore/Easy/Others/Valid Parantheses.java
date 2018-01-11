class Solution {
    public boolean isValid(String s) {
        String start = "({[";
        String end = ")}]";
        
        Stack<Character> stack = new Stack<>();
        
        for (int i=0;i<s.length();i++) {
            if (start.indexOf(s.charAt(i)) != -1) {
                stack.push(s.charAt(i));
            }
            else if (end.indexOf(s.charAt(i)) != -1) {
                if (stack.empty()) return false;
                char c = stack.pop();
                if (start.indexOf(c) != end.indexOf(s.charAt(i))) {
                    return false;
                } 
            }
        }
        
        return stack.empty();
    }
}
