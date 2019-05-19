class Solution {
    public int strStr(String haystack, String needle) {
        int start = 0;
        int end = haystack.length() - needle.length() + 1;
        
        while (start < end) {
            if (haystack.substring(start, start + needle.length()).equals(needle)) {
                return start;
            }
            
            start++;
        }
        
        return -1;
    }
}
