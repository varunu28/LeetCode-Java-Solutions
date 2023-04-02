class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        int maxLength = 0;
        int idx = 0;
        while (idx < s.length()) {
            if (s.charAt(idx) != '0') {
                idx++;
                continue;
            }
            int zeroCount = 0;
            while (idx < s.length() && s.charAt(idx) == '0') {
                idx++;
                zeroCount++;
            }
            int oneCount = 0;
            while (idx < s.length() && s.charAt(idx) == '1') {
                idx++;
                oneCount++;
            }
            maxLength = Math.max(maxLength, 2 * Math.min(zeroCount, oneCount));
                
        }
        return maxLength;
    }
}
