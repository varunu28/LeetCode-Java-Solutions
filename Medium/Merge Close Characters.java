class Solution {
    public String mergeCharacters(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c) || sb.length() - map.get(c) >= k) {
                sb.append(c);
                map.put(c, sb.length());
            }
        }
        return sb.toString();
    }
}
