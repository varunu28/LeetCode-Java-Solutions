class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Set<Character> set = new HashSet<>();
        int maxLen = Integer.MIN_VALUE;
        
        int i=0, j=0;
        int n = s.length();
        
        while(i<n && j<n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                maxLen = Math.max(maxLen, j-i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        
        return s.length() == 0 ? 0 : maxLen;
    }
}
