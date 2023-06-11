class Solution {
    public int longestSemiRepetitiveSubstring(String s) {
        int start = 0;
        int end = 0;
        int maxLength = 1;
        int consecutiveCount = 0;
        while (end < s.length() - 1) {
            if (s.charAt(end) == s.charAt(end + 1)) {
                consecutiveCount++;
            }
            end++;
            while (start < end && consecutiveCount > 1) {
                if (s.charAt(start) == s.charAt(start + 1)) {
                    consecutiveCount--;
                }
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
