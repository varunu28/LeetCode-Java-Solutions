class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        int idx = S.length() - 1;
        int count = 0;
        
        while (idx >= 0) {
            if (S.charAt(idx) != '-') {
                if (Character.isLetter(S.charAt(idx))) {
                    sb.append(Character.toUpperCase(S.charAt(idx)));
                }
                else {
                    sb.append(S.charAt(idx));
                }
                count++;
            }
            
            idx--;
            
            if (count == K && idx >= 0) {
                sb.append('-');
                count = 0;
            }
        }
        
        if (sb.length() == 0) {
            return "";
        }
        
        String ans = sb.reverse().toString();
        return ans.charAt(0) == '-' ? ans.substring(1) : ans;
    }
}
