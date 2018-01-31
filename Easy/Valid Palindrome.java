class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder("");
        
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(c);
            }
        }
        
        String S = sb.toString().toLowerCase();
        
        return isPalindromeImpl(S);
    }
    
    public boolean isPalindromeImpl(String s) {
        if (s.length() <= 1) return true;
        
        return s.charAt(0) == s.charAt(s.length()-1) && isPalindromeImpl(s.substring(1, s.length()-1));
    }
}
