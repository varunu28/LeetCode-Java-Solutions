class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[52];
        
        for (int i=0;i<s.length();i++) {
            int ind = ((int) s.charAt(i));
            if (ind >= 97) {
                ind -= 97;
            }
            else {
                ind = ind + 26 - 65;
            }
            count[ind]++;
        }
        
        int l = 0;
        for (int i=0;i<52;i++) {
            if (count[i]%2 == 0) {
                l += count[i];
            }
            else {
                l += count[i]-1;
            }
        }
        
        return s.length() > l ? l+1 : l; 
    }
}
