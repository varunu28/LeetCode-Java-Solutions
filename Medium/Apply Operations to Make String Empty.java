class Solution {
    public String lastNonEmptyString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxFrequency = 0;
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            maxFrequency = Math.max(maxFrequency, map.get(s.charAt(i)));
        }
        StringBuilder result = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (map.get(s.charAt(i)) == maxFrequency) {
                result.append(s.charAt(i));
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
            }
        }
        return result.reverse().toString();
    }
}
