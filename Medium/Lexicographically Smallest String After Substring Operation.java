class Solution {
    public String smallestString(String s) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while (idx < s.length() && s.charAt(idx) == 'a') {
            sb.append(s.charAt(idx++));
        }
        if (idx == s.length()) {
            return s.substring(0, s.length() - 1) + 'z';
        }
        while (idx < s.length() && s.charAt(idx) != 'a') {
            sb.append(getPreviousChar(s.charAt(idx++)));
        }
        return sb.append(s.substring(idx)).toString();
    }
    
    private char getPreviousChar(char c) {
        return (char) (c - 1);
    }
}
