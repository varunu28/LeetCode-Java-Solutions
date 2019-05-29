class Solution {
    public boolean backspaceCompare(String S, String T) {
        return getEncodedString(S).equals(getEncodedString(T));
    }
    
    private String getEncodedString(String s) {
        StringBuilder sb = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            if (c != '#') {
                sb.append(c);
            }
            else if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        
        return sb.toString();
    }
}
