class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int n = s.length();
        int start = 0;
        int end = 0;
        Set<Character> set = new HashSet<>();
        
        while (end < n) {
            if (!set.contains(s.charAt(end))) {
                set.add(s.charAt(end++));
                maxLen = Math.max(maxLen, set.size());
            }
            else {
                set.remove(s.charAt(start++));
            }
        }
        
        return maxLen;
    }
}
