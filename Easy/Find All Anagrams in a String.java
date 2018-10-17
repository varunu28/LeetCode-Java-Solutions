class Solution {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> indexes = new ArrayList<>();
        Map<Character, Integer> pMap = new TreeMap<>();

        for (char c : p.toCharArray()) {
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> map = new TreeMap<>();

        for (int i=0; i<p.length() && i<s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int i = p.length();
        while (i < s.length()) {
            int ind = i - p.length();         
            if (map.toString().equals(pMap.toString())) {
                indexes.add(ind);
            }
            
            map.put(s.charAt(ind), map.getOrDefault(s.charAt(ind), 0) - 1);
            if (map.get(s.charAt(ind)) <= 0) {
                map.remove(s.charAt(ind));
            }

            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

            i++;
        }

        if (map.toString().equals(pMap.toString())) {
            indexes.add(i-p.length());
        }

        return indexes;
    }
}
