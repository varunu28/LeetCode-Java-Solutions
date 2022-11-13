class Solution {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        int idx = s.length() - 1;
        while (idx >= 0) {
            if (s.charAt(idx) == ' ') {
                idx--;
                continue;
            }
            StringBuilder sb = new StringBuilder();
            while (idx >= 0 && Character.isLetterOrDigit(s.charAt(idx))) {
                sb.append(s.charAt(idx--));
            }
            result.append(sb.reverse().toString()).append(" ");
        }
        return result.toString().trim();
    }
}
