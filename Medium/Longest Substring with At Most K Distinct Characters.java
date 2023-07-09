class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int maxLength = 0;
        while (end < s.length()) {
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);
            while (start <= end && map.size() > k) {
                map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                if (map.get(s.charAt(start)) == 0) {
                    map.remove(s.charAt(start));
                }
                start++;
            }
            end++;
            maxLength = Math.max(maxLength, end - start);
        }
        return maxLength;
    }
}
