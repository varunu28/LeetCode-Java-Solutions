class Solution {
    public boolean isPalindrome(String s) {
        
        if (s == " " || s.length() <= 1) return true;
        
        StringBuilder sb = new StringBuilder("");
       
        for(int i=0;i<s.length();i++) {
            if (((int) s.charAt(i) >= 97 && (int) s.charAt(i) <= 122) || Character.isDigit(s.charAt(i))) {
                sb.append(String.valueOf(s.charAt(i)));
            }
        }
        
        return sb.toString().toLowerCase().equals(sb.reverse().toString().toLowerCase());
    }
}
