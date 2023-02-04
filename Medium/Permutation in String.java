class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int n = s1.length();
        int[] count = {map.size()};
        for (int i = 0; i < n - 1; i++) {
            updateMap(map, s2.charAt(i), count, true);
        }
        int start = 0;
        for (int i = n - 1; i < s2.length(); i++) {
            updateMap(map, s2.charAt(i), count, true);
            if (count[0] == 0) {
                return true;
            }
            updateMap(map, s2.charAt(start++), count, false);
        }
        return false;
    }
    
    private void updateMap(Map<Character, Integer> map, char c, int[] count, boolean decrement) {
        if (map.containsKey(c)) {
            int diff = decrement ? -1 : 1;
            map.put(c, map.get(c) + diff);
            if (decrement && map.get(c) == 0) {
                count[0]--;
            }
            if (!decrement && map.get(c) == 1) {
                count[0]++;
            }
        }
    }
}
