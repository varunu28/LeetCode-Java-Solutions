class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int start = 0;
        int end = 0;
        int n = s.length();
        int oneCount = 0;
        int resultStart = -1;
        int resultEnd = -1;
        int resultLength = Integer.MAX_VALUE;
        while (end < n) {
            oneCount += s.charAt(end) == '1' ? 1 : 0;
            end++;
            while (start < end && (oneCount > k || s.charAt(start) == '0')) {
                oneCount -= s.charAt(start) == '1' ? 1 : 0;
                start++;
            }
            if (oneCount == k) {
                int currLength = end - start;
                if (currLength < resultLength) {
                    resultLength = currLength;
                    resultStart = start;
                    resultEnd = end;
                } else if (currLength == resultLength) {
                    if (isLexicographicallySmaller(s, start, resultStart, end - start)) {
                        resultStart = start;
                        resultEnd = end;
                    } 
                }
            }
        }
        return resultLength == Integer.MAX_VALUE ? "" : s.substring(resultStart, resultEnd);
    }

    private boolean isLexicographicallySmaller(String s, int startOne, int startTwo, int length) {
        for (int i = 0; i < length; i++) {
            char c1 = s.charAt(startOne + i);
            char c2 = s.charAt(startTwo + i);
            if (c1 < c2) {
                return true;
            }
            if (c1 > c2) {
                return false;
            }
        }
        return false;
    }
}
