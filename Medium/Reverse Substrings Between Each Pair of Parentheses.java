class Solution {
    public String reverseParentheses(String s) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                start = i;
            }
            if (s.charAt(i) == ')') {
                end = i;
                StringBuilder sb = new StringBuilder(s.substring(start + 1, end)).reverse();
                return reverseParentheses(s.substring(0, start) + sb.toString() + s.substring(end + 1));
            }
        }
        return s;
    }
}
