class Solution {
    public int minimumLength(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end && s.charAt(start) == s.charAt(end)) {
            char startChar = s.charAt(start);
            char endChar = s.charAt(end);
            while (start <= end && s.charAt(start) == startChar) {
                start++;
            }
            while (end > start && s.charAt(end) == endChar) {
                end--;
            }
        }
        return end - start + 1;
    }
}
