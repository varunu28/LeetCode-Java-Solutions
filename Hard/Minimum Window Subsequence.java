class Solution {
    public String minWindow(String s1, String s2) {
        int right = 0;
        int minWindowLength = Integer.MAX_VALUE;
        String result = "";
        while (right < s1.length()) {
            int s2Idx = 0;
            while (right < s1.length()) {
                if (s1.charAt(right) == s2.charAt(s2Idx)) {
                    s2Idx++;
                }
                if (s2Idx == s2.length()) {
                    break;
                }
                right++;
            }
            if (right == s1.length()) {
                break;
            }
            int s1EndIdx = right;
            int s2EndIdx = s2.length() - 1;
            while (s1EndIdx >= 0) {
                if (s1.charAt(s1EndIdx) == s2.charAt(s2EndIdx)) {
                    s2EndIdx--;
                }
                if (s2EndIdx < 0) {
                    break;
                }
                s1EndIdx--;
            }
            if (right - s1EndIdx + 1 < minWindowLength) {
                minWindowLength = right - s1EndIdx + 1;
                result = s1.substring(s1EndIdx, right + 1);
            }
            right = s1EndIdx + 1;
        }
        return result;
    }
}
