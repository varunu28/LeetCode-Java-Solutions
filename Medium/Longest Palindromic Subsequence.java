class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] temp = new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++) {
            temp[i][i] = 1;
        }
        
        int j;
        
        for (int cl=2;cl <= s.length();cl++) {
            for (int i=0;i<s.length()-cl+1;i++) {
                j = i + cl - 1;
                if (s.charAt(i) == s.charAt(j) && cl == 2)
                   temp[i][j] = 2;
                else if (s.charAt(i) == s.charAt(j))
                   temp[i][j] = temp[i+1][j-1] + 2;
                else
                   temp[i][j] = Math.max(temp[i][j-1], temp[i+1][j]);
            }
        }
        
        return temp[0][s.length()-1];
    }
    
//     public int longestPalindromeSubseq(String s, int l, int len) {
//         if (len == 1) return 1;
//         if (len == 0) return 0;
        
//         if (s.charAt(l) == s.charAt(l+len-1)) return 2 + longestPalindromeSubseq(s, l+1, len-2);
//         else {
//             return Math.max(longestPalindromeSubseq(s,l+1,len-1), longestPalindromeSubseq(s,l, len-1));
//         }
//     }
}
