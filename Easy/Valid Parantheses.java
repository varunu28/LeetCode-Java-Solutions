class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        String open = "{([";
        String close = "})]";
        for (int i=0;i<s.length();i++) {
            if (open.indexOf(s.charAt(i)) != -1) {
                stack.push(s.charAt(i));
            }
            else {
                if (!stack.empty()) {
                    char c = stack.pop();
                    if (open.indexOf(c) != close.indexOf(s.charAt(i))) {
                        return false;
                    }
                }
                else {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
