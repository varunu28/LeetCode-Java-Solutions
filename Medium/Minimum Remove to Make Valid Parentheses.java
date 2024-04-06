class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] letters = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    letters[i] = '-';
                } else {
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) {
            letters[stack.pop()] = '-';
        }
        StringBuilder sb = new StringBuilder();
        for (char c : letters) {
            if (c != '-') {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
