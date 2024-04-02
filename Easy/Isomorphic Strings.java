class Solution {
    public boolean isIsomorphic(String s, String t) {
        return mapString(s).equals(mapString(t));
    }

    private static String mapString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, count++);
            }
            sb.append(map.get(c)).append("|");
        }
        return sb.toString();
    }
}
