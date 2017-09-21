class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxL = 0;
        Set<Character> arr = new HashSet<>();
        int j = 0;
        int i = 0;
        while (i<s.length()) {
            if (!arr.contains(s.charAt(i))) {
                arr.add(s.charAt(i++));
                maxL = Math.max(maxL, arr.size());
            }
            else {
                arr.remove(s.charAt(j++));
            }
        }
        
        return maxL;
    }
}
