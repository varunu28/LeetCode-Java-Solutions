class Solution {
    public boolean validPalindrome(String s) {
        if (isPalindrome(s)) return true;        
    
        int i=0;
        int j = s.length()-1;
         
        while (i<j && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }
        
        if (i>=j) {
            return true;
        }
        
        if (isPalindrome(s.substring(i+1,j+1)) || isPalindrome(s.substring(i,j))) {
            return true;
        }
        
        return false;
    }
    
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder("");
        sb.append(s);
        return s.equals(sb.reverse().toString());
    }
}
