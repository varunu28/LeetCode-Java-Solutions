public class Solution {
    public int titleToNumber(String s) {
        int val = 0;
        int n = s.length();
        int j = 1;
        for (int i=0;i<n-1;i++) {
            val += Math.pow(26,n-i-1)*((int)(s.charAt(i)) - 64);
            j++;
        }
        char c = s.charAt(s.length()-1);
        val += (int)c - 64;
        
        return val;
    }
}