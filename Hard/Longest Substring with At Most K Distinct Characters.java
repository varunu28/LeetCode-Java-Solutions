class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int maxLen = 0;
        int start = 0;
        
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            
            while (map.size() > k) {
                map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                if (map.get(s.charAt(start)) == 0) {
                    map.remove(s.charAt(start));
                }
                
                start++;
            }
            
            maxLen = Math.max(maxLen, i - start + 1);
        }
        
        return maxLen;
    }
}
